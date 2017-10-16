package com.wsloan.Dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ReceiveDao extends BaseMapper {
    //根据手机号查询温商贷是否有该用户
    Integer findUser(@Param("phone") String phone);


    //根据手机号查询领取体验金记录
    Map findRecord(Integer fUid);
    //根据领取码查询是否有
    Map findLqm(String cCode);
    //修改领取码状态
    int upLqm(String cCode);

    Map inRecord(Integer fUid);
}
