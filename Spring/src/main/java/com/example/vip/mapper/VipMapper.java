package com.example.vip.mapper;
import com.example.vip.model.User;
import com.example.vip.model.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VipMapper extends JpaRepository<Vip, Long> {
    //自定义方法

    Vip findVipByNumber(String number);

    @Query(value = "SELECT a FROM Vip a WHERE date_format(birthday,'%Y-%m')=date_format(now(),'%Y-%m')")
    List<Vip> findByNameAndPassword();

}
