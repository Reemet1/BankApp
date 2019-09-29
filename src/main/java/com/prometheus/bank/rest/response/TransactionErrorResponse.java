package com.prometheus.bank.rest.response;

public class TransactionErrorResponse extends ErrorResponse {

    public TransactionErrorResponse() {

    }

    public TransactionErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
