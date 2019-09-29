package com.prometheus.bank.rest.response;

public class CardErrorResponse extends ErrorResponse {

    public CardErrorResponse() {

    }

    public CardErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
