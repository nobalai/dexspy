package com.bowen.gui;

import com.sun.istack.internal.NotNull;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DexspyApp extends Application {

    private static final String TITLE = "Dex file inspector";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button();
        button.setText("Say hello world");
        button.setOnAction(event -> System.out.println("Hello World!"));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        VBox vBox = new VBox();
        initializeMenu(vBox);
        vBox.getChildren().add(stackPane);

        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(vBox, 300, 250));
        primaryStage.show();
    }

    private void initializeMenu(@NotNull VBox vBox) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> System.exit(0));
        fileMenu.getItems().addAll(exit);

        Menu helpMenu = new Menu("Help");
        MenuItem about = new MenuItem("About");
        helpMenu.getItems().addAll(about);

        menuBar.getMenus().addAll(fileMenu, helpMenu);
        vBox.getChildren().addAll(menuBar);
    }
}
