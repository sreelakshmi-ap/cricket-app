package com.example.cricket.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email") })
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	private String name;
	private String email;
	private String password;
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	private String city;
	private String gender;
	
	@Column(name = "image_path")
	private String imagePath;
	
	
	   @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	            )
	    private Set<Role> roles = new HashSet<>();

	
	public Users(int userId, String name, String email, String password, String countryCode, Long phoneNumber,
			String city, String gender, String imagePath, Set<com.example.cricket.model.Role> role) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.gender = gender;
		this.imagePath = imagePath;
		this.roles = role;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Users(String name, String email, String password, String countryCode, Long phoneNumber, String city,
			String gender, String imagePath) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.gender = gender;
		this.imagePath = imagePath;
	}
	public Users() {
	}

	
}
