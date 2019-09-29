package com.prometheus.bank.rest.response;


public class ClientErrorResponse extends ErrorResponse {

    public ClientErrorResponse() {

    }

    public ClientErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
