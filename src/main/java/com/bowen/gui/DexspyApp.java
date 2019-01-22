package com.bowen.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DexspyApp extends Application {

  private static final String TITLE = "Dex file inspector";

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();
    borderPane.setTop(createMenu());

    Scene scene = new Scene(borderPane, /*width=*/960, /*height=*/540);

    primaryStage.setTitle(TITLE);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private MenuBar createMenu() {
    DexspyMenuBar dexspyMenuBar = new DexspyMenuBar();

    Menu helpMenu = new Menu("Help");
    MenuItem about = new MenuItem("About");
    helpMenu.getItems().addAll(about);

    return dexspyMenuBar;
  }

}
