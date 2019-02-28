package com.example.demo.server.impl;

import com.example.demo.bean.DemoCommodity;
import com.example.demo.common.pagereq.BasePageReq;
import com.example.demo.common.pageresp.PageBuilder;
import com.example.demo.common.pageresp.Pagination;
import com.example.demo.dao.DemoCommodityDao;
import com.example.demo.server.DemoCommodityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoCommodityServiceImpl implements DemoCommodityService {

    @Autowired
    DemoCommodityDao dao;


    @Override
    public DemoCommodity find(String id) {
        return dao.find(id);
    }

    @Override
    public Pagination<DemoCommodity> finds(BasePageReq req) {

        Page<Object> page = PageHelper.startPage(req.getCurrentPage(), req.getItemsPerPage());
        List<DemoCommodity> demos ;

        demos = dao.finds();

        Pagination<DemoCommodity> limits = PageBuilder.buildPageResult(page, demos);
        return limits;
    }

    @Override
    public int add(DemoCommodity commodity) {
        return dao.add(commodity);
    }

    @Override
    public int delete(DemoCommodity commodity) {
        return dao.delete(commodity);
    }

    @Override
    public int update(DemoCommodity commodity) {
        return dao.update(commodity);
    }


}
