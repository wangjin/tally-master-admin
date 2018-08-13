package com.github.wangjin252.tallymasteradmin.domain;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author WangJin
 * @version 1.0
 */
@Repository
public interface TallyRepository extends JpaRepository<Tally, Integer> {

}