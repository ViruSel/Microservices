package org.oauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/")
    public String home()
    {
        return "Welcome home!";
    }

    @GetMapping("/secured")
    public String secured()
    {
        return "Welcome secured!";
    }
}
