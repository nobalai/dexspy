package com.bowen.gui;

import com.bowen.utils.ImageHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DexspyApp extends Application {

  private static final String TITLE = "Dex file inspector";

  private Stage primaryStage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;

    BorderPane borderPane = new BorderPane();
    borderPane.setTop(createMenu());
//    borderPane.setCenter();

    Scene scene = new Scene(borderPane, /*width=*/960, /*height=*/540);

    primaryStage.setTitle(TITLE);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private MenuBar createMenu() {
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File", ImageHelper.createImageView("/resources/file.png"));
    MenuItem exit = new MenuItem("Exit");
    exit.setOnAction(event -> System.exit(0));
    fileMenu.getItems().addAll(exit);

    Menu helpMenu = new Menu("Help");
    MenuItem about = new MenuItem("About");
    helpMenu.getItems().addAll(about);

    menuBar.getMenus().addAll(fileMenu, helpMenu);

    return menuBar;
  }

}
