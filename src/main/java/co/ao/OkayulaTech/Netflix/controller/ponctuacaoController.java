package co.ao.OkayulaTech.Netflix.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesPonctuacoesDTO;
import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Ponctuacoes;
import co.ao.OkayulaTech.Netflix.model.Video;
import co.ao.OkayulaTech.Netflix.repositorios.ExibicaoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.PonctucaoesRepositorios;
import co.ao.OkayulaTech.Netflix.repositorios.VideoRepositorio;



@RestController
@RequestMapping("/ponctuacoes")
public class ponctuacaoController {

	
	@Autowired
	private VideoRepositorio videoRepositorio;
	
	@Autowired
	private ExibicaoRepositorio exibicaoRepositorio;
	
	@Autowired
	private PonctucaoesRepositorios ponctuacaoRepositorios;
	
	
	 @GetMapping("/{id}/video")
	 @Transactional
	 @Cacheable(value="ponctuacaoMemo")
	 public ResponseEntity <DetalhesPonctuacoesDTO> video(@PathVariable Long id)
	 {
		 
		 
		Optional<Video> video= videoRepositorio.findById(id);
		Optional<Exibicao> exibicao= exibicaoRepositorio.findByVideo(video.get());
		Optional<Ponctuacoes> ponctuacoes=ponctuacaoRepositorios.findByExibicao(exibicao.get());
	   
		if(exibicao.isPresent())
		{
		
	 	if(ponctuacoes.isPresent())
	 	{	  	      
	 	  	
	 			
	 	        return ResponseEntity.ok(new DetalhesPonctuacoesDTO(ponctuacoes.get()));    	
	 	
	 		
	 		
	 	}
	 	
		}
	 	return ResponseEntity.notFound().build();
	 	
	 }
}

