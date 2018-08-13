package com.github.wangjin252.tallymasteradmin.web;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import com.github.wangjin252.tallymasteradmin.domain.Tally;
import com.github.wangjin252.tallymasteradmin.service.TallyService;
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
@RequestMapping(value = "/tally")
@Slf4j
public class TallyController {

    @Autowired
    private TallyService tallyService;

    /**
     * 列表页
     *
     * @return 对应视图
     */
    @GetMapping(value = "/page")
    public String listPage() {
        return "tally";
    }

    /**
     * 获取分页数据
     *
     * @param page  当前页数
     * @param limit 每页记录数
     * @return PageModel<Tally>
     */
    @PostMapping(value = "/pageData")
    public PageModel<Tally> pageData(int page, int limit) {
        return tallyService.findPage(page, limit);
    }

    /**
     * 获取列表数据
     *
     * @return List<Tally>
     */
    @GetMapping
    @ResponseBody
    public List<Tally> listData() {
        return tallyService.findList();
    }

    /**
     * 添加
     *
     * @param tally entity
     * @return ResponseEntity<Tally>
     */
    @PostMapping
    public ResponseEntity<Tally> add(@RequestBody Tally tally) {
        try {
            tally = tallyService.saveOrUpdate(tally);
        } catch (Exception e) {
            log.error("保存Tally失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(tally, HttpStatus.OK);
    }

    /**
     * 修改
     *
     * @param tally entity
     * @return ResponseEntity<Tally>
     */
    @PutMapping
    public ResponseEntity<Tally> edit(@RequestBody Tally tally) {
        try {
            tally = tallyService.saveOrUpdate(tally);
        } catch (Exception e) {
            log.error("修改Tally失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(tally, HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @param id entity id
     * @return ResponseEntity<Tally>
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Tally> del(@PathVariable(value = "id") Integer id) {
        try {
            Tally tally = tallyService.findById(id);
            if (tally != null) {
                tallyService.del(tally);
            } else {
                log.warn("id=[{}]的Tally不存在", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("删除Tally失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
