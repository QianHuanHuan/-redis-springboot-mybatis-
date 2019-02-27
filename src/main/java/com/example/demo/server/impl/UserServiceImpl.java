package com.example.demo.server.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Demo;
import com.example.demo.common.RedisRepository;
import com.example.demo.result.BaseResult;
import com.example.demo.server.DemoService;
import com.example.demo.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisRepository repository;

    @Autowired
    DemoService demoService;

    @Override
    public BaseResult login(Demo demo) {
        BaseResult baseResult;
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
