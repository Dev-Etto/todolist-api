package br.com.dev_etto.todolist_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_task")
public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  private String description;
  
  @Column(length = 50)
  private String title;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private String priority;
  
  private UUID userId;
  
  @CreationTimestamp
  private LocalDateTime createdAt;
  
  public void setTitle(String title) throws Exception {
    if (title.length() > 50) throw new Exception("O campo title deve conter no maximo 50 caracteres");
    this.title = title;
  }
  
}
