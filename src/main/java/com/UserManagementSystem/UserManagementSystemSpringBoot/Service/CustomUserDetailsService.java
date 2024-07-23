package com.UserManagementSystem.UserManagementSystemSpringBoot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.CustomUserDetails;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.User;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Dao.UserDao;

@Service
public class CustomUserDetailsService extends DefaultOAuth2UserService{
	
	 @Override
	    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
	        OAuth2User user =  super.loadUser(userRequest);
	        System.out.println("user hain?");
	        System.out.println("user dekho: "+user.getName());
	        return new CustomUserDetails(user);
	    }
	
//	@Autowired
//	UserDao userdao;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		List<User> userlist = userdao.findByEmail(username);
//		User user = null;
//		if (userlist.size() > 0) {
//			user = userlist.get(0);
//		}
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomUserDetails(user);
//	}

}
