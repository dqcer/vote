package com.dqcer.vote.controller;

import com.dqcer.vote.entity.PubUser;
import com.dqcer.vote.param.PubUserParam;
import com.dqcer.vote.service.PubUserService;
import com.dqcer.vote.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(value = "登录注册")
public class LoginController {

    @Autowired
    private PubUserService pubUserService;

    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }
    @RequestMapping("/manager")
    public String toManager() {
        return "manager";
    }

    @RequestMapping("/register.html")
    public String toRegister() {
        return "register";
    }

    @ApiOperation(value = "登录效验", notes = "返回操作结果")
    @RequestMapping("validate")
    @ResponseBody
    public Result<String> validate(PubUser user) {
        //验证
        if (user.getUserName() == null || "".equals(user.getUserName())){
            return new Result<>("用户名为空",null,"error");
        }
        if(user.getUserPassword() == null || "".equals (user.getUserPassword())) {
            return new Result<>("密码为空",null,"error");
        }
        return pubUserService.validate(user.getUserName() , user.getUserPassword());
    }

    /**
     * @Author: dongQin
     * @Date: 2019/1/7 14:20
     * @Description:效验并注册用户
     * @Param: [param]
     * @return: com.dqcer.vote.utils.Result
     */
    @ApiOperation(value = "注册用户", notes = "返回操作结果")
    @RequestMapping("register")
    @ResponseBody
    public Result registerPubUser(@ModelAttribute @Validated PubUserParam param){
       return pubUserService.registerPubUser(param);
    }


}
