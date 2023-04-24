package org.example.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ApiResponse implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private HttpStatus status;

    public ApiResponse(){}
    public ApiResponse(Boolean success,String message){
        this.success = success;
        this.message = message;
    }
    public ApiResponse(Boolean success,String message,HttpStatus status){
        this.success = success;
        this.message = message;
        this.status = status;
    }

}
