package com.dqcer.vote.service.impl;

import com.dqcer.vote.entity.Option;
import com.dqcer.vote.entity.Subject;
import com.dqcer.vote.repository.OptionRespository;
import com.dqcer.vote.repository.SubjectRepository;
import com.dqcer.vote.service.ManagerService;
import com.dqcer.vote.utils.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private OptionRespository optionRespository;

    @Override
    public Result findList() {
        return new Result(subjectRepository.findAll());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result subjectAdd(String title,int status, List<String> voteoptions) {

        Subject subject = new Subject( UUID.randomUUID().toString(), title, status);
        if(voteoptions == null){
            return new Result("选项不能空",null,"error");
        }

        Subject save = subjectRepository.save(subject);
        List<String> list = (List<String>) voteoptions;
        List<Option> optionList = new ArrayList<>();
        for (String voteOption : list) {
            Option option = new Option();
            option.setOptionMsg(voteOption);
            option.setSubjectCode(save.getCode());
            optionList.add(option);
        }
        optionRespository.saveAll(optionList);
        return new Result();
    }
}
