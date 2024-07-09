package com.spring.springtest.controller;


import com.spring.springtest.pojo.User;
import com.spring.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//控制层，导入Service层
@Controller
public class UserControl {
    @Autowired
    private UserService userService;


    @RequestMapping("/index.html")
    public String userList(Map<String,List> result) {
        System.out.println("进入到userList方法");
        List<User> Users=userService.findAll();
        result.put("users",Users);
        System.out.println("userList方法完成");
        return "index.html";
    }

    //新增数据
    @PostMapping("/add")
    public String save(User user) {
        userService.save(user);
        //表示重置index.html界面并且跳转到index.html界面
        return "redirect:/index.html";
    }

    //删除数据,本来需要使用DeleteMapping，但是由于没有界面可以隐藏，所以这里就直接写了RequestMapping
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, HttpServletResponse servletResponse) throws IOException {
        userService.delete(id);
        System.out.println("delete方法执行");
        return "redirect:/index.html";
    }


    //根据id进行修改
    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model,@PathVariable int id){
        User users = userService.get(id);
        model.addAttribute("users",users);
        //表示跳转到modifie,html界面
        return "modifie";
    }

    @PutMapping("/update")
    public String updateUser(Model model,User user,HttpServletRequest request) {
        String id = request.getParameter("id");
        User userById = userService.get(Integer.parseInt(id));
        userService.update(user);
        System.out.println(user);
        return "redirect:/index.html";
    }
}



