package com.example.patterns.specification;

public class NotSpec<T> implements Spec<T> {
  private final Spec<T> a;
  public NotSpec(Spec<T> a) {
    this.a = a;
  }
  public boolean isSatisfiedBy(T e) {
    return !a.isSatisfiedBy(e);
  }
}
