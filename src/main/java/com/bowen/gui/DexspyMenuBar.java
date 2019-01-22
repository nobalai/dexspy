package com.bowen.gui;

import com.bowen.gui.support.FileType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Dexspy menu bar.
 *
 * File              Window        Help
 *  |-Open >         |-New Window  |-About
 *    |-Dex file...
 *    |-Apk file...
 *  |-Open Recent >
 *  |-Exit
 */
class DexspyMenuBar extends MenuBar {

  DexspyMenuBar() {
    createFileMenu();
    createWindowMenu();
    createHelpMenu();
  }

  private void createFileMenu() {
    Menu fileMenu = new Menu("_File");
    fileMenu.getItems().addAll(createOpenMenu(), createExitMenuItem());
    getMenus().add(fileMenu);
  }

  private Menu createOpenMenu() {
    Menu openMenu = new Menu("_Open");
    openMenu.getItems().addAll(createOpenMenuItem(FileType.DEX), createOpenMenuItem(FileType.APK));
    return openMenu;
  }

  private MenuItem createOpenMenuItem(FileType fileType) {
    String description = fileType.extensionFilter.getDescription();
    MenuItem menuItem = new MenuItem(description);
    return menuItem;
  }

  private MenuItem createExitMenuItem() {
    MenuItem exit = new MenuItem("_Exit");
    exit.setOnAction(event -> System.exit(0));
    return exit;
  }

  private void createWindowMenu() {
    MenuItem newWindowMenuItem = new MenuItem("_New Window");

    Menu windowMenu = new Menu("_Window");
    windowMenu.getItems().add(newWindowMenuItem);
    getMenus().add(windowMenu);
  }

  private void createHelpMenu() {
    MenuItem aboutMenuItem = new MenuItem("_About");

    Menu helpMenu = new Menu("_Help");
    helpMenu.getItems().add(aboutMenuItem);
    getMenus().add(helpMenu);
  }
}
