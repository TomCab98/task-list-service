package com.projects.taskmanager.core.domain.usecases;

import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.impl.UpdateService;
import com.projects.taskmanager.utils.TestObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateServiceTest {

  private final String ID = "id";

  @Mock
  private IRepositoryPort<TestObject, String> repositoryMock;

  @InjectMocks
  private UpdateService<TestObject, String> updateService;
  private TestObject testObject;
  private TestObject updatedObject;

  @BeforeEach
  void setUp() {
    testObject = new TestObject();

    updatedObject = new TestObject();
    updatedObject.setString("new string");
    updatedObject.setNumber(200);
  }

  @Test
  void update() {
    Optional<TestObject> optionalTestObject = Optional.of(testObject);

    when(repositoryMock.findById(ID)).thenReturn(optionalTestObject);
    when(repositoryMock.create(updatedObject)).thenReturn(updatedObject);

    TestObject result = updateService.update(ID, updatedObject);

    assertNotNull(result);
    assertEquals(updatedObject, result);
    verify(repositoryMock).create(updatedObject);
    verify(repositoryMock).findById(ID);
  }

  @Test
  void createException() {
    Optional<TestObject> optionalTestObject = Optional.empty();

    when(repositoryMock.findById(ID)).thenReturn(optionalTestObject);

    assertThrows(
      NotFoundException.class, () -> {
        updateService.update(ID, updatedObject);
      }
    );
  }
}