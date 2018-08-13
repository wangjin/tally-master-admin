package com.github.wangjin252.tallymasteradmin.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author WangJin
 * @version 1.0
 * @date 2018-08-10 11:15
 */
@Entity
@Table(name = "site")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Site extends BaseModel {

    @Basic
    @Column(name = "name", length = 50)
    private String name;

    @Basic
    @Column(name = "address", length = 100)
    private String address;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Site site = (Site) o;
        return Objects.equals(id, site.id) &&
                Objects.equals(name, site.name) &&
                Objects.equals(address, site.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
