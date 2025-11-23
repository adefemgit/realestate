package com.example.patterns.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
  private final List<Plugin> plugins = new ArrayList<>();
  private Function<String, String> greetFunc;
  private BiFunction<Integer, Integer, Integer> sumFunc;
  public void use(Plugin plugin) {
    plugins.add(plugin);
    plugin.apply(this);
  }
  public void setGreet(Function<String, String> f) {
    this.greetFunc = f;
  }
  public void setSum(BiFunction<Integer, Integer, Integer> f) {
    this.sumFunc = f;
  }
  public String callGreet(String name) {
    return greetFunc.apply(name);
  }
  public int callSum(int a, int b) {
    return sumFunc.apply(a, b);
  }
}
