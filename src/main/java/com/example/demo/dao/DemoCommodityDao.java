package com.example.demo.dao;

import com.example.demo.bean.DemoCommodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DemoCommodityDao {

    @Select("SELECT * FROM demo_commodity WHERE id = #{id}")
    DemoCommodity find(@Param("id") String id);

    @Select("SELECT * FROM demo_commodity ")
    List<DemoCommodity> finds();

    @Insert("INSERT INTO demo_commodity(id, name, price, stock) " +
            "VALUES " +
            "(#{demoCommodity.id}, #{demoCommodity.name}, #{demoCommodity.price}, #{demoCommodity.stock})")
    int add(@Param("demoCommodity") DemoCommodity demoCommodity);

    @Update("UPDATE demo_commodity " +
            "SET " +
            "name = #{demoCommodity.name}, price = #{demoCommodity.price}, stock = #{demoCommodity.stock} " +
            "WHERE id = #{demoCommodity.id}")
    int update(@Param("demoCommodity") DemoCommodity demoCommodity);

    @Delete("DELETE demo_commodity WHERE id = #{demoCommodity.id}")
    int delete(@Param("demoCommodity") DemoCommodity demoCommodity);
}
