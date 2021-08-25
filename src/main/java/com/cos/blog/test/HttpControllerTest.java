package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> HTML파일로 응답
// @Controller

// 사용자가 요청 -> Data로 응답
@RestController
public class HttpControllerTest {

    //http://localhost:8080/http/get (select)
    //@GetMapping("/http/get")
    public String getTestV1(@RequestParam int id, @RequestParam String username) {
        return "get 요청 : " + id + "," + username;
    }

    @GetMapping("/http/get")
    public String getTestV2(Member member) { //?id=1&username=kim&password=1234&email=ssar@nate.com
        return "get 요청 : " + member.getId() + "," + member.getUsername() + "," + member.getPassword() + "," + member.getEmail();
    }

    //인터넷 브라우저 요청은 무조건 get요청밖에 할 수 없다.
    //http://localhost:8080/http/post (insert)
    //@PostMapping("/http/post")
    public String postTestV1(Member member) {
        return "post 요청 : " + member.getId() + "," + member.getUsername() + "," + member.getPassword() + "," + member.getEmail();
    }

    //@PostMapping("/http/post") // text/plain, application/json
    public String postTestV2(@RequestBody String text) { // @RequestBody 바디 데이터를 받는 법
        return "post 요청 : " + text;
    }

    @PostMapping("/http/post") // application/json
    public String postTestV3(@RequestBody Member member) { // json데이터를 파싱해서 Member객체와 매핑을 해줌 (text타입인 json형식은 파싱을 할 수 없음)
        return "post 요청 : " + member.getId() + "," + member.getUsername() + "," + member.getPassword() + "," + member.getEmail();
    }

    //http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member member) {
        return "put 요청 : " + member.getId() + "," + member.getUsername() + "," + member.getPassword() + "," + member.getEmail();
    }

    //http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
