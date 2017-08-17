package groupId.artifactId.domain.core;

import java.util.List;

public interface Group extends Container {
	List<? extends IdentifiedEntityInterface> getGroupMembers();
}
