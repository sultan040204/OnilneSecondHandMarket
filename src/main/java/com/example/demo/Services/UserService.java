package com.example.demo.Services;

import com.example.demo.Exception.UserAlreadyExistException;
import com.example.demo.Entities.UserEntity;
import com.example.demo.Model.UserModel;
import com.example.demo.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException {
        if(userRepository.findByLogin(userEntity.getLogin()) != null){
            throw new UserAlreadyExistException("Пользователь существет");
        }
        return userRepository.save(userEntity);
    }
    public ResponseEntity signIn(UserEntity user){
        UserEntity users=userRepository.findByLogin(user.getLogin());
        if (users!=null){
            if (Objects.equals(users.getPassword(), user.getPassword())){
                return ResponseEntity.ok(UserModel.toModel(user));
            }
        }
        else {
            return ResponseEntity.badRequest().body("Error password");
        }
        return ResponseEntity.badRequest().body("Not found");
    }





    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Integer id) {
        return userRepository.findById(id);
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity update(Integer id, UserEntity user){
        UserEntity real= userRepository.findById(id).get();
        if (user.getName()!=null)
            real.setName(user.getName());
        if (user.getId()!=null)
            real.setId(user.getId());

        return userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
