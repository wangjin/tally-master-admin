package com.github.wangjin252.tallymasteradmin.web;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import com.github.wangjin252.tallymasteradmin.domain.User;
import com.github.wangjin252.tallymasteradmin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WangJin
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 列表页
     *
     * @return 对应视图
     */
    @GetMapping(value = "/page")
    public String listPage() {
        return "user";
    }

    /**
     * 获取分页数据
     *
     * @param page  当前页数
     * @param limit 每页记录数
     * @return PageModel<User>
     */
    @GetMapping(value = "/pageData")
    @ResponseBody
    public PageModel<User> pageData(int page, int limit) {
        return userService.findPage(page, limit);
    }

    /**
     * 获取列表数据
     *
     * @return List<User>
     */
    @GetMapping
    @ResponseBody
    public List<User> listData() {
        return userService.findList();
    }

    /**
     * 添加
     *
     * @param user entity
     * @return ResponseEntity<User>
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<User> add(@RequestBody User user) {
        try {
            user = userService.saveOrUpdate(user);
        } catch (Exception e) {
            log.error("保存User失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /**
     * 修改
     *
     * @param user entity
     * @return ResponseEntity<User>
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<User> edit(@RequestBody User user) {
        try {
            user = userService.saveOrUpdate(user);
        } catch (Exception e) {
            log.error("修改User失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @param id entity id
     * @return ResponseEntity<User>
     */
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<User> del(@PathVariable(value = "id") Integer id) {
        try {
            User user = userService.findById(id);
            if (user != null) {
                userService.del(user);
            } else {
                log.warn("id=[{}]的User不存在", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("删除User失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
