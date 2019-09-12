package com.example.vip.mapper;

import com.example.vip.model.Exchange;
import com.example.vip.model.JExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JExchangeMapper extends JpaRepository<JExchange, Long> {
    List<JExchange> findAllByVip_Number(String number);

}
