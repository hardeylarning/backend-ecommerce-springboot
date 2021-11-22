package com.rochtech.ecommerce.config;

//import com.okta.spring.boot.oauth.Okta;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //protect endpoint /api/orders
//        http.authorizeRequests()
//                .antMatchers("/api/orders/**")
//                .authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//
//        // add CORS filters support
//        http.cors();
//
//        // disable csrf because of rejecting post mapping
//        http.csrf().disable();
//
//        // to display response body message
//        Okta.configureResourceServer401ResponseBody(http);
//    }
//}
