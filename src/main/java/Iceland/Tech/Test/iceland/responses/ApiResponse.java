package Iceland.Tech.Test.iceland.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Timi Ogunkeye
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private Boolean isSuccessful;
    private Integer status;
    private String message;
    private Object object; //optional
    private Long totalCount; //optional

    public ApiResponse(Boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
    }

    public ApiResponse(Boolean isSuccessful, String message, Object object) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.object = object;
    }

    public ApiResponse(Boolean isSuccessful, Integer status, String message) {
        this.isSuccessful = isSuccessful;
        this.status = status;
        this.message = message;
    }

    public ApiResponse(Boolean isSuccessful, Integer status, String message, Object object) {
        this.isSuccessful = isSuccessful;
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public ApiResponse(Boolean isSuccessful, Integer status, String message, Object object, Long totalCount) {
        this.isSuccessful = isSuccessful;
        this.status = status;
        this.message = message;
        this.object = object;
        this.totalCount = totalCount;
    }

    public Boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}