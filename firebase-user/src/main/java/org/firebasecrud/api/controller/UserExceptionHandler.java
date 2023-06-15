package org.firebasecrud.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionHandler
{
    //@ExceptionHandler({CallNotPermittedException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public void handleCallNotPermittedException()
    {

    }

    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public void handleTimeOutException()
    {

    }

    @ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public void handleBulkheadFullException()
    {

    }

    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public void handleRequestNotPermittedException()
    {

    }
}
