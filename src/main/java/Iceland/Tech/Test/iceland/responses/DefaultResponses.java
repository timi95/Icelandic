package Iceland.Tech.Test.iceland.responses;

import org.springframework.http.HttpStatus;


public class DefaultResponses {
    
    
    public static <E> UploadUrlResponse uploadResponse200(E object) {
        return new UploadUrlResponse(object);
    }

    public static <E> ApiResponse response200(String message, E object) {
        return new ApiResponse(true, HttpStatus.OK.value(), message, object);
    }

    public static <E> ApiResponse response200(String message, E object, Long totalCount) {
        return new ApiResponse(true, HttpStatus.OK.value(), message, object, totalCount);
    }

    public static ApiResponse response200(String message) {
        return new ApiResponse(true, HttpStatus.OK.value(), message);
    }

    public static ApiResponse response500(String message) {
        return new ApiResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static <E> ApiResponse genericSuccessfulResponse(int status, String message) {
        return new ApiResponse(true, status, message);
    }

    public static <E> ApiResponse genericResponse(boolean success, int status, String message, E object) {
        return new ApiResponse(success, status, message, object);
    }

    public static <E> ApiResponse genericResponse(boolean success, int status, String message) {
        return new ApiResponse(success, status, message);
    }
}