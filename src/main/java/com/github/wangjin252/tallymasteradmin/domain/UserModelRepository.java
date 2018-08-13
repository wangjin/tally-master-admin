package com.github.wangjin252.tallymasteradmin.domain;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserModelRepository extends JpaRepository<User, Integer> {

}