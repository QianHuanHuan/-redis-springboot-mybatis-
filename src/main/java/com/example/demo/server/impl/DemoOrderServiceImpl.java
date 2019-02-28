package com.example.demo.server.impl;

import com.example.demo.bean.DemoOrder;
import com.example.demo.dao.DemoOrderDao;
import com.example.demo.server.DemoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoOrderServiceImpl implements DemoOrderService {

    @Autowired
    DemoOrderDao dao;

    @Override
    public DemoOrder find(String id) {
        return dao.find(id);
    }

    @Override
    public List<DemoOrder> finds() {
        return dao.finds();
    }

    @Override
    public int add(DemoOrder order) {
        return dao.add(order);
    }

    @Override
    public int delete(DemoOrder order) {
        return dao.delete(order);
    }

    @Override
    public int update(DemoOrder order) {
        return dao.update(order);
    }
}
