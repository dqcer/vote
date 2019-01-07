package com.dqcer.vote.exception;

import com.dqcer.vote.service.MailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dongQin
 * @Date: 2019/1/7 17:06
 * @Description: 全局捕获异常和自定义全局捕获异常
 */

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @Autowired
    private MailService mailService;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> myExceptionHandler(Exception myex){
       /* Map<String,Object> map  = new HashMap<String,Object>();
        map.put("code",myex.getCode());
        map.put("message",myex.getMessage());
        map.put("method",myex.getMethod());
        map.put("descinfo",myex.getDescinfo());*/
        //发生异常进行日志记录，写入数据库或者其他处理，此处省略

        System.err.println(myex.getStackTrace());


        return null;
    }
}
