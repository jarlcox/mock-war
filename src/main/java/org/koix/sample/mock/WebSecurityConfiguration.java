package org.koix.sample.mock;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, proxyTargetClass=true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.authorizeRequests()
				.antMatchers("/","/dopost").permitAll()
                .antMatchers("/css/**","/fonts/**","/img/**","/html/**","/json/**","/js/**","/plugins/**","/webfonts/**").permitAll()
				.anyRequest().authenticated()
		.and()
			.headers().frameOptions().sameOrigin()
		.and()
		    .csrf();
    }
}
