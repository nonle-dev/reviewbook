/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nonle
 */
public class User {

    private Long id;
    private String username;
    private String password;
    private String fullname;
    private int age;
    private boolean gender;

    public User() {
    }

    public User( String username, String password, String fullname, int age, boolean gender) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
    }

    public User(Long id, String username, String password, String fullname, int age, boolean gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

}
