package com.example.patterns.plugin;

public class SumPlugin implements Plugin {
  public void apply(App app) {
    app.setSum((a, b) -> a + b);
  }
}
