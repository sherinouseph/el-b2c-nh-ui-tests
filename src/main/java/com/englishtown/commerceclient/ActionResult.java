package com.englishtown.commerceclient;

public class ActionResult<T> {

    private boolean succeed;
    private String errorMessage;
    private T result;

    public ActionResult(boolean succeed) {
        this(succeed, /*result*/ null, /*errorMessage*/ null);
    }

    public ActionResult(boolean succeed, T result, String errorMessage) {
        this.succeed = succeed;
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public boolean getSucceed() {
        return this.succeed;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public T getResult() {
        return this.result;
    }
}
