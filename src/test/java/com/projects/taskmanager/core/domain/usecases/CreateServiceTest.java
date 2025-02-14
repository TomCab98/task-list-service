package com.projects.taskmanager.core.domain.usecases;

import com.projects.taskmanager.core.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.utils.TestObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateServiceTest {

  @Mock
  private IRepositoryPort<TestObject, String> repositoryMock;

  @InjectMocks
  private CreateService<TestObject, String> createService;

  private TestObject testObject;

  @BeforeEach
  void setUp() {
    testObject = new TestObject();
  }

  @Test
  void create() {
    when(repositoryMock.create(testObject)).thenReturn(testObject);

    TestObject result = createService.create(testObject);

    assertNotNull(result);
    assertEquals(testObject, result);
    verify(repositoryMock).create(testObject);
  }

  @Test
  void createException() {
    when(repositoryMock.create(testObject)).thenThrow(new RuntimeException("Database error"));

    assertThrows(
      DatabaseAccessException.class, () -> {
        createService.create(testObject);
      }
    );
  }
}