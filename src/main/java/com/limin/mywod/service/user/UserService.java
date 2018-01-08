package com.limin.mywod.service.user;

import com.limin.mywod.entity.user.User;
import com.limin.mywod.exception.SignupException;

public interface UserService {

    public User signUp(User signUpUser) throws SignupException;
}
