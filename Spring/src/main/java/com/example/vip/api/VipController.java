package com.example.vip.api;
import com.example.vip.mapper.VipMapper;
import com.example.vip.model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class VipController {
    @Autowired
    private VipMapper VipMapper;


    @RequestMapping(value = "/addvip",method = RequestMethod.POST)
    @ResponseBody
    public  int AddVip(@RequestBody Map<String,Object> params) {
        String name=params.get("name").toString();
       String gender=params.get("gender").toString();
        String number=params.get("number").toString();
        String birthday=params.get("birthday").toString();
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        try{
            Date date =  formatter.parse(birthday);
            java.sql.Date Date = new java.sql.Date (date.getTime());
            Vip newvip= new Vip(name,gender,number,Date);
            VipMapper.save(newvip);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return 200;
    }
    @RequestMapping(value = "/getallvip",method = RequestMethod.POST)
    @ResponseBody
    public  List<Vip> GetAllVip(@RequestBody Map<String,Object> params) {

        List<Vip> vips= VipMapper.findAll();
        return vips;
    }

    //更该会员信息
    @RequestMapping(value = "/changevip",method = RequestMethod.POST)
    @ResponseBody
    public  int ChangeVip(@RequestBody Map<String,Object> params) {
        String name=params.get("name").toString();
        String gender=params.get("gender").toString();
        String number=params.get("number").toString();
        String birthday=params.get("birthday").toString();
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        try{
            Date date =  formatter.parse(birthday);
            java.sql.Date Date = new java.sql.Date (date.getTime());
            Long id = Long.parseLong(params.get("id").toString());
            Optional<Vip> findvip =  VipMapper.findById(id);
            Vip vip = findvip.get();
            vip.setBirthday(Date);
            vip.setGender(gender);
            vip.setName(name);
            vip.setNumber(number);
            VipMapper.save(vip);
            System.out.println("用户信息修改成功");
            return 200 ;
        }
        catch (ParseException e){
            e.printStackTrace();
            return 400;
        }

    }

    //删除会员信息
    @RequestMapping(value = "/deletevip",method = RequestMethod.POST)
    @ResponseBody
    public  int DeleteVip(@RequestBody Map<String,Object> params) {
        VipMapper.deleteById( (Long)(params.get("VipId")));
        return 200;
    }

    //删除会员信息
    @RequestMapping(value = "/checkphone",method = RequestMethod.POST)
    @ResponseBody
    public  int CheckPhone(@RequestBody Map<String,Object> params) {
       if(VipMapper.findVipByNumber(params.get("number").toString())==null) {
           System.out.println("未找到号码");
           return 400;
       }
       else{
           System.out.println("找到了");
           return 200;
       }

    }

    @RequestMapping(value = "/addbalance",method = RequestMethod.POST)
    @ResponseBody
    public  int AddBalance(@RequestBody Map<String,Object> params) {
        System.out.println(params.get("number").toString());
        Vip findvip = VipMapper.findVipByNumber(params.get("number").toString());
        System.out.println(params.get("balance").toString());
        int i = Integer.parseInt(params.get("balance").toString());
         int x =findvip.getBalance();
        findvip.setBalance(i+x);
        VipMapper.save(findvip);
        return 200;
    }

    @RequestMapping(value = "/getbvip",method = RequestMethod.POST)
    @ResponseBody
    public  List<Vip> GetbVip(@RequestBody Map<String,Object> params) {
        List<Vip> vips= VipMapper.findByNameAndPassword();
        return vips;


    }







}
