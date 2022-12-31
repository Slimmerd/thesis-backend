package ru.thesis.backend.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user/auth")
@AllArgsConstructor
public class UserLoginController {

    @PostMapping
    public String login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

    @PostMapping
    public String logout(@RequestBody LogoutRequest request){
        return userService.logout(request);
    }
}
