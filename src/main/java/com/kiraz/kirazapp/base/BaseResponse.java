package com.kiraz.kirazapp.base;

import java.util.List;

public class BaseResponse<T> {
    private Boolean success;
    private List<String> messages;
    private T data;
}