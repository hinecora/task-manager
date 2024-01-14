package net.hinecora.jwttaskmanager.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskRequest request) {
        service.create(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Task getOne(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<Task> edit(@RequestBody TaskRequest request) {
        return new ResponseEntity<>(service.edit(request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        service.delete(id);
        return HttpStatus.OK;
    }

    @PutMapping("/setExecutor")
    public ResponseEntity<Task> setExecutor(@RequestBody TaskRequest request) {
        return new ResponseEntity<>(service.setExecutor(request), HttpStatus.OK);
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<Task> updateStatus(@RequestBody TaskRequest request) {
        return new ResponseEntity<>(service.updateStatus(request), HttpStatus.OK);
    }


}
