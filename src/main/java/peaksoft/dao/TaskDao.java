package peaksoft.dao;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskDao {

    void saveTask(Long lessonId, Task task);

    void updateTask(Long id,Task task);

    Task getTaskById(Long id);

    List<Task> getAllTasks(Long id);

    void deleteTaskById(Long id);
}
