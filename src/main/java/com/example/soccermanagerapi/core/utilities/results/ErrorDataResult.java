package com.example.soccermanagerapi.core.utilities.results;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(String message) {
        super(null, false, message);
    }

    public ErrorDataResult() {
        super(null, false);
    }

    public ErrorDataResult(T data, boolean success) {
        super(data, success);
    }
}
