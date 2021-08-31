package com.pojo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 */
@Data
public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应编码
     */
    private boolean success;
    /**
     * 提示消息
     */
    private String message;

    /**
     * 请求路径
     */
    private String path;

    /**
     * 响应数据
     */
    private T data;

    /**
     * http状态码
     */
    private String code;


    /**
     * 响应时间
     */
    private long timestamp = System.currentTimeMillis();




}
