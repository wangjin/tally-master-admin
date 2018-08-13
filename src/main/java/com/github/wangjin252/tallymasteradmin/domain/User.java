package com.github.wangjin252.tallymasteradmin.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author WangJin
 * @version 1.0
 * @date 2018-08-10 11:15
 */

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseModel{

    @Basic
    @Column(name = "name",  length = 50)
    private String name;

    @Basic
    @Column(name = "user_name",  length = 50)
    private String userName;

    @Basic
    @Column(name = "password",  length = 100)
    private String password;

    @Basic
    @Column(name = "mobile",  length = 11)
    private String mobile;

}


