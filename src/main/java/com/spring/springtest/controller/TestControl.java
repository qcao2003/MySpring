package com.spring.springtest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.springtest.mapper.AlipayMapper;
import com.spring.springtest.mapper.UserMapper;
import com.spring.springtest.pojo.Alipay;
import com.spring.springtest.pojo.User;
import com.spring.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
public class TestControl {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AlipayMapper alipayMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String searchforSQL(){
        User user0 = new User();
        // 根据自己的业务逻辑完成下面的订单更新
        // 查询订单
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
        //如果订单不为空就更新订单状态变成已支付同时更新订单支付时间
        if (user == null) {
            user0.setUsername("alipayTradeNo");
            user0.setPassword("BIU");
            userMapper.save(user0);
        }
        return "successful";
    }

    @RequestMapping("/test0")
    public String searchforSQLAlipay(){
        // 根据自己的业务逻辑完成下面的订单更新
        // 查询订单
        QueryWrapper<Alipay> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 1);
        Alipay alipay = alipayMapper.selectOne(queryWrapper);
        System.out.println(alipay);
        return "successful";
    }

    @RequestMapping("/test1")
    public String searchSQL0(){
        QueryWrapper<Alipay> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("subject","ABC");
        Alipay alipay = alipayMapper.selectOne(queryWrapper);
        System.out.println(alipay);
        return "successful";
    }

    @RequestMapping("/test2")
    public List<String> searchSQL1(){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        return list;
    }

    @RequestMapping("/test3")
    private Map<String,Object> searchSQL2(){
        Map<String,Object> M = new HashMap<String,Object>();
        M.put("age",300);
        M.put("name","Mike");
        return M;
    }

    @RequestMapping("/test4")
    private String searchSQL3(String s){
        return s;
    }

    @RequestMapping("/test5")
    private String searchSQL4(String s){
        return userService.Servicetest(s);
    }

    @RequestMapping("/test6")
    private List<Alipay> searchSQL5(){
        return userService.find_alipay_All();
    }

    //新增数据
    @PostMapping("/test7")
    public Alipay save(Alipay alipay) {
        Date date = new Date();
        String orderon=new SimpleDateFormat("yyyyMMddhhmmss").format(date) ;
        alipay.setProduct_code(orderon);
        return alipay;
    }

    @RequestMapping("/test8")
    public void searchSQL6(Alipay alipay){
        alipay.setBuyer_id("ABC");
        alipay.setSubject("test");
        userService.savealipay(alipay);
    }
}
