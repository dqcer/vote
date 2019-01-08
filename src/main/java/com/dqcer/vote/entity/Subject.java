package com.dqcer.vote.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "vote_subject")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "code")
    private  String code;

    private  String title;

    private  int status;


}
