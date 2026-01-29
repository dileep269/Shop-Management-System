package com.kodnest.Shop_Management;

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
@Table
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column
	private String username;
	@Column(name = "`password`")

	private String   password;

	@Column
	private int age;
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;
	public Users() {
		super();
	}
	public Users(String username, String password, int age, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, password, role, userId, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return age == other.age && Objects.equals(password, other.password) && role == other.role
				&& userId == other.userId && Objects.equals(username, other.username);
	}
	
	
	
}
	


