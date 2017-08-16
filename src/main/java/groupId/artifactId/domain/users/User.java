/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package groupId.artifactId.domain.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

import groupId.artifactId.domain.IdentifiedEntityInterface;

@Entity
@Table(name="users")
public class User implements IdentifiedEntityInterface, UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.NO_AUTHORITIES;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return isEnabled();
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return isEnabled();
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return isEnabled();
	}
}
