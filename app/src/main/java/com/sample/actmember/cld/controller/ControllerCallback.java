package com.sample.actmember.cld.controller;

import java.io.IOException;

public interface ControllerCallback<T> {
    void onSuccess(T response);
    void onFailure(T errorMessage);
}
