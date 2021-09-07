package com.course.system.controller;

import com.course.system.domain.Test;
import com.course.system.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/7
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public List<Test> test() {
        return testService.list();
    }
}
