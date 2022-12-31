package ru.thesis.backend.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.thesis.backend.entity.user.UserEntity;

@RestController
@RequestMapping(path = "api/v1/user/profile")
@AllArgsConstructor
public class UserController {

    @GetMapping
    public UserEntity getUser(@RequestBody UserRequest request){

        return userService.getUser(request);
    }

    @
    public Boolean updateUser(@RequestBody UpdateUserRequest request){
        return userService.updateUser(request);
    }
}
