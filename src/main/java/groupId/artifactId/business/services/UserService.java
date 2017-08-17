package groupId.artifactId.business.services;

import groupId.artifactId.business.exception.ResourceForbiddenOperationException;
import groupId.artifactId.business.exception.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import groupId.artifactId.domain.users.User;
        
import java.util.List;

public interface UserService extends UserDetailsService {

    @Override
    User loadUserByUsername(String username) throws UsernameNotFoundException;
    
    List<User> listUsers();
    User getUser(Long id)  throws ResourceNotFoundException;
    Long addUser(User user) throws ResourceForbiddenOperationException;
    User updateUser(User user) throws ResourceNotFoundException, ResourceForbiddenOperationException;
    boolean deleteUser(Long id) throws ResourceForbiddenOperationException;
    
    User changePassword(Long userId, String oldRawPass, String newRawPass) throws ResourceNotFoundException, ResourceForbiddenOperationException;
    String/*boolean*/ startPasswordRestore(String username) throws ResourceNotFoundException;
    boolean completePasswordRestore(String restoreKey, String newRawPassword) throws ResourceNotFoundException;
}
