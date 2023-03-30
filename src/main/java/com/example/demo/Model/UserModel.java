package com.example.demo.Model;

import com.example.demo.Entities.UserEntity;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;


public class UserModel {
    private Integer id;
    private String name;
    private String lastname;
    private String login;
    private String password;
    private String phone;

    public static UserModel toModel (UserEntity userEntity){
        UserModel model = new UserModel();
        model.setId(userEntity.getId());
        model.setName(userEntity.getName());
        model.setLastname(userEntity.getLastname());
        model.setLogin(userEntity.getLogin());
        model.setPassword(userEntity.getPassword());
        model.setPhone(userEntity.getPhone());
       return model;

    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
