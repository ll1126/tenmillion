package com.wsloan.Controller;

import com.wsloan.Service.ReceiveService;
import com.wsloan.Util.JsonResult;
import com.wsloan.Util.JsoupUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Api(description = "领取体验金接口",value = "领取体验金接口")   //类注解
@RestController      //注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RequestMapping("/judge")
@EnableAutoConfiguration   //此注释自动载入应用程序所需的所有Bean
public class ReceiveController {

    @Autowired
    private ReceiveService receiveService;

    @ApiOperation(value = "领取体验金c")   //方法名注解
    @RequestMapping("/receive.do")   //和以前一样
    public JsonResult receive(@ApiParam(name="phone",value="用户手机号",required = true)String phone,
                              @ApiParam(name="cCode",value="领取码",required = true)String cCode,HttpServletResponse response){
        JsoupUtil.SetHttpServletResponse(response);
        //state  1  ：领取成功
        //       2  ：已经领取过了
        //       3  ：未注册
        //       4  ：领取码是假的
        //       5  ：领取码被用了
        Integer state = receiveService.receive(phone,cCode);
        if(state==1){
            return new JsonResult(0,"","领取成功");
        } else if(state==2){
            return new JsonResult(2,"","已经领取过了");
        }else if(state==3){
            return new JsonResult(1,"","该手机号未注册");
        }else if(state==4){
            return new JsonResult(2,"","领取码错误");
        }else if(state==5){
            return new JsonResult(2,"","领取码已被使用");
        }else {
            return new JsonResult(2,"","领取失败");
        }

    }


}
