package com.example.vip.mapper;
import com.example.vip.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftMapper extends JpaRepository<Gift, Long> {

}
