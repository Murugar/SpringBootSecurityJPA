package com.iqmsoft.security.boot.service.user;

import java.util.Collection;
import java.util.Optional;

import com.iqmsoft.security.boot.domain.User;
import com.iqmsoft.security.boot.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
