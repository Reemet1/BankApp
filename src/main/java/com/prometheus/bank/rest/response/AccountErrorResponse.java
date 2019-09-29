package com.prometheus.bank.rest.response;

public class AccountErrorResponse extends ErrorResponse {

    public AccountErrorResponse() {

    }

    public AccountErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
