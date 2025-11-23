package com.example.patterns.specification;

public class AgeSpec implements Spec<Person> {
  private final int min;
  public AgeSpec(int min) {
    this.min = min;
  }
  public boolean isSatisfiedBy(Person p) {
    return p.age >= min;
  }
}
