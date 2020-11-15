package com.baizhi.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;

public class AdminTest {
    @Test
    public void test1(){
		String i = UUID.randomUUID().toString();
		System.out.println(i);
    }
}

