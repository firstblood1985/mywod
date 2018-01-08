package com.limin.mywod.exception;

public class SignupException extends Exception {

    public enum SignupError{
        LOGINUSED,
        PASSWORDVALIDATION,
        EMAILUSED,
    };

    public SignupError signupError;

    public SignupException(String message, SignupError signupError)
    {
        super(message);
        this.signupError = signupError;
    }
}
