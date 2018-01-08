package com.limin.mywod.controller.user;

import com.limin.mywod.entity.user.User;
import com.limin.mywod.entity.user.repository.UserRepository;
import com.limin.mywod.exception.SignupException;
import com.limin.mywod.response.Response;
import com.limin.mywod.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers(){

        return (List<User>) this.userRepository.findAll();
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody User user)
    {
        try{
            User singedUp = userService.signUp(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (SignupException e) {
            //e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

}
