package com.example.demo.server;

import com.example.demo.bean.Demo;
import com.example.demo.result.BaseResult;

import java.util.List;

public interface DemoService {

    BaseResult add( Demo demo);
    Demo findDemoById(String id);
    List<Demo> findDemos();
    BaseResult update(Demo demo);
    BaseResult delete(Demo demo);
    int findDemoBySingName(String signName);
    Demo existentialJudgement(Demo demo);
}
