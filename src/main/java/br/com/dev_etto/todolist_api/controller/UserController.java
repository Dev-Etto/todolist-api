package br.com.dev_etto.todolist_api.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.dev_etto.todolist_api.interfaces.IUserRepository;
import br.com.dev_etto.todolist_api.models.UserModel;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/users")
public class UserController {
  
  @Autowired
  private IUserRepository userRepository;
  
  @PostMapping("/")
  public ResponseEntity create(@RequestBody UserModel userModel) {
    var user = this.userRepository.findByUsername(userModel.getUsername());
    
    if (user != null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
    }
    
    var hashedPassword = BCrypt.withDefaults().hashToString(12, userModel.getPassword()
        .toCharArray());
    
    userModel.setPassword(hashedPassword);
    
    var newUser = this.userRepository.save(userModel);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
  }
}
