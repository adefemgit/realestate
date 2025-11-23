package com.example.patterns.objectpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Supplier;

public class Pool<T> {
  private final Supplier<T> create;
  private final Deque<T> items;
  public Pool(Supplier<T> create, int size) {
    this.create = create;
    this.items = new ArrayDeque<>();
    for (int i = 0; i < size; i++) {
      items.push(create.get());
    }
  }
  public T acquire() {
    T t = items.poll();
    return t != null ? t : create.get();
  }
  public void release(T t) {
    items.push(t);
  }
}
