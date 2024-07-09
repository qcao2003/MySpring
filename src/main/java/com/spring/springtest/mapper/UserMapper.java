package com.spring.springtest.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.springtest.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //查询全部
    @Select("select * from user")
    List<User> findAll();

    //新增数据
    @Insert("insert into user (username,password) values (#{username},#{password})")
    public int save(User user);

    //删除数据
    @Delete("delete from user where id=#{id}")
    public int delete(int id);

    //根据id查找
    @Select("select * from user where id=#{id}")
    public User get(int id);

    //更新数据
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public int update(User user);

}


