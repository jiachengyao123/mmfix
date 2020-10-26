package com.guli.common.exception;

import com.guli.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auther Jia
 * @date 2020-05-11 12:14
 */
@Data
@ApiModel(value = "自定义全局异常类")
public class GuliException extends RuntimeException {

    @ApiModelProperty(value = "状态吗")
    private Integer code;

    /**
     * 接收状态码和异常错误信息
     * @param code
     * @param message
     */
    public GuliException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public GuliException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
    }
}
