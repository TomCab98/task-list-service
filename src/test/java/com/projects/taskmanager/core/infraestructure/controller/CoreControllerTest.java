package com.projects.taskmanager.core.infraestructure;

import com.projects.taskmanager.core.adapters.controllers.ControllerAdapter;
import com.projects.taskmanager.core.infraestructure.controllers.CoreController;
import com.projects.taskmanager.utils.TestObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CoreControllerTest {

  private final TestObject testObject = new TestObject();
  private final Integer ID = 1;

  @Mock
  private ControllerAdapter<TestObject, TestObject, Integer> adapterMock;

  @InjectMocks
  private CoreController<TestObject, TestObject, Integer> controller;

  @Test
  void create_ShouldReturnDto_WhenAdapterReturnsDomain() {
    when(adapterMock.create(testObject)).thenReturn(testObject);

    ResponseEntity<TestObject> response = controller.create(testObject);

    assertNotNull(response);
    assertEquals(200, response.getStatusCode().value());
    assertEquals(testObject, response.getBody());
    verify(adapterMock, times(1)).create(testObject);
  }

  @Test
  void getAll_ShouldReturnDtoList_WhenAdapterReturnsDomainList() {
    List<TestObject> expected = List.of(testObject);

    when(adapterMock.getAll()).thenReturn(expected);

    List<TestObject> result = controller.getAll();

    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(testObject, result.getFirst());
    verify(adapterMock, times(1)).getAll();
  }

  @Test
  void findById_ShouldReturnDto_WhenAdapterFindsDomain() {
    when(adapterMock.findById(ID)).thenReturn(testObject);

    TestObject result = controller.findById(ID);

    assertNotNull(result);
    assertEquals(testObject, result);
    verify(adapterMock, times(1)).findById(ID);
  }

  @Test
  void update_ShouldReturnUpdatedDto_WhenAdapterUpdatesDomain() {
    when(adapterMock.update(ID, testObject)).thenReturn(testObject);

    ResponseEntity<TestObject> response = controller.update(ID, testObject);

    assertNotNull(response);
    assertEquals(200, response.getStatusCode().value());
    assertEquals(testObject, response.getBody());
    verify(adapterMock, times(1)).update(ID, testObject);
  }

  @Test
  void delete_ShouldCallAdapterDeleteMethod() {
    doNothing().when(adapterMock).delete(ID);

    ResponseEntity<Void> response = controller.delete(ID);

    assertNotNull(response);
    assertEquals(204, response.getStatusCode().value());
    verify(adapterMock, times(1)).delete(ID);
  }
}
