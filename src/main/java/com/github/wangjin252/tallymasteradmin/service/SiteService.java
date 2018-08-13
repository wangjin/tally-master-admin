package com.github.wangjin252.tallymasteradmin.service;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import com.github.wangjin252.tallymasteradmin.domain.Site;
import com.github.wangjin252.tallymasteradmin.domain.SiteRepository;
import com.github.wangjin252.tallymasteradmin.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author WangJin
 * @version 1.0
 */
@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;


    public PageModel<Site> findPage(int page, int limit) {
        return PageUtil.parsePage(siteRepository.findAll(PageRequest.of(page - 1, limit)));
    }

    public List<Site> findList() {
        return siteRepository.findAll();
    }

    public Site saveOrUpdate(Site site) {
        return siteRepository.save(site);
    }

    public Site findById(Integer id) {
        Optional<Site> optional = siteRepository.findById(id);
        return optional.orElse(null);
    }

    public void del(Site site) {
        siteRepository.delete(site);
    }
}
