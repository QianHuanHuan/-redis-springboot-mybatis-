package com.example.demo.controller;

import com.example.demo.bean.DemoOrder;
import com.example.demo.server.DemoOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.result.BaseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/demoOrder")
public class DemoOrderController {

    @Autowired
    DemoOrderService orderService;

    @PostMapping("/saveDemoOrder")
    @ApiOperation("保存订单")
    public BaseResult saveDemoOrder(DemoOrder demoOrder){
        return  BaseResult.findBaseResult(orderService.add(demoOrder));
    }

    @PostMapping("/findDemoOrder")
    @ApiOperation("查询订单")
    public DemoOrder findDemoOrder(String id){
        return orderService.find(id);
    }

    @PostMapping("/findDemoOrders")
    @ApiOperation("查询全部订单")
    public List<DemoOrder> findDemoOrders(){
        return orderService.finds();
    }


}
