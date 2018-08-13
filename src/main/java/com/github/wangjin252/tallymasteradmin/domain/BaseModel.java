package com.github.wangjin252.tallymasteradmin.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author WangJin
 * @version 1.0
 * @date 2018-08-10 13:03
 */
@MappedSuperclass
@Data
class BaseModel implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @CreatedDate
    LocalDateTime createdTime;

    @LastModifiedDate
    LocalDateTime lastModifiedTime;
}
