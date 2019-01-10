package com.dqcer.vote.controller;


import com.dqcer.vote.service.ManagerService;
import com.dqcer.vote.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    /**
     * manager list
     *
     * @return
     */
    @RequestMapping("findList")
    @ResponseBody
    public Result findList(){
        return managerService.findList();
    }

    @RequestMapping("{add}")
    public String add(@PathVariable String add) {

        return add;
    }

    /**
     * 添加投票内容与选项
     */
    @ResponseBody
    @PostMapping("subjectAdd")
    public Result subjectAdd(String title,int status, @RequestParam("voteoptions") List<String> voteoptions) {

        return managerService.subjectAdd(title, status , voteoptions);
    }



}
