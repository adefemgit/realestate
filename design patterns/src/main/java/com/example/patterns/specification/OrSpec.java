package com.example.patterns.specification;

public class OrSpec<T> implements Spec<T> {
  private final Spec<T> a;
  private final Spec<T> b;
  public OrSpec(Spec<T> a, Spec<T> b) {
    this.a = a;
    this.b = b;
  }
  public boolean isSatisfiedBy(T e) {
    return a.isSatisfiedBy(e) || b.isSatisfiedBy(e);
  }
}
