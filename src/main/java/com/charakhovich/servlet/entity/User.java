package com.charakhovich.servlet.entity;

public class User extends Entity{
    private int id;
    private String login;
    private String password;
    public User() {
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id).append(", login='").append(login).append('}');
        return sb.toString();
    }
}

