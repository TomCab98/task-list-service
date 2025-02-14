package com.projects.taskmanager.core.domain.usecases;

import com.projects.taskmanager.core.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.impl.DeleteService;
import com.projects.taskmanager.core.domain.usecases.impl.FindService;
import com.projects.taskmanager.utils.TestObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteServiceTest {

  private final String ID = "id";

  @Mock
  private IRepositoryPort<TestObject, String> repositoryMock;

  @Mock
  private FindService<TestObject, String> findServiceMock;

  @InjectMocks
  private DeleteService<TestObject, String> deleteService;

  @Test
  void delete() {
    when(findServiceMock.existById(ID)).thenReturn(true);

    deleteService.delete(ID);

    verify(repositoryMock).delete(ID);
  }

  @Test
  void ticketNotFoundException() {
    when(findServiceMock.existById(ID)).thenReturn(false);

    assertThrows(
      NotFoundException.class, () -> {
        deleteService.delete(ID);
      }
    );
  }

  @Test
  void databaseAccessException() {
    when(findServiceMock.existById(ID)).thenReturn(true);
    doThrow(new RuntimeException()).when(repositoryMock).delete(ID);

    assertThrows(
      DatabaseAccessException.class, () -> {
        deleteService.delete(ID);
      }
    );
  }
}
