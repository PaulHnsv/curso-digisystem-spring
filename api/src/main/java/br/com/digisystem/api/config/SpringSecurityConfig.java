package br.com.digisystem.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.digisystem.api.security.JWTAutenticacaoFiltro;
import br.com.digisystem.api.security.JWTUtil;
import br.com.digisystem.api.services.CredentialDetailsServiceImpl;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CredentialDetailsServiceImpl userDetailsService;
		
	@Autowired
	private JWTUtil jwtUtil;
		
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	

	private static final String[] PUBLIC_ENDPOINTS = {
			"/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
	};
	
	private static final String[] PUBLIC_ENDPOINTS_GET = {
			"/produtos/**"
	};

	private static final String[] PUBLIC_ENDPOINTS_POST = {
			"/auth/**"
	};
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 //http.csrf().disable().authorizeRequests().anyRequest().permitAll();
		 
		 http.cors().and().csrf().disable()
 		//autoriza requisições que: 
         .authorizeRequests()
         //todos os endpoints que estãp aqui abaixo são públicos
         .antMatchers(PUBLIC_ENDPOINTS).permitAll()                
         //todos os endpoints que estãp aqui abaixo são públicos - somente método GET
         .antMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS_GET).permitAll()                
         //todos os endpoints que estãp aqui abaixo são públicos - somente método POST
         .antMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS_POST).permitAll()                
         //Toda requisição deve ser autenticada - usuário e senha
         .anyRequest().authenticated()
         
         //.and()
         //A exceção é tratada aqui
         //.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
         
         .and()
         //gerenciamenteo de sessão STATELESS
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		 /* adicionado o filtro de autenticação*/
		 http.addFilter(new JWTAutenticacaoFiltro(authenticationManager(), jwtUtil));
		 
	 }

}


