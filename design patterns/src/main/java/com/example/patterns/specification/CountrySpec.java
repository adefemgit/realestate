package com.example.patterns.specification;

public class CountrySpec implements Spec<Person> {
  private final String c;
  public CountrySpec(String c) {
    this.c = c;
  }
  public boolean isSatisfiedBy(Person p) {
    return p.country.equals(c);
  }
}
