package com.charakhovich.club.model.dao;

import com.charakhovich.club.model.entity.User;
import com.charakhovich.club.model.exeption.DaoException;
import com.charakhovich.club.model.entity.Role;
import com.charakhovich.club.model.entity.Page;
import java.util.List;

public interface UserDao {
    boolean checkLogin(String login, String password) throws DaoException;
 //   int save(User user);//create- boolean
 //   int delete(int userId);//delete -boolean
  //  int delete (User user);//delete -boolean
     User findUserByLogin(String login) throws DaoException;
 //   User getUserById(int userId);()//find entity by Id
    int count(Role role);
    List<User> findByRole(Role role);
    List<User> findByRole(Role role, Page page);
    User login(String login, String password);//heckLogin
}
