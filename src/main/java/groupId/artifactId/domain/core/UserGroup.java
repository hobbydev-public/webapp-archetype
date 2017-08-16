package groupId.artifactId.domain.core;

import groupId.artifactId.domain.users.User;

import java.util.List;

public interface UserGroup extends Group {

    List<User> getUsers();
}
