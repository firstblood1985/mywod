package com.limin.mywod.request;

import com.limin.mywod.entity.user.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class Request implements Serializable{

    private Date requestWhen;

    private String requestBy;



    public Date getRequestWhen() {
        return requestWhen;
    }

    public void setRequestWhen(Date requestWhen) {
        this.requestWhen = requestWhen;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }
}
