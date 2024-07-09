package com.spring.springtest.service.impl;

import com.spring.springtest.mapper.AlipayMapper;
import com.spring.springtest.mapper.UserMapper;
import com.spring.springtest.pojo.Alipay;
import com.spring.springtest.pojo.User;
import com.spring.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AlipayMapper alipayMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<Alipay> find_alipay_All(){
        return alipayMapper.findAll();
    }
    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    @Override
    public int savealipay(Alipay alipay){
        return alipayMapper.save(alipay);
    }

    @Override
    public Integer delete(int id) {
        return userMapper.delete(id);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public String Servicetest(String s){
        return s;
    }
}


