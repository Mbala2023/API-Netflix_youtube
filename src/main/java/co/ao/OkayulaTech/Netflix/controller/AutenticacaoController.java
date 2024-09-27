package co.ao.OkayulaTech.Netflix.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ao.OkayulaTech.Netflix.Config.Security.TokenService;
import co.ao.OkayulaTech.Netflix.controller.DTOs.TokenDTO;
import co.ao.OkayulaTech.Netflix.form.LoginForm;


@Service
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManeger;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	@Transactional
	
	public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form)
	{
		UsernamePasswordAuthenticationToken dadosLogin=form.converter();
		
		try {
			
			  Authentication authentication =  authManeger.authenticate(dadosLogin);
			
			  String token=tokenService.gerarToken(authentication);
			
			  
			  return ResponseEntity.ok(new TokenDTO(token, "Bearer "));
		}
		
		catch(AuthenticationException e)
		{
			return ResponseEntity.badRequest().build();
		}
		
		
	}

}
