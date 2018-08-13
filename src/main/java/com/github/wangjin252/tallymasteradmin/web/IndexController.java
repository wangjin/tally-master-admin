package com.github.wangjin252.tallymasteradmin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Create at 2018-08-03 16:25
 *
 * @author WangJin
 * @version 1.0
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
