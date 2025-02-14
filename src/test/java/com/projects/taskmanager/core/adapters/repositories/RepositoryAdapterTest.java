package com.projects.taskmanager.core.adapters.repositories;

import com.projects.taskmanager.core.adapters.mappers.RepositoryMapper;
import com.projects.taskmanager.core.infraestructure.repositories.IRepository;
import com.projects.taskmanager.utils.TestObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepositoryAdapterTest {

  private final String ID = "id";

  @Mock
  private IRepository<TestObject, String> repositoryMock;

  @Mock
  private RepositoryMapper<TestObject, TestObject> mapperMock;

  @InjectMocks
  private RepositoryAdapter<TestObject, TestObject, String> adapter;

  private TestObject testObject;

  @BeforeEach
  void setUp() {
    testObject = new TestObject();
  }

  @Test
  void create() {
    when(mapperMock.toEntity(testObject)).thenReturn(testObject);
    when(mapperMock.toDomain(testObject)).thenReturn(testObject);
    when(repositoryMock.save(testObject)).thenReturn(testObject);

    TestObject result = adapter.create(testObject);

    assertNotNull(result);
    assertEquals(testObject, result);
    verify(repositoryMock).save(testObject);
  }

  @Test
  void getAll() {
    List<TestObject> testList = Collections.singletonList(testObject);
    when(repositoryMock.findAll()).thenReturn(testList);
    when(mapperMock.toDomainList(testList)).thenReturn(testList);

    List<TestObject> result = adapter.getAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(testObject, result.getFirst());
    verify(repositoryMock).findAll();
  }

  @Test
  void delete() {
    doNothing().when(repositoryMock).deleteById(ID);

    adapter.delete(ID);

    verify(repositoryMock).deleteById(ID);
  }

  @Test
  void findById() {
    Optional<TestObject> optionalObject = Optional.of(testObject);

    when(repositoryMock.findById(ID)).thenReturn(optionalObject);
    when(mapperMock.toDomain(optionalObject)).thenReturn(optionalObject);

    Optional<TestObject> result = adapter.findById(ID);

    Assertions.assertTrue(result.isPresent());
    assertNotNull(result.get());
    assertEquals(testObject, result.get());
    verify(repositoryMock).findById(ID);
  }


}