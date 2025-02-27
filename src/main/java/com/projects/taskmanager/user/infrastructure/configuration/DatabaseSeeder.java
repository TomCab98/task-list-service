package com.projects.taskmanager.user.infrastructure.configuration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DatabaseSeeder implements ApplicationRunner {
  private final DataSource dataSource;

  public DatabaseSeeder(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void run(ApplicationArguments args) {
    try (Connection connection = dataSource.getConnection()) {
      ScriptUtils.executeSqlScript(connection, new ClassPathResource("import.sql"));
      System.out.println("Introduced data");
    } catch (Exception e) {
      System.out.println("not was possible insert data");
    }
  }
}
