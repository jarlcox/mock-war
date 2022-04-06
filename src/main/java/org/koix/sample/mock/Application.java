package org.koix.sample.mock;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableRedisHttpSession
@SpringBootApplication
public class Application {

    @Value("${page.title:Foo}")
    private String name;

    @RequestMapping(value="/")
    public String index(Model model) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dt=sdf.format(new Date(System.currentTimeMillis()));
        model.addAttribute("page_title",this.name+"="+dt);
        return "/index";
    }
    
    @PostMapping(value="/dopost")
    @ResponseBody
    public String dopost() {
        
        return "{\"msg\":\"ok "+this.name+"\"}";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
