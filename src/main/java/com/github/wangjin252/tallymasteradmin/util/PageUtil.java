package com.github.wangjin252.tallymasteradmin.util;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * Create at 2018-08-06 14:31
 *
 * @author WangJin
 * @version 1.0
 */
public class PageUtil {


    private PageUtil() {
    }

    public static <T extends Serializable> PageModel<T> parsePage(Page<T> page) {

        PageModel<T> pageModel = new PageModel<>();
        pageModel.setCount(page.getTotalElements());
        pageModel.setPage((long) (page.getPageable().getPageNumber() + 1));
        pageModel.setLimit(page.getSize());
        pageModel.setData(page.getContent());
        return pageModel;
    }
}
