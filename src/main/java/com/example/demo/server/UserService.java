package com.example.demo.server;

import com.example.demo.bean.Demo;
import com.example.demo.result.BaseResult;

public interface UserService {

    BaseResult login(Demo demo);

}
