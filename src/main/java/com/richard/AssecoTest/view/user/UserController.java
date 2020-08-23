package com.richard.AssecoTest.view.user;

import com.richard.AssecoTest.common.domain.UserData;
import com.richard.AssecoTest.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping()
    public List<UserData> getUsers() {
        return userServiceImpl.getUsers();
    }

    @GetMapping("/{id}")
    public UserData getUserById(@PathVariable final long id) {

        return userServiceImpl.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable final long id) {

        userServiceImpl.deleteUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserData userData) {

        userServiceImpl.addUser(userData);
    }
}
