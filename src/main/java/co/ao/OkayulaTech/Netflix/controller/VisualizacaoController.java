package co.ao.OkayulaTech.Netflix.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesVisualizadoresDTO;
import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Video;
import co.ao.OkayulaTech.Netflix.model.Visualizadores;
import co.ao.OkayulaTech.Netflix.repositorios.ExibicaoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.VideoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.VisualizacoesRepositorios;


@RestController
@RequestMapping("/visualizador")
public class VisualizacaoController {

	
	@Autowired
	private VideoRepositorio videoRepositorio;
	
	@Autowired
	private ExibicaoRepositorio exibicaoRepositorio;
	
	@Autowired
	private VisualizacoesRepositorios visualizacoesRepositorios;
	
	
	 @GetMapping("/{id}/video")
	 @Transactional
	 @Cacheable(value="visualizacaoMemo")
	 public ResponseEntity <DetalhesVisualizadoresDTO> video(@PathVariable Long id)
	 {
		 
		 
		Optional<Video> video= videoRepositorio.findById(id);
		Optional<Exibicao> exibicao= exibicaoRepositorio.findByVideo(video.get());
		Optional<Visualizadores> visualizacoes=visualizacoesRepositorios.findByExibicao(exibicao.get());
	   
		if(exibicao.isPresent())
		{
		
	 	if(visualizacoes.isPresent())
	 	{	  	      
	 	  	 			
	 	        return ResponseEntity.ok(new DetalhesVisualizadoresDTO(visualizacoes.get()));    		 			
	 		
	 	}
	 	
		}
	 	return ResponseEntity.notFound().build();
	 	
	 }
}
