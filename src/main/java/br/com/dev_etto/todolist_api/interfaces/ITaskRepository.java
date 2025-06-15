package br.com.dev_etto.todolist_api.interfaces;

import br.com.dev_etto.todolist_api.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
  List<TaskModel> findByUserId(UUID userId);
}
