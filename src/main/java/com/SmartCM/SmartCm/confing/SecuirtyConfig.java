package com.SmartCM.SmartCm.confing;

import com.SmartCM.SmartCm.services.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecuirtyConfig {
//    // user create and login using java code with in memory service
//    @Bean
//    public UserDetailsService userDetailsService(){
//       UserDetails user1=  User
//               .withDefaultPasswordEncoder()
//               .username("admin123")
//               .password("admin123")
//               .roles("ADMIN","USER")
//               .build();
//
//       var inMemoryUserDetailsManager=  new InMemoryUserDetailsManager(user1);
//
//        return inMemoryUserDetailsManager;
//    }
    @Autowired
    private SecurityCustomUserDetailService userDetailService;



    //configuration of authenticationprovider


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
        //user details service ka object
       daoAuthenticationProvider.setUserDetailsService(userDetailService);
       //password details service ka object
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        //  cofiguration
        // urls configured in the configuration se public and private settings
        httpSecurity.authorizeHttpRequests(authorize->{
//            authorize.requestMatchers("/home","/register","services").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();

        });
        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
