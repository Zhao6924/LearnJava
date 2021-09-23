package zlx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(allowCredentials="true", allowedHeaders = "*")
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        //在jsp中可以得到
        model.addAttribute("msg","gello");
        return "hello";//被视图解析器处理
    }
}
