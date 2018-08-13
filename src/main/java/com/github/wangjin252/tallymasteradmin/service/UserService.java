package com.github.wangjin252.tallymasteradmin.service;

import com.github.wangjin252.tallymasteradmin.domain.PageModel;
import com.github.wangjin252.tallymasteradmin.domain.User;
import com.github.wangjin252.tallymasteradmin.domain.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public PageModel<User> findPage(int page, int limit) {
        return PageUtil.parsePage(userRepository.findAll(PageRequest.of(page - 1, limit)));
    }

    public List<User> findList() {
        return userRepository.findAll();
    }

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);
    }

    public void del(User user) {
        userRepository.delete(user);
    }
}
