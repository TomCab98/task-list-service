package com.projects.taskmanager.core.domain.usecases;

import com.projects.taskmanager.core.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.impl.FindService;
import com.projects.taskmanager.utils.TestObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

  private final String ID = "id";

  @Mock
  private IRepositoryPort<TestObject, String> repositoryMock;

  @InjectMocks
  private FindService<TestObject, String> findService;
  private TestObject testObject;

  @BeforeEach
  void setUp() {
    testObject = new TestObject();
  }

  @Test
  void findAll() {
    when(repositoryMock.getAll()).thenReturn(List.of(new TestObject[]{ testObject, testObject }));

    List<TestObject> result = findService.findAll();

    assertNotNull(result);
    assertEquals(testObject, result.getFirst());
    assertEquals(2, result.size());
    verify(repositoryMock).getAll();
  }

  @Test
  void findAllDatabaseException() {
    when(repositoryMock.getAll()).thenThrow(new RuntimeException("Database error"));

    assertThrows(
      DatabaseAccessException.class, () -> {
        findService.findAll();
      }
    );
  }

  @Test
  void findById() {
    Optional<TestObject> optionalTestObject = Optional.of(testObject);

    when(repositoryMock.findById(ID)).thenReturn(optionalTestObject);

    TestObject result = findService.findById(ID);

    assertNotNull(result);
    assertEquals(testObject, result);
    verify(repositoryMock).findById(ID);
  }

  @Test
  void findByIdDatabaseException() {
    when(repositoryMock.findById(ID)).thenThrow(new RuntimeException("Database error"));

    assertThrows(
      DatabaseAccessException.class, () -> {
        findService.findById(ID);
      }
    );
  }

  @Test
  void findByIdNotFoundException() {
    Optional<TestObject> optionalTestObject = Optional.empty();

    when(repositoryMock.findById(ID)).thenReturn(optionalTestObject);

    assertThrows(
      NotFoundException.class, () -> {
        findService.findById(ID);
      }
    );
  }

  @Test
  void existById() {
    Optional<TestObject> optionalTestObject = Optional.of(testObject);

    when(repositoryMock.findById(ID)).thenReturn(optionalTestObject);

    boolean result = findService.existById(ID);

    assertTrue(result);
    verify(repositoryMock).findById(ID);
  }
}