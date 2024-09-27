package co.ao.OkayulaTech.Netflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EnailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String remetente;
	
	
	public String sendSimpleMessage(String to, String subject, String text) {
		//MimeMessage message = this.javaMailSender.createMimeMessage();
		//MimeMessageHelper helper;
		
		try 
		{
				
	        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
	        
	        simpleMailMessage.setFrom(remetente);
	        
	        simpleMailMessage.setTo(to);
	                 
	        simpleMailMessage.setSubject(subject);
	        
	        simpleMailMessage.setText(text);
	        
			javaMailSender.send(simpleMailMessage);
			
			System.out.println("Enviado");	    
			
		    
		}
		
		catch (Exception e)
		{	
			return "erro ao enviar o email" + e.getLocalizedMessage();
		}

		return "BOAS";
	}

}
