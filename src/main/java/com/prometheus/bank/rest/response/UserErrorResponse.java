package com.prometheus.bank.rest.response;

public class UserErrorResponse extends ErrorResponse {

    public UserErrorResponse(){

    }

    public UserErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
