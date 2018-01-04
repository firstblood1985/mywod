package com.limin.mywod.response;

import com.limin.mywod.entity.user.User;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Response implements Serializable{

    private LocalDateTime responseWhen;

    private User responseTo;

    public LocalDateTime getResponseWhen() {
        return responseWhen;
    }

    public void setResponseWhen(LocalDateTime responseWhen) {
        this.responseWhen = responseWhen;
    }

    public User getResponseTo() {
        return responseTo;
    }

    public void setResponseTo(User responseTo) {
        this.responseTo = responseTo;
    }
}
