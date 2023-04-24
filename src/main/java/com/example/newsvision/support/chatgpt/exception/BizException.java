package com.example.newsvision.support.chatgpt.exception;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException{
    private final Integer code;

    private final String msg;

    public BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BizException(Error error) {
        super(error.getMsg());
        this.code = error.getCode();
        this.msg = error.getMsg();
    }

}
