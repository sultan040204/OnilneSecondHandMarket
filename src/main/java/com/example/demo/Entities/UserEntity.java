package com.example.demo.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user",schema = "public")
public class UserEntity {
    @Id
    @Column(name = "id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone")
    private String phone;

    @OneToMany
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private List<ProductEntity> products =new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private List<FavoritesEntity> favorite =new ArrayList<>();

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> cities) {
        this.products = cities;
    }




    public List<FavoritesEntity> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<FavoritesEntity> favorite) {
        this.favorite = favorite;
    }




    public UserEntity(){

    }
    public UserEntity(String name){
        this.name=name;
    }

    public UserEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
