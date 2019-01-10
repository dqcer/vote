package com.dqcer.vote.entity;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "vote_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "code")
    private String code;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "option_msg")
    private String optionMsg;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
