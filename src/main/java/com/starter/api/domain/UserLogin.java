package com.starter.api.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class UserLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iduser;
	
	@NotEmpty(message = "Campo NOME não pode ser vazio!")
	@Length(min = 3, max = 100, message = "O NOME deve ter mais de 3 caracteres!")
	private String name;

	@NotEmpty(message = "Campo EMAIL não pode ser vazio!")
	@Length(min = 3, max = 30, message = "O Email deve ter mais de 3 caracteres!")
	private String email;
	
	@NotEmpty(message = "Campo SENHA não pode ser vazio!")
	@Length(min = 3, max = 8, message = "A Senha deve ter entre 3 e 8 caracteres!")
	private String password;

	public UserLogin() {
		super();
	}

	public UserLogin(String name, String email, String password, Integer id) {
		super();
		this.iduser = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return iduser;
	}

	public void setId(Integer id) {
		this.iduser = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iduser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLogin other = (UserLogin) obj;
		return Objects.equals(iduser, other.iduser);
	}

}
