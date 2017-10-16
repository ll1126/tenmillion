package com.wsloan.Service;

import com.baomidou.mybatisplus.service.IService;

public interface ReceiveService extends IService {

    public Integer receive(String phone,String cCode);


}
