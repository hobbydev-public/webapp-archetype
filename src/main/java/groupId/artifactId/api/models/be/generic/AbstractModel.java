package groupId.artifactId.api.models.be.generic;

import groupId.artifactId.domain.core.IdentifiedEntityInterface;

public abstract class AbstractModel {
	
	protected Long id;
	
	protected AbstractModel(){}
	
	public AbstractModel(IdentifiedEntityInterface domain) {
		setId(domain.getId());
	}
	
	public abstract Long getId();
	public abstract void setId(Long id);
}
