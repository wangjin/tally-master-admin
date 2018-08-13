package com.github.wangjin252.tallymasteradmin.web;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import com.github.wangjin252.tallymasteradmin.domain.Site;
import com.github.wangjin252.tallymasteradmin.service.SiteService;
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
@RequestMapping(value = "/site")
@Slf4j
public class SiteController {

    @Autowired
    private SiteService siteService;

    /**
     * 列表页
     *
     * @return 对应视图
     */
    @GetMapping(value = "/page")
    public String listPage() {
        return "site";
    }

    /**
     * 获取分页数据
     *
     * @param page  当前页数
     * @param limit 每页记录数
     * @return PageModel<Site>
     */
    @PostMapping(value = "/pageData")
    @ResponseBody
    public PageModel<Site> pageData(int page, int limit) {
        return siteService.findPage(page, limit);
    }

    /**
     * 获取列表数据
     *
     * @return List<Site>
     */
    @GetMapping
    @ResponseBody
    public List<Site> listData() {
        return siteService.findList();
    }

    /**
     * 添加
     *
     * @param site entity
     * @return ResponseEntity<Site>
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Site> add(@RequestBody Site site) {
        try {
            site = siteService.saveOrUpdate(site);
        } catch (Exception e) {
            log.error("保存Site失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    /**
     * 修改
     *
     * @param site entity
     * @return ResponseEntity<Site>
     */
    @PutMapping
    @ResponseBody
    public ResponseEntity<Site> edit(@RequestBody Site site) {
        try {
            site = siteService.saveOrUpdate(site);
        } catch (Exception e) {
            log.error("修改Site失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    /**
     * 删除
     *
     * @param id entity id
     * @return ResponseEntity<Site>
     */
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Site> del(@PathVariable(value = "id") Integer id) {
        try {
            Site site = siteService.findById(id);
            if (site != null) {
                siteService.del(site);
            } else {
                log.warn("id=[{}]的Site不存在", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("删除Site失败", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
