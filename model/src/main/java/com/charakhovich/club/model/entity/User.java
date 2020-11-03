package com.charakhovich.club.model.entity;

public class User extends Entity {
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;
    private String login;
    private Role role;
    private boolean isActual;

    public User() {
    }

    public User(long id, String firstName, String lastName, String phone, String email, String login, String password,
                Role role, boolean isActual) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isActual = isActual;
    }

    public User(String firstName, String lastName, String phone, String email, String login, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.role = role;
        this.isActual = true;
    }

    public String fullName() {
        StringBuilder strResult = new StringBuilder(this.firstName);
        strResult.append(" ").append(this.lastName);
        return strResult.toString();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActual() {
        return isActual;
    }

    public void setActual(boolean actual) {
        isActual = actual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                isActual() == user.isActual() &&
                getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName()) &&
                getPhone().equals(user.getPhone()) &&
                getEmail().equals(user.getEmail()) &&
                getLogin().equals(user.getLogin()) &&
                getRole() == user.getRole();
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + Long.hashCode(this.getId());
        result = result * prime + firstName.hashCode();
        result = result * prime + lastName.hashCode();
        result = result * prime + login.hashCode();
        result = result * prime + role.hashCode();
        return result;
    }

    public String toString() {
        StringBuilder strResult = new StringBuilder("User:");
        strResult.append("{userId=").append(id).append(';');
        strResult.append(" lastName=").append(lastName).append(';');
        strResult.append(" firstName=").append(firstName).append(';');
        strResult.append(" login=").append(login).append(';');
        strResult.append(" role=").append(role).append('.');
        return strResult.toString();
    }

}

