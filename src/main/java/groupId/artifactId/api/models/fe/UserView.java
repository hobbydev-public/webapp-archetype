/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.api.models.fe;
        
import groupId.artifactId.domain.users.User;

public class UserView {
    
    private Long id;
    
    public UserView() {}
    
    public User toDomain() {
        User domain = new User();
        domain.setId(getId());
        return domain;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
