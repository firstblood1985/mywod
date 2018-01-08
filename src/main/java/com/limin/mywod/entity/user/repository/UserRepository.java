package com.limin.mywod.entity.user.repository;

import com.limin.mywod.entity.user.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by CBB on 17/12/14.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserByLogin(String login);

    public User findUserByEmail(String email);
}
