package com.example.cricket.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.cricket.model.Users;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	Integer userId;
	String name;
	String email;
	String password;
	String city;
	String gender;
	Long phoneNumber;
	String imagePath;
	private Collection<? extends GrantedAuthority> authorities;
	
	public static UserDetailsImpl build(Users user)
	{

		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());
		return new UserDetailsImpl(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getCity(),
				user.getGender(), user.getPhoneNumber(), user.getImagePath(), authorities);
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetailsImpl(Integer userId, String name, String email, String password, String city, String gender,
			Long phoneNumber, String imagePath) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.imagePath = imagePath;
	}

	public UserDetailsImpl(Integer userId, String name, String email, String password, String city, String gender,
			Long phoneNumber, String imagePath,Collection<? extends GrantedAuthority> authorities ) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.imagePath = imagePath;
		this.authorities = authorities;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl that = (UserDetailsImpl) o;
		return Objects.equals(userId, that.userId);
	}
}
