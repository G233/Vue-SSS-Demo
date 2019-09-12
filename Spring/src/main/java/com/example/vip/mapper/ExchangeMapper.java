package com.example.vip.mapper;
import com.example.vip.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExchangeMapper extends JpaRepository<Exchange, Long> {
    List<Exchange> findAllByVip_Number(String number);

}
