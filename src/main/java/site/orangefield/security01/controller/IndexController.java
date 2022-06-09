package site.orangefield.security01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // View를 리턴하겠다
public class IndexController {

    @GetMapping({ "", "/" })
    public String index() {

        // mustache 기본 폴더 src/main/resources/
        // view resolver 설정 templates(prefix), .mustache(suffix) - 의존성 설정했기 때문에 생략 가능
        return "index"; // src/main/resources/templates/index.mustache를 찾을 것
    }
}
