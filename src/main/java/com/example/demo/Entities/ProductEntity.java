package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "products",schema = "public")
public class ProductEntity {
    @Id
    @Column(name = "id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @NotNull
    private Integer price;

    @Column(name = "image_one")
    private String imageOne;

    @Column(name = "image_two")
    private String imageTwo;

    @Column(name = "image_three")
    private String imageThree;

    @Column(name = "filter")
    private String filter;

    @Column(name = "active")
    @NotNull
    private boolean active;

    @Column(name = "data")
    private String data;

    @JsonIgnore
    @Column(name = "userId")
    private Integer userId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private UserEntity user;

    @JsonIgnore
    public Integer getUserId() {
        return userId;
    }
    @JsonProperty
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageOne() {
        return imageOne;
    }

    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(String imageTwo) {
        this.imageTwo = imageTwo;
    }

    public String getImageThree() {
        return imageThree;
    }

    public void setImageThree(String imageThree) {
        this.imageThree = imageThree;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ProductEntity(){

    }
    public ProductEntity(Integer id, String name, Integer userId) {
        this.id = id;
        this.name = name;
        this.userId=userId;

    }

    public ProductEntity(Integer id, String name, String description, Integer price, String imageOne, String imageTwo, String imageThree, String filter, boolean active, String data, Integer userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageOne = imageOne;
        this.imageTwo = imageTwo;
        this.imageThree = imageThree;
        this.filter = filter;
        this.active = active;
        this.data = data;
        this.userId = userId;
    }
}
