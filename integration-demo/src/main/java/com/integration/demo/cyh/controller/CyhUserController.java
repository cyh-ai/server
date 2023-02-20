package com.integration.demo.cyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cyh
 * @date 2023.02.20
 * 测试前端调用
 */
@Controller
public class CyhUserController {

    private final String CYH = "你好！世界！";

    @RequestMapping("/cyh")
    @ResponseBody
    public String cyh(){
        System.out.println("你好！世界！");
        return CYH;
    }
}
