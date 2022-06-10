package site.orangefield.security01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // View를 리턴하겠다
public class IndexController {

    @GetMapping({ "", "/" })
    public String index() {

        // mustache 기본 폴더 src/main/resources/
        // view resolver 설정 templates(prefix), .mustache(suffix) - 의존성 설정했기 때문에 생략 가능
        return "index"; // src/main/resources/templates/index.mustache를 찾을 것
    }

    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    // Security가 이 주소를 낚아챈다, SecurityConfig 파일 생성 후 낚아채지 않는다
    @GetMapping("/login")
    public @ResponseBody String login() {
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody String join() {
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc() {
        return "회원가입 완료됨";
    }
}
