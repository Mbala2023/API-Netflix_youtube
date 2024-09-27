package co.ao.OkayulaTech.Netflix.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.ao.OkayulaTech.Netflix.service.EnailService;



@RestController
@RequestMapping("/email")
public class TesteEmail {
	
	@Autowired
	private EnailService emailService;
	
	@PostMapping
	 @Transactional
	
	public ResponseEntity<Void> Enviar(@RequestBody @Valid String to, String subject,String text)
	{
		emailService.sendSimpleMessage(to,subject,text);

		
		return ResponseEntity.noContent().build();
	}

}
