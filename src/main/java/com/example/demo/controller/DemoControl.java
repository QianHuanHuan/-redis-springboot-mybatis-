package com.example.demo.controller;

import com.example.demo.bean.Demo;
import com.example.demo.result.BaseResult;
import com.example.demo.server.DemoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoControl {

    @Autowired
    DemoService demoService;

    @GetMapping("/add")
    public BaseResult add(Demo demo){
        return demoService.add(demo);
    }

    @GetMapping("/findDemoById")
    public Demo findDemoById(String id){
        return demoService.findDemoById(id);
    }

    @GetMapping("/findDemos")
    public List<Demo> findDemos(){
        return demoService.findDemos();
    }

    @GetMapping("/update")
    public BaseResult update(Demo demo){
        return demoService.update(demo);
    }

    @GetMapping("/delete")
    public BaseResult delete(Demo demo){
        return demoService.delete(demo);
    }
}
