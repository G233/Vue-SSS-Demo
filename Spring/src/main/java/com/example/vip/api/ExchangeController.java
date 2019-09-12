package com.example.vip.api;
import com.example.vip.mapper.ExchangeMapper;
import com.example.vip.mapper.ProductMapper;
import com.example.vip.mapper.VipMapper;
import com.example.vip.model.Exchange;
import com.example.vip.model.Product;
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
public class ExchangeController {

    @Autowired
    private ExchangeMapper ExchangeMapper;

    @Autowired
    private VipMapper VipMapper;

    @Autowired
    private ProductMapper ProductMapper;

    @RequestMapping(value = "/getexchange",method = RequestMethod.POST)
    @ResponseBody
    public List<Exchange> GetExchange(@RequestBody Map<String,Object> params) {
        String number=params.get("number").toString();
        List<Exchange> elist= ExchangeMapper.findAllByVip_Number(number);
        return elist;
    }

    @RequestMapping(value = "/getallexchange",method = RequestMethod.POST)
    @ResponseBody
    public List<Exchange> GetAllExchange(@RequestBody Map<String,Object> params) {
        List<Exchange> elist= ExchangeMapper.findAll();
        return elist;

    }



}

//        Long id = Long.parseLong("5");
//        Optional<Vip> findvip =  VipMapper.findById(id);
//        Vip vip = findvip.get();
//        Optional<Product> findp = ProductMapper.findById(id);
//        Product product = findp.get();
//        Integer x=0;
//        for( ;id<10;++id){
//            java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
//            try{
//                String v ="2019-8-08";
//                Date date =  formatter.parse(v);
//                java.sql.Date Date = new java.sql.Date (date.getTime());
//                Exchange exchange = new Exchange(id,vip,product,product.getValue(),product.getKind(),10,Date);
//                ExchangeMapper.save(exchange);
//            }
//            catch (ParseException e){
//                e.printStackTrace();
//            }
//
//
//        }
//        Optional<Exchange> e= ExchangeMapper.findById(id);
//        Exchange exchange =e.get();

//        String number=params.get("number").toString();
//        List<Exchange> E = exchangeMapper.findAll();
