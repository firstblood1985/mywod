package com.limin.mywod.service.user.impl;

import com.jcabi.aspects.Loggable;
import com.limin.mywod.entity.user.User;
import com.limin.mywod.entity.user.repository.UserRepository;
import com.limin.mywod.exception.SignupException;
import com.limin.mywod.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collections;

@Component
public class UserServiceImpl implements UserService,UserDetailsService{

    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    @Loggable(Loggable.INFO)
    public User signUp(User signUpUser) throws SignupException {
        User check = userRepository.findUserByLogin(signUpUser.getLogin());
        if(null != check)
        {
            LOGGER.error(signUpUser.getLogin()+ " login has been used");
            throw new SignupException(signUpUser.getLogin()+ " login has been used", SignupException.SignupError.LOGINUSED);
        }

        check = userRepository.findUserByEmail(signUpUser.getEmail());
        if(null != check){
            LOGGER.error(signUpUser.getEmail()+ " email has been used");
            throw  new SignupException(signUpUser.getEmail()+ " email has been used", SignupException.SignupError.EMAILUSED);
        }

        signUpUser.setPassword(bCryptPasswordEncoder.encode(signUpUser.getPassword()));
        signUpUser.setDeleted(false);
        signUpUser.setAdmin(false); // admin registration is not via website
        signUpUser.setJoinedAffiliates(null);
        signUpUser.setOwnedAffiliates(null);

        User saved = userRepository.save(signUpUser);
        LOGGER.info("signed up user: "+ saved);
        return saved;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login);
        if(null == user)
        {
            throw new UsernameNotFoundException(login + "cannot be found");
        }

        //return return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(), Collections.emptyList());
    }
}
