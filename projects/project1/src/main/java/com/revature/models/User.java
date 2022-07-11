package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ers_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ers_username", nullable = false, unique = true)
	private String username;
//	@Column(name="ers_password", nullable = false)
//	private String password;
//	@Column(name="user_first_name", nullable = false)
//	private String userFirstName;
//	@Column(name="user_last_name", nullable = false)
//	private String userLastName;
//	@Column(name="user_email", nullable = false)
//	private String userEmail;
	@Column(name="ers_password")
	private String password;
	@Column(name="user_first_name")
	private String userFirstName;
	@Column(name="user_last_name")
	private String userLastName;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="role")
	private String role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, role, username);
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
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username) && Objects.equals(userFirstName, other.userFirstName) 
				&& Objects.equals(userLastName, other.userLastName) && Objects.equals(userEmail, other.userEmail);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", user_first_name=" + userFirstName + ", user_last_name=" + userLastName + ", user_email=" + userEmail + ", role=" + role + "]";
	}
	
}