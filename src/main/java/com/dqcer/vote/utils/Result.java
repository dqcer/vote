package com.dqcer.vote.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Result<T> implements Serializable{

    private static final long serialVersionUID = -165606012874817032L;

    private  String code;

    private T result;

    private String status;

    public Result() {
        this("",null,"success");
    }



}
