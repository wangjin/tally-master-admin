package com.github.wangjin252.tallymasteradmin.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Create at 2018-08-06 14:28
 *
 * @author WangJin
 * @version 1.0
 */
@Data
@NoRepositoryBean
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class PageModel<T extends Serializable> implements Serializable {

    /**
     * 当前页数
     */
    private long page;

    /**
     * 记录条数
     */
    private long limit;

    /**
     * 总记录条数
     */
    private long count;

    private long code = 0;

    private List<T> data;

}
