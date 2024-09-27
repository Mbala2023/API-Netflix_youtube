package co.ao.OkayulaTech.Netflix.Config.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioRepositorio;



@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter  {
	
	
	@Autowired
	private TokenService tokenService;
	
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	
	@Autowired
	private UsuarioRepositorio usuarioRepository;
	
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		
		return super.authenticationManager();
	}
	
	
	
	//Configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{		 
	    auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	

	//configuracao de Autorizacao
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{	
				
		http.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/auth").permitAll()
		.antMatchers(HttpMethod.GET,"/actuator/**").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService,usuarioRepository),UsernamePasswordAuthenticationFilter.class);		 				 
		 
	}
	
	 
	//Configuracoes de recursos estaticos (js,css,imagens,etc)
	
	 @Override
	 public void configure(WebSecurity web) throws Exception 
	 {
		 
	        //libera o swagger
	    web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**","/h2-console/**","/#/**");
	    

	 }	
	 
	/* public static void main(String[] args) {
		System.out.print(new BCryptPasswordEncoder().encode("1234"));
	}*/
	 
}

