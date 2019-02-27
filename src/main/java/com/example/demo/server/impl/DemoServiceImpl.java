package com.example.demo.server.impl;

import com.example.demo.bean.Demo;
import com.example.demo.dao.DemoDao;
import com.example.demo.result.BaseResult;
import com.example.demo.server.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoDao dao ;

    @Override
    public BaseResult add(Demo demo) {
        return BaseResult.findBaseResult(dao.add(demo));
    }

    @Override
    public Demo findDemoById(String id) {
        return dao.findDemoById(id);
    }

    @Override
    public List<Demo> findDemos() {
        return dao.findDemos();
    }

    @Override
    public BaseResult update(Demo demo) {
        return BaseResult.findBaseResult(dao.update(demo));
    }

    @Override
    public BaseResult delete(Demo demo) {
        return BaseResult.findBaseResult(dao.delete(demo));
    }

    @Override
    public int findDemoBySingName(String signName){
        return dao.findDemoBySingName(signName);
    }

    @Override
    public Demo existentialJudgement(Demo demo){
        return dao.existentialJudgement(demo);
    }

}
