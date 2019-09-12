package com.example.vip.api;
import com.example.vip.mapper.ExchangeMapper;
import com.example.vip.mapper.JExchangeMapper;
import com.example.vip.mapper.ProductMapper;
import com.example.vip.mapper.VipMapper;
import com.example.vip.model.Exchange;
import com.example.vip.model.JExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class JExchangeController {
    @Autowired
    private JExchangeMapper JExchangeMapper;
    @Autowired
    private VipMapper VipMapper;
    @Autowired
    private ProductMapper ProductMapper;

    @RequestMapping(value = "/getjexchange",method = RequestMethod.POST)
    @ResponseBody
    public List<JExchange> GetJExchange(@RequestBody Map<String,Object> params) {
        String number=params.get("number").toString();
        List<JExchange> elist= JExchangeMapper.findAllByVip_Number(number);
        return elist;


    }
    @RequestMapping(value = "/getalljexchange",method = RequestMethod.POST)
    @ResponseBody
    public List<JExchange> GetAllJExchange(@RequestBody Map<String,Object> params) {
        List<JExchange> elist= JExchangeMapper.findAll();
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
