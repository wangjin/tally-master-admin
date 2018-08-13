package com.github.wangjin252.tallymasteradmin.web;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * @author WangJin
 * @version 1.0
 * @date 2018-08-10 16:17
 */
public abstract class BaseController<T extends Serializable> {


    /**
     * 列表页
     * <code>@GetMapping(value = "/page")</code>
     * @return 对应视图
     */
    public abstract String list();


    /**
     * 获取列表json数据
     * <code>@GetMapping</code>
     * @param page  当前页数
     * @param limit 每页记录数
     * @return PageModel<T>
     */
    public abstract PageModel<T> data(int page, int limit);

    /**
     * 添加
     * <code>@PostMapping</code>
     * @param t model
     * @return ResponseEntity<T>
     */
    public abstract ResponseEntity<T> add(T t);

    /**
     * 修改
     * <code>@PutMapping</code>
     * @param t model
     * @return ResponseEntity<T>
     */
    public abstract ResponseEntity<T> edit(T t);

    /**
     * 删除
     * <code>@DeleteMapping(value = "/{id}")</code>
     * @param id model id
     * @return ResponseEntity<T>
     */
    public abstract ResponseEntity<T> del(Integer id);
}
