package com.dqcer.vote.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: dongQin
 * @Date: 2019/1/7 14:17
 * @Description: 注册参数
 */
@Data
public class PubUserParam implements Serializable {
    @NotNull
    private String code;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String userPassword;
    @NotEmpty
    private String confirmPwd;
}
