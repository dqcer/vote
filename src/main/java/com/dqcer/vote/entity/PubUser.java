package com.dqcer.vote.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "pub_user")
public class PubUser implements Serializable {
    private static final long serialVersionUID = 1015861686283246340L;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "code")
    private	String code;
    @Column(name = "user_name")
    private		String		userName;
    @Column(name = "user_password")
    private		String		userPassword;
    private		String		salt;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private		Date		updateTime;
    private		String		status;
}
