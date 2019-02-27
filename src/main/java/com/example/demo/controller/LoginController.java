package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Demo;
import com.example.demo.common.RedisRepository;
import com.example.demo.result.BaseResult;
import com.example.demo.server.DemoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    DemoService demoService;
    @Autowired
    RedisRepository repository;

    @GetMapping("/login")
    @ApiOperation(value = "系统登录管理")
    public BaseResult login(Demo demo){
        BaseResult baseResult = null;
        int i = demoService.findDemoBySingName(demo.getSignName());

        if (i!=0){
            demo = demoService.existentialJudgement(demo);
            if (demo == null){
                baseResult = new BaseResult("error","密码错误");
            }else{

                long liveTime = 50000L;
                String json = JSON.toJSONString(demo);
                repository.set(demo.getId(),json,liveTime);



                baseResult = new BaseResult("ok","登录成功");
            }
        }else {
            baseResult = new BaseResult("error","用户不存在");
        }
        return baseResult;
    }

}
