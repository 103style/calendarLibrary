package com.tcl.p_calendar;

import java.io.Serializable;

/**
 * Created by yanruiliu on 15-9-28.
 */
public class BaseResponse implements Serializable {
    int error_id;
    String error_msg;
    String error_field;

    public int getErrorId() {
        return error_id;
    }
    public String getErrorMsg() {
        return error_msg;
    }
    public String getErrorField()
    {
        return error_field;
    }
}
