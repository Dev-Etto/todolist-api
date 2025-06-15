package br.com.dev_etto.todolist_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.UUID;

@Data
@Entity(name = "tb_user")
public class UserModel {
  
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  
  @Column(unique = true)
  private String username;
  private String name;
  private String password;
  
  @CreationTimestamp
  private String createdAt;
  
}
