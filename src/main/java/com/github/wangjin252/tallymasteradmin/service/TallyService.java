package com.github.wangjin252.tallymasteradmin.service;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import com.github.wangjin252.tallymasteradmin.domain.Tally;
import com.github.wangjin252.tallymasteradmin.domain.TallyRepository;
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
public class TallyService {

    @Autowired
    private TallyRepository tallyRepository;


    public PageModel<Tally> findPage(int page, int limit) {
        return PageUtil.parsePage(tallyRepository.findAll(PageRequest.of(page - 1, limit)));
    }

    public List<Tally> findList() {
        return tallyRepository.findAll();
    }

    public Tally saveOrUpdate(Tally tally) {
        return tallyRepository.save(tally);
    }

    public Tally findById(Integer id) {
        Optional<Tally> optional = tallyRepository.findById(id);
        return optional.orElse(null);
    }

    public void del(Tally tally) {
        tallyRepository.delete(tally);
    }
}
