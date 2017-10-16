package com.wsloan.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wsloan.Dao.ReceiveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class ReceiveServiceImpl extends ServiceImpl implements ReceiveService{

    @Autowired
    private ReceiveDao receiveDao;

    @Transactional
    public Integer receive(String phone,String cCode) {
        //获取用户id
        Integer fUid = receiveDao.findUser(phone);
        System.out.println("用户id："+ fUid);
        if(fUid!=null){//有该用户
            //获取体验金记录
            Map a = receiveDao.findRecord(fUid);
            System.out.println("体验金记录："+ a);
            if(a!=null){//已经领取了体验金
                return 2;
            }
            //判断领取码是否正确以及是否被使用
            Map lqm = receiveDao.findLqm(cCode);
            System.out.println("领取码："+ lqm);
            if(lqm!=null){//能查询到领取码
                if(Integer.parseInt(lqm.get("fZt").toString())==0){//领取码未使用
                    //更改领取码状态为1
                   int y =  receiveDao.upLqm(cCode);
                    System.out.println("更改领取码状态后返回："+ y);
                   if(y==1){
                       //生成体验金记录
                       Map aa = receiveDao.inRecord(fUid);
                       System.out.println("生成体验金记录后返回："+ aa);
                   }else{
                       return 6;
                   }
                }else{//领取码已使用
                    return 5;
                }
            }else{//不能查询到领取码
                return 4;
            }
        }else{//没有该用户
            return 3;
        }
        return 1;
    }
}
