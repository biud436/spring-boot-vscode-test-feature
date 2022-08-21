package com.biud436.rest.rest.domain.post.dto;

import java.util.List;

import com.biud436.rest.rest.domain.post.MyPost;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MyResponse<T extends MyPost> {
    List<T> data;
    String message;
}