package com.projects.taskmanager.utils;

import lombok.Data;

@Data
public class TestObject {
  String string;
  Integer number;

  public TestObject() {
    string = "test";
    number = 100;
  }
}
