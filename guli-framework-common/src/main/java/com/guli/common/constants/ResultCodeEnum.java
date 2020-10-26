package com.guli.common.constants;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    SUCCESS(true,2000,"成功"),
    UNKNOWN_REASON(false,2001,"未知错误"),
    BAD_SQL_ERROR(false,2101,"sql语法错误"),
    JSON_PARSE_ERROR(false,2102,"json解析错误"),
    PARAM_ERROR(false,2103,"参数不正确"),
    FILE_UPLOAD_ERROR(false,2104,"文件上传错误");


    private Boolean success;//响应是否成功
    private Integer code;   //返回码
    private String  message; //返回信息

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
