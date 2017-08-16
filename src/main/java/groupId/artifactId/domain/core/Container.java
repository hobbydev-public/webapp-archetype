package groupId.artifactId.domain.core;

import java.util.List;

public interface Container {

    List<? extends IdentifiedEntityInterface> getElements();
}
