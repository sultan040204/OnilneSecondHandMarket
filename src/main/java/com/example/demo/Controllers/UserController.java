package com.example.demo.Controllers;

import com.example.demo.Entities.UserEntity;
import com.example.demo.Services.UserService;
import com.example.demo.Exception.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity registrations(@RequestBody UserEntity user){
        try {
            return ResponseEntity.ok(userService.registration(user));
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error:404");
        }
    }
    @PostMapping("/sign-in")
    public ResponseEntity signIn(@RequestBody UserEntity user){
        return ResponseEntity.ok(userService.signIn(user));
    }


    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity create( @RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Integer id) {
        Optional<UserEntity> stock = userService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> update(@PathVariable Integer id, @RequestBody UserEntity user) {
        if (!userService.findById(id).isPresent()) {

            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.update(id,user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (!userService.findById(id).isPresent()) {

            ResponseEntity.badRequest().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
