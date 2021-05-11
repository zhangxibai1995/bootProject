package com.bootproject.core.model;

/**
 * 接口返回对象
 * @author 189****3363
 * @date 2021/05/11 09:30
 */
public class ApiResponse<T> {

    private Boolean success;

    private String message;

    private T data;
  
    public ApiResponse(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * 请求成功
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    public static <T> ApiResponse success(T data) {
        return ApiResponse.success("请求成功", data);
    }

    /**
     * 请求成功
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    public static <T> ApiResponse success(String message, T data) {
        return new ApiResponse<>(Boolean.TRUE, message, data);
    }

    /**
     * 请求失败
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    public static ApiResponse failed() {
        return ApiResponse.failed("请求失败");
    }

    /**
     * 请求失败
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    public static ApiResponse failed(String message) {
        return new ApiResponse<>(Boolean.FALSE, message, null);
    }
  
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}