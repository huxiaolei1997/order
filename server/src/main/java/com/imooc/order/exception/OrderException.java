package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;

/**
 * OrderException
 * <p>
 * version 1.0
 *
 * @create 2018-09-29 15:45
 * @copyright huxiaolei1997@gmail.com
 */
public class OrderException extends RuntimeException {
    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
