package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;

public interface AdminDao {
    public Admin queryAdminByUsername(String username);
    public List<Admin>queryAll();
}
