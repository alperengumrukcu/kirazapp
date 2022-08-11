package com.kiraz.kirazapp.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseResponse<T> {
    private Boolean success;
    private List<String> messages = new ArrayList<>();
    private T data;
}