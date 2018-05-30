package com.nd.zsp.bootdemo.module.demo.controller;

import com.nd.zsp.bootdemo.module.demo.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/properties")
public class ThymeleafController {
// Spring4.3以后为简化@RequestMapping(method = RequestMethod.XXX)的写法，故而将其做了一层包装，
// 也就是现在的GetMapping、PostMapping、PutMapping、DeleteMapping、PatchMapping
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        view.addObject("title","我的第一个web页面");
        view.addObject("desc", "欢迎进入web系统");

        Author author = new Author();
        author.setAge(44);
        author.setEmail("1122@qq.com");
        author.setName("是否士大夫");

        view.addObject("author", author);
        return view;
    }

    @GetMapping("/index2")
    public String index2(HttpServletRequest request) {
        request.setAttribute("title","我的第er个web页面");
        request.setAttribute("desc", "欢迎进入sdfweb系统");

        Author author = new Author();
        author.setAge(44);
        author.setEmail("1122@qq.com");
        author.setName("是否士大夫");

        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }
}
