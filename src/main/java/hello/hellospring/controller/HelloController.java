package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello! Spring!");
        return "hello";
    }

    @GetMapping("hello-mvc") //mvc(model, view, controller로 쪼갬) 모델
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody //html template 없이 바로 return값 보내줌(mvc 중 v가 없는 느낌)
    public String helloSpring(@RequestParam("name") String name){ //@RequestParam할시 ?name="" 해줘야함
        return "hello" + name;
        //name이 spring일 경우 hello spring
    }
    @GetMapping("hello-api") //api(객체 반환) 모델
    //api는 string일시 string 그대로, 객체일시 Json 구조로
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //Hello 객체를 생성자로 호출
        hello.setName(name); //name = ""에서 받은 String name을 객체 Hello의 name에 setting
        return hello; //Hello 객체 hello를 return
    }

    static class Hello {
        private String name;

        //Getter and Setter 단축기 Alt+Insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name + " 입니다.";
        }
    }
}
