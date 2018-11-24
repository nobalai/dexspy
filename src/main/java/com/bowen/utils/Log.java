package com.bowen.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

  public static void d(String tag, String msg) {
    Logger logger = Logger.getLogger(tag);
    logger.log(Level.FINEST, msg);
  }

  public static void i(String tag, String msg) {
    Logger logger = Logger.getLogger(tag);
    logger.log(Level.INFO, msg);
  }

  public static void w(String tag, String msg) {
    Logger logger = Logger.getLogger(tag);
    logger.log(Level.WARNING, msg);
  }

  public static void f(String tag, String msg) {
    Logger logger = Logger.getLogger(tag);
    logger.log(Level.SEVERE, msg);
  }
}
