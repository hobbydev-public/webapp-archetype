/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.api.models.be;
        
import groupId.artifactId.domain.users.User;

public class UserModel {
    
    private Long id;
    
    public UserModel(User domain) {
        this.id = domain.getId();
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
