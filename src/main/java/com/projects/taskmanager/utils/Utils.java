package com.projects.taskmanager.utils;

import java.util.Objects;

public class Utils {
  public static boolean isNotBlank(String string) {
    return (Objects.nonNull(string) && !"".equalsIgnoreCase(string));
  }
}
