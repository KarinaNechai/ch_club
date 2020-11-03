package com.charakhovich.club.model.service;

import com.charakhovich.club.model.entity.User;
import com.charakhovich.club.model.exeption.ServiceException;

public interface UserService {
     boolean checkLogin (String login,String password) throws ServiceException;
     User findUserByLogin(String login) throws ServiceException;

}
