package br.com.dev_etto.todolist_api.controller;

import br.com.dev_etto.todolist_api.interfaces.ITaskRepository;
import br.com.dev_etto.todolist_api.models.TaskModel;
import br.com.dev_etto.todolist_api.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
  
  @Autowired
  private ITaskRepository taskRepository;
  
  @PostMapping("/")
  public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
    var userId = request.getAttribute("userId");
    
    taskModel.setUserId((UUID) userId);
    
    var currentDate = LocalDateTime.now();
    
    if (currentDate.isAfter(taskModel.getStartDate()) || currentDate.isAfter(taskModel.getEndDate())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("A data de inicio / data de termino, deve ser maior do que a data atual");
    }
    
        if (taskModel.getStartDate().isAfter(taskModel.getEndDate())) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("A data de inicio não deve ser maior do que a data de fim");
    }
    
    var task = this.taskRepository.save(taskModel);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(task);
  }
  
  
  @GetMapping("/")
  public List<TaskModel> list(HttpServletRequest request) {
    var userId = request.getAttribute("userId");
    
    return this.taskRepository.findByUserId((UUID) userId);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity update(@RequestBody TaskModel taskModel, @PathVariable UUID id, HttpServletRequest request) {
    var task = this.taskRepository.findById(id).orElse(null);

    if (task == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task não encontrada.");
    }
    
    var userId = request.getAttribute("userId");
    
    if (!task.getUserId().equals(userId)) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não tem permissão para alterar essa task.");
    }
    
    
    Utils.copyNonNullProperties(taskModel, task);
    
    var updatedTask = this.taskRepository.save(task);
    
    return  ResponseEntity.status(HttpStatus.OK).body(updatedTask);
  }
}
