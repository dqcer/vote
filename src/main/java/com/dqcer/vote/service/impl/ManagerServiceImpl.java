package com.dqcer.vote.service.impl;

import com.dqcer.vote.entity.Subject;
import com.dqcer.vote.repository.SubjectRepository;
import com.dqcer.vote.service.ManagerService;
import com.dqcer.vote.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Result findList() {
        return new Result(subjectRepository.findAll());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result subjectAdd(Map<String, Object> map) {
        String title = (String) map.get("title");
        Integer status =  Integer.parseInt(map.get("status").toString());
        Subject subject = new Subject( UUID.randomUUID().toString(), title, status);
        subjectRepository.save(subject);
        return new Result();
    }
}
