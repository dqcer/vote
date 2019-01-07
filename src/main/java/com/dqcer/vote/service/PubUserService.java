package com.dqcer.vote.service;

import com.dqcer.vote.BaseService;
import com.dqcer.vote.entity.PubUser;
import com.dqcer.vote.param.PubUserParam;
import com.dqcer.vote.utils.Result;


public interface PubUserService extends BaseService<PubUser> {


    Result<String> validate(String userName, String password);

    Result registerPubUser(PubUserParam param);
}
