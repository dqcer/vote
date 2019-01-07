package com.dqcer.vote.service.impl;

import com.dqcer.vote.entity.PubUser;
import com.dqcer.vote.repository.PubUserRepository;
import com.dqcer.vote.param.PubUserParam;
import com.dqcer.vote.service.PubUserService;
import com.dqcer.vote.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class PubUserServiceImpl implements PubUserService {
    @Autowired
    private PubUserRepository pubUserRepository;

    @Override
    public List<PubUser> findAll() {
        List<PubUser> list = pubUserRepository.findAll();
        return list;
    }

    @Override
    public void insert(PubUser pubUser) {
        pubUserRepository.save(pubUser);
    }

    @Override
    public void update(PubUser pubUser) {
        pubUserRepository.save(pubUser);
    }

    @Override
    public void deleteById(String code) {
        pubUserRepository.deleteById(code);
    }

    @Override
    public PubUser findById(String code) {
       PubUser optionalUser = pubUserRepository.getOne(code);

        return optionalUser;
    }

    @Override
    public Result<String> validate(String userName, String password) {
        PubUser user = pubUserRepository.findByUserName(userName);
        if(user==null){
            return new Result<>("",null,"error");
        }
        if(!user.getUserPassword().equals(password)){
            return new Result<>("密码错误",null,"error");
        }
        return success();
    }

    @Override
    //@Transactional(rollbackFor = Exception.class)
    public Result registerPubUser(PubUserParam param) {
        boolean existsById = pubUserRepository.existsById(param.getCode());
        if (existsById){
            return new Result("已存在",null,"error");
        }
        PubUser user = new PubUser();
        user.setCode(param.getCode());
        user.setUserName(param.getUserName());
        user.setUserPassword(param.getUserPassword());
        user.setCreateTime(new Date());
        user.setStatus("1");
        insert(user);
        return success();
    }

    public Result success(){
        return new Result();
    }
}
