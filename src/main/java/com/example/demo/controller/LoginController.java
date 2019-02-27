package com.example.demo.controller;

import com.example.demo.bean.Demo;
import com.example.demo.result.BaseResult;
import com.example.demo.server.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    @ApiOperation(value = "系统登录管理")
    public BaseResult login(Demo demo){
        return userService.login(demo);
    }

}
