package com.prometheus.bank.rest.response;

public class DocumentErrorResponse extends ErrorResponse {

    public DocumentErrorResponse() {

    }

    public DocumentErrorResponse(int status, String message, long timeStamp) {
        super(status, message, timeStamp);
    }

}
