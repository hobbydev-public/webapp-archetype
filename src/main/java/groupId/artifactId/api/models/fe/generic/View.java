package groupId.artifactId.api.models.fe.generic;

import groupId.artifactId.domain.core.IdentifiedEntityInterface;

public interface View<ENTITY extends IdentifiedEntityInterface> {
    
    ENTITY toDomain();
}
