package com.example.docker_act;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @PostMapping("api/create")
    public String createHello(@RequestBody HelloRequestDto requestDto) {
        helloService.cHello(requestDto);
        return "작성완료";
    }

    @GetMapping("/")
    public String readHello() {
        return helloService.rHello();
    }
}
