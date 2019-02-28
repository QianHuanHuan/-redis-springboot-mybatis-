package com.example.demo.server;

import com.example.demo.bean.DemoCommodity;
import com.example.demo.common.pagereq.BasePageReq;
import com.example.demo.common.pageresp.Pagination;


public interface DemoCommodityService {

    DemoCommodity find(String id);
    Pagination<DemoCommodity> finds(BasePageReq req);
    int add(DemoCommodity commodity);
    int delete(DemoCommodity commodity);
    int update(DemoCommodity commodity);

}
