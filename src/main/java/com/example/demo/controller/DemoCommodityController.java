package com.example.demo.controller;

import com.example.demo.bean.DemoCommodity;
import com.example.demo.common.pagereq.BasePageReq;
import com.example.demo.common.pageresp.Pagination;
import com.example.demo.server.DemoCommodityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.result.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "/demoCommodity")
public class DemoCommodityController {

    @Autowired
    DemoCommodityService commodityService;

    @PostMapping("/saveDemoCommodity")
    @ApiOperation("添加商品信息")
    public BaseResult saveDemoCommodity(DemoCommodity demoCommodity){
        return BaseResult.findBaseResult(commodityService.add(demoCommodity));
    }

    @GetMapping("/findDemoCommodity")
    @ApiOperation("查询商品信息")
    public DemoCommodity findDemoCommodity(String id){
        return commodityService.find(id);
    }

    @GetMapping("/findDemoCommoditys")
    @ApiOperation("查询商品信息列表")
    public Pagination<DemoCommodity> findDemoCommoditys(BasePageReq req){
        return commodityService.finds(req);
    }

}
