
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.business.users;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
        
import java.util.List;
import java.util.stream.Collectors;
        
import java.util.List;
import groupId.artifactId.business.AbstractService;
import groupId.artifactId.domain.users.User;

/**
 * User Service
 */
@Service
public class UserService extends AbstractService implements UserServiceInterface {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
    
    @Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User foundUser = listUsers().stream()
                    .filter(user -> user.getUsername().equals(username))
                    .findFirst()
                    .orElseThrow(() -> new UsernameNotFoundException("User with provided email was not found - " + username));
            return foundUser;
        } catch (UsernameNotFoundException unfe) {
            throw unfe;
        } catch (Throwable t) {
            throw new RuntimeException("Authentication service failure. Please contact the administrator", t);
        }
    }
}
