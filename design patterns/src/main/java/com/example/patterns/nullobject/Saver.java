package com.example.patterns.nullobject;

public class Saver {
  public void save(Repository repo, Logger logger) {
    logger.log("saving");
    repo.save();
  }
}
