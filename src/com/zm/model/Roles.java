package com.zm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="t_roles")
public class Roles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7563395400740977241L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = false, nullable = false)
	private long id;
	private RolesName name;

	@ManyToMany(mappedBy = "roles")
	@JsonIgnoreProperties(value = { "roles" })
	private Set<User> user;

	public Roles() {
		this.user = new HashSet<User>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RolesName getName() {
		return name;
	}

	public void setName(RolesName name) {
		this.name = name;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}
}
