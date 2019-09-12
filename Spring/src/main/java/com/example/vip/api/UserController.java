package com.example.vip.api;

import com.example.vip.mapper.UserMapper;
import com.example.vip.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public  int Login(@RequestBody Map<String,Object> params) {
        String name=params.get("name").toString();
        String paw=params.get("paw").toString();

        User root = userMapper.findByNameAndPass(name,paw);
        System.out.println(root);
        if(root!=null){
            System.out.println("登陆成功····");
            return 200;
        }
        else {
            System.out.println("用户名或密码错误");
            return 400;
        }
    }

}