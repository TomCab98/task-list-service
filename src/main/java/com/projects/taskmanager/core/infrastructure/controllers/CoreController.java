package com.projects.taskmanager.core.infrastructure.controllers;

import com.projects.taskmanager.core.adapters.controllers.ControllerAdapter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class CoreController<M, D, ID> {
  private final ControllerAdapter<M, D, ID> adapter;

  @PostMapping
  public ResponseEntity<D> create(@Valid @RequestBody D dto) {
    return ResponseEntity.ok(adapter.create(dto));
  }

  @GetMapping
  public List<D> getAll() {
    return adapter.getAll();
  }

  @GetMapping("/{id}")
  public D findById(@PathVariable ID id) {
    return adapter.findById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<D> update(@PathVariable ID id, @RequestBody D task) {
    return ResponseEntity.ok(adapter.update(id, task));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable ID id) {
    adapter.delete(id);
    return ResponseEntity.noContent().build();
  }
}
