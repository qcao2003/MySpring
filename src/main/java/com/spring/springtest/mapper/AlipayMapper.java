package com.spring.springtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.springtest.pojo.Alipay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlipayMapper extends BaseMapper<Alipay> {
    @Select("select * from alipay")
    List<Alipay> findAll();

    //新增数据
    @Insert("insert into alipay (trade_no, subject, total_amount, buyer_id) values (#{traceNo},#{subject},#{totalAmount},#{buyer_id})")
    public int save(Alipay alipay);
}
