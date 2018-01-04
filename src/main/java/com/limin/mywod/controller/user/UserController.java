package com.limin.mywod.controller.user;

import com.limin.mywod.entity.user.User;
import com.limin.mywod.entity.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by CBB on 17/12/14.
 */

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers(){

        return (List<User>) this.userRepository.findAll();
    }
}
