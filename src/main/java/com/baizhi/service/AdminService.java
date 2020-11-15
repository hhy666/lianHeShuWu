package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Admin;

public interface AdminService {
    public String login(String username,String password,String code);
    public List<Admin>getAll();
}
