package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;

public interface UserDao {
    public User selectUserByEmail(String email);
    public User selectUserByUserId(String userId);
    public void insertUser(User user);
    public void updateUser(User user);
    public List<User> selectAllUser();
    public void updateUser1(User user);
   
}
