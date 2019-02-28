package com.example.demo.server;

import com.example.demo.bean.DemoOrder;

import java.util.List;

public interface DemoOrderService {


    DemoOrder find(String id);
    List<DemoOrder> finds();
    int add(DemoOrder order);
    int delete(DemoOrder order);
    int update(DemoOrder order);
}
