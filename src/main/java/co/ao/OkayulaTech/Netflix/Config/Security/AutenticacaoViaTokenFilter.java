package co.ao.OkayulaTech.Netflix.Config.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioRepositorio;


public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	
	private TokenService tokenService;
	
	private UsuarioRepositorio usuarioRepository;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService,UsuarioRepositorio usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository=usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String token=RecuperarToken(request);
		
		boolean valido=tokenService.isTokenValido(token);
		
	    if(valido)
	    {
	    	autenticarClienteToken(token);
	    }
		
		filterChain.doFilter(request, response);
		
	}

	
	private void autenticarClienteToken(String token) 
	{
                                                                                                                                            
		Long idUsuario=tokenService.getIdUsuario(token);
		                                                                        
		Usuario usuario=usuarioRepository.findById(idUsuario).get();
		                                                                   
		UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		                                                                     
	}

	
	private String RecuperarToken(HttpServletRequest request) {
		
		String token=request.getHeader("Authorization");
		if (token != null) {
            return token.replace("Bearer ", "");
        }
          
        return null;
	}
	

}
