package com.dqcer.vote.repository;

import com.dqcer.vote.entity.PubUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * pub_user jpa
 */
public interface PubUserRepository extends JpaRepository<PubUser, String> {

    PubUser findByUserName(String userName);


}
