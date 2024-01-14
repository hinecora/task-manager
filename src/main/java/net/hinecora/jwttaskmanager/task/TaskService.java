package net.hinecora.jwttaskmanager.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public void create(TaskRequest request) {
        var task = Task.builder()
                .id(request.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .author(request.getAuthor())
                .executor(request.getExecutor())
                .status(Status.В_ОЖИДАНИИ)
                .priority(request.getPriority())
                .build();
        repository.save(task);
    }

    public Task getById(Integer id) {
        return repository.findById(id).get();
    }

    public Task edit(TaskRequest request) {
        Task task = getById(request.getId());

        if (request.getTitle() != null) {
            task.setTitle(request.getTitle());
        }

        if (request.getDescription() != null) {
            task.setDescription(request.getDescription());
        }

        if (request.getPriority() != null) {
            task.setPriority(request.getPriority());
        }
        return repository.save(task);
    }
    public Task updateStatus(TaskRequest request) {
        Task task = getById(request.getId());
        if (request.getStatus() != null) {
            task.setStatus(request.getStatus());
        }
        return repository.save(task);
    }
    public Task setExecutor(TaskRequest request) {
        Task task = getById(request.getId());
        task.setExecutor(request.getExecutor());
        task.setStatus(Status.В_ПРОЦЕССЕ);
        return repository.save(task);
    }
    public List<Task> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
