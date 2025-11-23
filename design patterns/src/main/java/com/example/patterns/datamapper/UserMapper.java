package com.example.patterns.datamapper;

import java.util.HashMap;
import java.util.Map;

public class UserMapper {
  private final Map<Long, Row> db = new HashMap<>();
  public User find(long id) {
    Row r = db.get(id);
    if (r == null) return null;
    return new User(r.id, r.name);
  }
  public void insert(User u) {
    db.put(u.id, new Row(u.id, u.name));
  }
}
