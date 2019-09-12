package com.example.vip;

import com.alibaba.fastjson.JSON;
import com.example.vip.api.UserController;
import com.example.vip.api.VipController;
import com.example.vip.mapper.VipMapper;

import com.example.vip.model.Vip;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;



@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class VipApplicationTests{
    @MockBean
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    @MockBean
    private VipController vipController;

    @Test
    @DisplayName("测试controller方法")

    public void test() throws Exception {
            MvcResult mvcResult = mockMvc.perform(
                    post("/addvip")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(""))
                    .andReturn();


    }

}

