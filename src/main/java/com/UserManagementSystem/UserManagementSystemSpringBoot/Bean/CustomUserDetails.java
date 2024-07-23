package com.UserManagementSystem.UserManagementSystemSpringBoot.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomUserDetails implements OAuth2User{

	
	private OAuth2User oauth2user;
	
	public CustomUserDetails(OAuth2User oauth2user) {
        this.oauth2user = oauth2user;
    }
	@Override
	public Map<String, Object> getAttributes() {
		return oauth2user.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return oauth2user.getAuthorities();
	}

	@Override
	public String getName() {
		System.out.println("Username mil : "+oauth2user.getAttribute("name"));
		return oauth2user.getAttribute("name");
	}
	
	 public String getEmail() {
		 System.out.println("email: "+oauth2user.<String>getAttribute("email"));
	        return oauth2user.<String>getAttribute("email");     
	    }
	
	
//	private User user;
//	
//	public CustomUserDetails(User user) {
//        this.user = user;
//    }
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		 	String role = user.getRole();
//	        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//	        authorities.add(new SimpleGrantedAuthority(role));
//	        return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return user.getEmail();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}

}
