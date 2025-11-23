package com.example.patterns.nullobject;

public class ConsoleLogger implements Logger {
  public void log(String msg) {
    System.out.println(msg);
  }
}
