package com.github.wangjin252.tallymasteradmin.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author WangJin
 * @version 1.0
 * @date 2018-08-10 11:15
 */
@Entity
@Table(name = "tally")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Tally extends BaseModel{

    @Basic
    @Column(name = "work_time", nullable = false)
    private Timestamp workTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tally that = (Tally) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(workTime, that.workTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workTime);
    }
}
