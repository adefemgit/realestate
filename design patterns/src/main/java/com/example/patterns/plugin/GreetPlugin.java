package com.example.patterns.plugin;

public class GreetPlugin implements Plugin {
  public void apply(App app) {
    app.setGreet(name -> "hi " + name);
  }
}
