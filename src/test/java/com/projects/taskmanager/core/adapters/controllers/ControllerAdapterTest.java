package com.projects.taskmanager.core.adapters.controllers;

import com.projects.taskmanager.core.adapters.mappers.ControllerMapper;
import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.core.domain.usecases.impl.DeleteService;
import com.projects.taskmanager.core.domain.usecases.impl.FindService;
import com.projects.taskmanager.core.domain.usecases.impl.UpdateService;
import com.projects.taskmanager.utils.TestObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControllerAdapterTest {

  @Mock
  private FindService<TestObject, String> findServiceMock;

  @Mock
  private DeleteService<TestObject, String> deleteServiceMock;

  @Mock
  private UpdateService<TestObject, String> updateServiceMock;

  @Mock
  private CreateService<TestObject, String> createServiceMock;

  @Mock
  private ControllerMapper<TestObject, TestObject> mapperMock;

  @InjectMocks
  private ControllerAdapter<TestObject, TestObject, String> adapter;

  private TestObject testObject;

  @BeforeEach
  void setUp() {
    testObject = new TestObject();
  }

  @Test
  void create() {
    when(mapperMock.toDomain(testObject)).thenReturn(testObject);
    when(createServiceMock.create(testObject)).thenReturn(testObject);
    when(mapperMock.toDto(testObject)).thenReturn(testObject);

    TestObject result = adapter.create(testObject);

    assertNotNull(result);
    assertEquals(testObject, result);
    verify(createServiceMock).create(testObject);
  }

  @Test
  void getAll() {
    List<TestObject> testList = Collections.singletonList(testObject);
    when(findServiceMock.findAll()).thenReturn(testList);
    when(mapperMock.toDtoList(testList)).thenReturn(testList);

    List<TestObject> result = adapter.getAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(testObject, result.getFirst());
    verify(findServiceMock).findAll();
  }

  @Test
  void update() {
    when(mapperMock.toDomain(testObject)).thenReturn(testObject);
    when(updateServiceMock.update("id", testObject)).thenReturn(testObject);
    when(mapperMock.toDto(testObject)).thenReturn(testObject);

    TestObject result = adapter.update("id", testObject);

    assertNotNull(result);
    assertEquals(testObject, result);
    verify(updateServiceMock).update("id", testObject);
  }

  @Test
  void delete() {
    doNothing().when(deleteServiceMock).delete("id");

    adapter.delete("id");

    verify(deleteServiceMock).delete("id");
  }

  @Test
  void findById() {
    when(findServiceMock.findById("id")).thenReturn(testObject);
    when(mapperMock.toDto(testObject)).thenReturn(testObject);

    TestObject result = adapter.findById("id");

    assertNotNull(result);
    assertEquals(testObject, result);
    verify(findServiceMock).findById("id");
  }
}