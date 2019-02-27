package com.example.demo.dao;

import com.example.demo.bean.Demo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DemoDao {

    /**
     * 插入demo
     * @param demo
     * @return
     */
    @Insert("INSERT INTO demo( user_name, sign_name, pass_word, gender, age, introduction) " +
            "VALUES " +
            "(#{demo.userName}, #{demo.signName}, #{demo.passWord}, #{demo.gender}, #{demo.age}, #{demo.introduction})")
    int add(@Param("demo") Demo demo);

    @Select("SELECT * FROM demo d WHERE d.id = #{id}")
    Demo findDemoById(@Param("id") String id);

    /**
     * 查询列表
     * @return
     */
    @Select("SELECT * FROM demo")
    List<Demo> findDemos();

    /**
     * 修改
     * @param demo
     * @return
     */
    @Update("UPDATE demo SET user_name = #{demo.userName} , sign_name = #{demo.signName},pass_word = #{demo.passWord}, " +
            "gender = #{demo.gender} , age = #{demo.age} , introduction = #{demo.introduction} " +
            "WHERE id = #{demo.id}")
    int update(@Param("demo") Demo demo);

    /**
     * 删除
     * @param demo
     * @return
     */
    @Delete("DELETE demo WHERE id = #{demo.id} ")
    int delete(@Param("demo") Demo demo);

    /**
     * 获取登录用户信息
     * @param demo
     * @return
     */
    @Select("SELECT * FROM demo WHERE sign_name = #{demo.signName} AND pass_word = #{demo.passWord}")
    Demo existentialJudgement(@Param("demo") Demo demo);

    /**
     * 获取用户是否存在
     * @param signName
     * @return
     */
    @Select("SELECT COUNT(0) FROM demo WHERE sign_name = #{signName}")
    int findDemoBySingName(@Param("signName") String signName);

}
