package com.example.vip.api;

import com.example.vip.mapper.GiftMapper;
import com.example.vip.mapper.JExchangeMapper;
import com.example.vip.mapper.VipMapper;
import com.example.vip.model.Gift;
import com.example.vip.model.JExchange;
import com.example.vip.model.Exchange;
import com.example.vip.model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Date;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class GiftController {
    @Autowired
    private GiftMapper GiftMapper;
    @Autowired
    private VipMapper VipMapper;
    @Autowired
    private JExchangeMapper JExchangeMapper;

    @RequestMapping(value = "/addgift", method = RequestMethod.POST)
    @ResponseBody
    public  int AddGift(@RequestBody Map<String,Object> params) {
        String G_name=params.get("G_name").toString();
        Integer G_integral= (Integer) params.get("G_integral");
        String photo=params.get("photo").toString();
        Gift newgift= new Gift(G_name,G_integral,photo);
        GiftMapper.save(newgift);
        System.out.println("新礼品添加成功");
        return 200;
    }

    @RequestMapping(value = "/getallgift",method = RequestMethod.POST)
    @ResponseBody
    public List<Gift> GetAllGift(@RequestBody Map<String,Object> params) {
        List<Gift> gifts= GiftMapper.findAll();

        return gifts;
    }

    @RequestMapping(value = "/changegift",method = RequestMethod.POST)
    @ResponseBody
    public  int ChangeGift(@RequestBody Map<String,Object> params) {
        String G_name=params.get("G_name").toString();
        Integer G_integral= (Integer) params.get("G_integral");
        String photo=params.get("photo").toString();
        Long G_id = Long.parseLong(params.get("G_id").toString());
        Optional<Gift> findgift =  GiftMapper.findById(G_id);
        Gift gift = findgift.get();
        gift.setG_name(G_name);
        gift.setG_integral(G_integral);
        gift.setPhoto(photo);
        GiftMapper.save(gift);
        System.out.println("礼品信息修改成功");
        return 200 ;
    }


    @RequestMapping(value = "/deletegift",method = RequestMethod.POST)
    @ResponseBody
    public int DeleteGift(@RequestBody Map<String,Object> params){
        GiftMapper.deleteById( Long.parseLong(params.get("GiftId").toString()));
        return 200;
    }

    @RequestMapping(value = "/covertgift",method = RequestMethod.POST)
    @ResponseBody
    public int CoverGift(@RequestBody Map<String,Object> params){
        int number=Integer.parseInt(params.get("number").toString());
        String phone=params.get("phone").toString();
        System.out.println(params.get("gifid").toString());
        Optional<Gift> fgift= GiftMapper.findById(Long.parseLong(params.get("gifid").toString()));
        Gift gift=fgift.get();
        int shuzi = gift.getG_integral()*number;
        Vip vip = VipMapper.findVipByNumber(phone);
        if(shuzi>vip.getIntegral()){
            System.out.println(shuzi);
            System.out.println(vip.getIntegral());
            return 400;
        }
        else {

            int  linshi = vip.getIntegral()-shuzi;
            vip.setIntegral(linshi);
            VipMapper.save(vip);
            Date d=new Date();
            java.sql.Date sqlDate = new java.sql.Date(d.getTime());
            JExchange jilu = new JExchange(vip,gift,sqlDate,number,shuzi);
            JExchangeMapper.save(jilu);
            return 200;

        }


    }
}