package com.example.khanabanam_web.shared.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GlobalApiResponse<T> {
    private T data;
    private int statusCode;
    private String message;
}
