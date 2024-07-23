package com.UserManagementSystem.UserManagementSystemSpringBoot;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.UserManagementSystem.UserManagementSystemSpringBoot.Bean.CustomUserDetails;
import com.UserManagementSystem.UserManagementSystemSpringBoot.Service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class Congif extends WebSecurityConfigurerAdapter {

	
//	 @Bean
//	 public UserDetailsService userDetailsService() {
//	        return new CustomUserDetailsService();
//	 }
	     
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	    
	    @Autowired
	    private CustomUserDetailsService oauthUserService;
	    
	    @Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/","/index","/registration","/forgotpwd","/forgotPwd","/resetpwd","/resetPassword","/userRegistration","/userExist").permitAll()
				.antMatchers("/assets/**","/login","/signin","/oauth2/**").permitAll()
				//.antMatchers("/adminWork").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
//				.httpBasic();
				.formLogin()
				.permitAll()
//				.loginPage("/index")
//				.loginProcessingUrl("/login")
//				.defaultSuccessUrl("/loginServlet")
//				.failureUrl("/failure")
//				.permitAll()
				.and()
				.oauth2Login()
					//.loginProcessingUrl("/index")

			    .loginPage("/login")
					.defaultSuccessUrl("/userDashBoard")
//			    .userInfoEndpoint()
//			        .userService(oauthUserService)
				.and()
				.logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logOut"))
	            .invalidateHttpSession(true)
	            .logoutSuccessUrl("/")
	            .permitAll();
		}
//
//			@Override
//			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//					Authentication authentication) throws IOException, ServletException {
////						 CustomUserDetails oauthUser = (CustomUserDetails) authentication.getPrincipal();
////
////							userService.processOAuthPostLogin(oauthUser.getEmail());
////
////				            response.sendRedirect("/userDashBoard");
//			}
//		})
	    
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("Admin@gmail.com").password(this.passwordEncoder().encode("Admin123@")).roles("admin");
//		auth.inMemoryAuthentication().withUser("Brijesh").password(this.passwordEncoder().encode("1234")).roles("user");
//	}
//	@SuppressWarnings("deprecation")
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder(11);
////		return NoOpPasswordEncoder.getInstance();
//	}

	 
//	    private  BackButtonPrevention myFilter;
//	    private  CheckUserRole myFilter1;
//	    @Autowired
//	    public void filterConfiguration(BackButtonPrevention myFilter) {
//	        this.myFilter = myFilter;
//	    }
//	    @Autowired
//	    public void filterConfiguration(CheckUserRole myFilter1) {
//	        this.myFilter1 = myFilter1;
//	    }
//	    @Bean
//	    public FilterRegistrationBean<BackButtonPrevention> someFilterRegistration() {
//
//	        FilterRegistrationBean<BackButtonPrevention> registration = new FilterRegistrationBean<BackButtonPrevention>();
//	        registration.setFilter(myFilter);
//	        registration.addUrlPatterns("/userDetails","/userDashBoard","/editServlet","/adminWork","/userData");
//	        return registration;
//	    }
//	    @Bean
//	    public FilterRegistrationBean<CheckUserRole> someFilterRegistration1() {
//
//	        FilterRegistrationBean<CheckUserRole> registration = new FilterRegistrationBean<CheckUserRole>();
//	        registration.setFilter(myFilter1);
//	        registration.addUrlPatterns("/adminDashBoard","/adminWork");
//	        return registration;
//	    }
}