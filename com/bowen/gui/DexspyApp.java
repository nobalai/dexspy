package com.bowen.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DexspyApp extends Application {

    private static final String TITLE = "Dex file inspector";

    private void initializeMenu(StackPane root) {
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        root.getChildren().addAll(menuBar);
    }

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button();
        button.setText("Say hello world");
        button.setOnAction(event -> System.out.println("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(button);

        initializeMenu(root);

        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
