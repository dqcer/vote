package com.dqcer.vote.service;

import com.dqcer.vote.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    Result findList();

    Result subjectAdd(String title,int status, List<String> voteoptions);
}
