package org.teapot.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.teapot.backend.controller.exception.BadRequestException;
import org.teapot.backend.controller.exception.ResourceNotFoundException;
import org.teapot.backend.model.User;
import org.teapot.backend.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new ResourceNotFoundException();
        }
        return user;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        if (!userRepository.exists(id)) {
            throw new ResourceNotFoundException();
        }
        user.setId(id);
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        if (!userRepository.exists(id)) {
            throw new ResourceNotFoundException();
        }
        userRepository.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user,
                             HttpServletResponse response) {
        try {
            user = userRepository.save(user);
        } catch (Exception e) {
            throw new BadRequestException();
        }
        response.setHeader("Location", "/api/users/" + user.getId());
        return user;
    }
}
