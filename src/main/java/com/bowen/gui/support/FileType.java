package com.bowen.gui.support;

import javafx.stage.FileChooser.ExtensionFilter;

public enum FileType {

  DEX("/dex.png", "dex class", "*.dex", new FileParser()),
  APK("/apk.png", "apk file", "*.apk", new FileParser()),
  ;

  public final String icon;
  public final ExtensionFilter extensionFilter;
  public final FileParser fileParser;

  FileType(String icon, String description, String extension, FileParser fileParser) {
    this.icon = icon;
    this.extensionFilter = new ExtensionFilter(description, extension);
    this.fileParser = fileParser;
  }
}
