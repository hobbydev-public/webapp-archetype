
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.business.users;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import groupId.artifactId.domain.users.User;
        
import java.util.List;

public interface UserServiceInterface extends UserDetailsService {

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;
    
    List<User> listUsers();
    void registerUser(String email, String password) throws ResourceForbiddenOperationException;
}
