package com.dqcer.vote.repository;

import com.dqcer.vote.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository  extends JpaRepository<Subject,String>{

}
