package com.spring.petabyte.dto;

import lombok.*;

import static com.spring.petabyte.utils.GlobalVariable.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    private String message;
    private T data;

    public static <T> ResponseDto<T> success(T data) {
        return ResponseDto.<T>builder()
                .message(REQUEST_SUCCESS)
                .data(data)
                .build();
    }

    public static <T> ResponseDto<T> validationError(T data) {
        return ResponseDto.<T>builder()
                .message(REQUEST_VALIDATION_FAILURE)
                .data(data)
                .build();
    }

    public static <T> ResponseDto<T> fail(T data) {
        return ResponseDto.<T>builder()
                .message(REQUEST_FAILURE)
                .data(data)
                .build();
    }
}
