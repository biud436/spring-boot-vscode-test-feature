package com.biud436.rest.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.biud436.rest.domain.post.MyPost;
import com.biud436.rest.domain.post.MyPostService;
import com.biud436.rest.domain.post.dto.MyResponse;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private MyPostService myPostService;
    
    @GetMapping()
    public String index() {
        return "API 라우트 테스트";
    }

    @GetMapping("/posts")
    public MyResponse<MyPost> findByTitleByUsingQueryDSL(@RequestParam(value = "title", required = false) String title) {
        try {
            MyResponse<MyPost> response = myPostService.findByTitleByUsingQueryDSL(Optional.of(title));

            return response;
        } catch(Error e) {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST);
        }
    }
    
}