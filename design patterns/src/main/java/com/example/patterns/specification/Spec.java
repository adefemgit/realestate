package com.example.patterns.specification;

public interface Spec<T> {
  boolean isSatisfiedBy(T e);
  default Spec<T> and(Spec<T> other) { return new AndSpec<>(this, other); }
  default Spec<T> or(Spec<T> other) { return new OrSpec<>(this, other); }
  default Spec<T> not() { return new NotSpec<>(this); }
}
