package com.dev.springrestapi.dto.response;

public class DefaultResponse {
    private Status status;
    private Object data;

    public enum Status {
        SUCCESS, FAIL, NOT_FOUND, CONFLICT
    }

    public DefaultResponse() {
        this.status = Status.SUCCESS;
        this.data=null;
    }

    public DefaultResponse(Status status) {
        this.status = status;
        this.data = null;
    }

    public DefaultResponse(Object data) {
        this.status = Status.SUCCESS;
        this.data = data;
    }

    public DefaultResponse(Status status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
