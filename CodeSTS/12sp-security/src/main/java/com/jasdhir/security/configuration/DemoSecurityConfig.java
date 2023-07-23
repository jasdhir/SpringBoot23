package com.jasdhir.security.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class DemoSecurityConfig {
	/*
	 * @Bean public static PasswordEncoder passwordEncoder(){ return new
	 * BCryptPasswordEncoder(); }
	 */

	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	  }
	 @Bean
	  public DataSource dataSource() {
	    return new EmbeddedDatabaseBuilder()
	      .setType(EmbeddedDatabaseType.H2)
	      .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
	      .build();
	  }
	 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) -> {
                    authorize
                    .requestMatchers(new AntPathRequestMatcher("/h2-ui/**")).permitAll()
                    .anyRequest().authenticated();
                }).formLogin(
                		form->form
                		.loginPage("/loginMe")
                		.loginProcessingUrl("/authenticateTheUser")
                		.defaultSuccessUrl("/home")
                		 .permitAll()
                		);
        
        		http.headers().frameOptions().disable();
                
                //.formLogin(Customizer.withDefaults());
        return http.build();
    }

	/*
	 * @Bean public UserDetailsService userDetailsService(){
	 * 
	 * UserDetails jasdhir = User.builder() .username("jasdhir")
	 * .password(passwordEncoder().encode("password")) .roles("USER") .build();
	 * 
	 * UserDetails admin = User.builder() .username("admin")
	 * .password(passwordEncoder().encode("admin")) .roles("ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(jasdhir, admin);
	 * 
	 * 
	 * 
	 * }
	 */
    
    @Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
      String usersByUsernameQuery = "select username, password, enabled from tbl_users where username = ?";
      String authsByUserQuery = "select username, authority from tbl_authorities where username = ?";
          
      JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

      userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
      userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
      System.out.println(userDetailsManager);
      return userDetailsManager;
    }
}
