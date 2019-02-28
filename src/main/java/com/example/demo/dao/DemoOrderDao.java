package com.example.demo.dao;

import com.example.demo.bean.DemoOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DemoOrderDao {

    @Select("SELECT * FROM demo_order WHERE id = #{id}")
    DemoOrder find(@Param("id") String id);

    @Select("SELECT * FROM demo_order ")
    List<DemoOrder> finds();

    @Insert("INSERT INTO demo_order(id, order_number, demo_id, commodity_id, sum, remarks, unit_price) " +
            "VALUES " +
            "(#{demoOrder.id}, #{demoOrder.orderNumber}, #{demoOrder.demoId}, #{demoOrder.commodityId}, #{demoOrder.sum}, #{demoOrder.remarks}, #{demoOrder.unitPrice})")
    int add(@Param("demoOrder") DemoOrder demoOrder);

    @Update("UPDATE demo_order " +
            "SET " +
            "order_number = #{demoOrder.orderNumber}, demo_id = #{demoOrder.demoId}, commodity_id = #{demoOrder.commodityId}, " +
            "sum = #{demoOrder.sum}, remarks = #{demoOrder.remarks}, unit_price = #{demoOrder.unitPrice} " +
            "WHERE id = #{demoOrder.id}")
    int update(@Param("demoOrder") DemoOrder demoOrder);

    @Delete("DELETE demo_order WHERE id = #{demoOrder.id}")
    int delete(@Param("demoOrder") DemoOrder demoOrder);


}
