package com.dqcer.vote.repository;

import com.dqcer.vote.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRespository extends JpaRepository<Option , String>{
}
