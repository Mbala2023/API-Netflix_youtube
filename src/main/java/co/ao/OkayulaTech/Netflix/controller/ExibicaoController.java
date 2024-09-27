package co.ao.OkayulaTech.Netflix.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ao.OkayulaTech.Netflix.controller.DTOs.ExibicaoDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesExibicaoDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesVisualizadoresDTO;
import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Ponctuacoes;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Video;
import co.ao.OkayulaTech.Netflix.model.Visualizadores;
import co.ao.OkayulaTech.Netflix.repositorios.ExibicaoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.PonctucaoesRepositorios;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.VideoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.VisualizacoesRepositorios;
import co.ao.OkayulaTech.Netflix.service.EnailService;



@RestController
@RequestMapping("/exibicoes")
public class ExibicaoController {
	
	@Autowired
	private VideoRepositorio videoRepositorio;
	
	@Autowired
	private ExibicaoRepositorio exibicaoRepositorio;
	
	@Autowired
    private EnailService emailService;
	
	@Autowired
	private VisualizacoesRepositorios visualizacoesRepositorios;
	
	@Autowired
	private PonctucaoesRepositorios ponctuacoesRepositorios;

	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	@GetMapping
	@Transactional
	@Cacheable(value="exibicaoMemo")
	 public List <DetalhesExibicaoDTO> Buscar()
	 {
	    	
		   List<Exibicao> exibicao=exibicaoRepositorio.findAll();
		   return DetalhesExibicaoDTO.converter(exibicao);	
	    	
	  }

	 
	 @PatchMapping("/{id}/ponctuar") 
	 @Transactional
	 @CacheEvict(value="exibicaoMemo", allEntries=true)
	    public ResponseEntity<Void> ponctuar(@PathVariable Long id,@RequestBody @Valid ExibicaoDTO exibicaoDTO)
	    {
	    	  
		 Usuario usuario=  (Usuario)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		 Optional<Video> video=videoRepositorio.findById(id); 
    	 
		 Optional<Video> videoEUsuario=videoRepositorio.findByIdAndUsuario(id,usuario); 
		 
    	 Optional<Exibicao> exibicao=exibicaoRepositorio.findByVideo(video.get());
    	 
    	 Optional<Ponctuacoes> ponctuacoes=ponctuacoesRepositorios.findByExibicaoAndUsuario(exibicao.get(),usuario); 	 
	    	
    	
    	if(!ponctuacoes.isPresent())
    	{	  	   		  		
	    	
    		if(!videoEUsuario.isPresent())
    		{
    			
	    		double PontuacaoActual=exibicao.get().getPonctuacao(); 
	            double pontuacaoTotal=PontuacaoActual+exibicaoDTO.getPonctuacao();
	    		exibicao.get().setPonctuacao(pontuacaoTotal);
	    		exibicaoRepositorio.save(exibicao.get()); 
	    		    		
	    		ponctuacoesRepositorios.save(new Ponctuacoes(exibicao.get(),usuarioRepositorio.findById(usuario.getId()).get(),exibicaoDTO.getPonctuacao()));
	    		
	    		 String to=video.get().getUsuario().getEmail();
    	 	     String dataVisualizada=exibicao.get().getDataVizualizacao().toString();
    	 	     String videoV=video.get().getTitulo();
    	 	     String subject="Ponctuacao do Vídeo";
    	 	     String text="O vídeo intitulado  <<"+ videoV +">> foi ponctuado com  "+ exibicaoDTO.getPonctuacao()+"  por "+ usuario.getNome()+"-----"+usuario.getEmail()+"  --em: "+dataVisualizada ;
    	 	     emailService.sendSimpleMessage(to, subject, text);
	    	     
    	 	     
	    	    return ResponseEntity.noContent().build();
	    	    
	    	}	
    		
    		
    		return ResponseEntity.notFound().build();
	    	
		 	    
    	}
		 	    
	    	return ResponseEntity.notFound().build();
	    	
	    	
	    }
	 
	 
	    @PatchMapping("/{id}/ver") 
	    @Transactional
		 @CacheEvict(value="exibicaoMemo", allEntries=true)
	    public ResponseEntity<Void> ver(@PathVariable Long id)
	    {
	                                  	
	    	
		 Usuario usuario= (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		  Optional<Video> video=videoRepositorio.findById(id); 
		  
		  Optional<Video> videoEUsuario=videoRepositorio.findByIdAndUsuario(id,usuario); 
	    	 
	    	Optional<Exibicao> exibicao=exibicaoRepositorio.findByVideo(video.get());
	    	 
	    	Optional<Visualizadores> vizualizacao=visualizacoesRepositorios.findByExibicaoAndUsuario(exibicao.get(),usuario); 	 
		    	
	    	
	    	if(!vizualizacao.isPresent())
	    	{	  	   		
	    		if(!videoEUsuario.isPresent())
	    		{
	    			
	    		
	    		exibicao.get().setVizualizacao(true);
	    		exibicaoRepositorio.save(exibicao.get()); 
	    		
	    		visualizacoesRepositorios.save(new Visualizadores(exibicao.get(),usuarioRepositorio.findById(usuario.getId()).get()));
	    		
	    		 String to=video.get().getUsuario().getEmail();
	    	 	 String dataVisualizada=exibicao.get().getDataVizualizacao().toString();
	    	 	 String videoV=video.get().getTitulo();
	    	 	 String subject="Visualização do Vídeo";
	    	 	 String text="O vídeo intitulado  <<"+ videoV +">> foi visualizado por "+ usuario.getNome()+" ---- "+usuario.getEmail()+ "   em: "+dataVisualizada ;
	    	 	 emailService.sendSimpleMessage(to, subject, text);
	    	     
	    	     return ResponseEntity.noContent().build();
	    	     
	    	  }
	    		
	    		else
	    		{
	    		
	    		   return ResponseEntity.notFound().build();
	    		}
	    		
	    	}
	    			 	    
	    	
	    	return ResponseEntity.notFound().build();
	    	
	    	
	    }
	
	    
   

 @GetMapping("/{id}/visualizadores")
 @Transactional
 @CacheEvict(value="exibicaoMemo", allEntries=true)
 public ResponseEntity <DetalhesVisualizadoresDTO> visualizadores(@PathVariable Long id)
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
 
 
 
 @GetMapping("/{id}/visualizados")
 @Transactional
 @CacheEvict(value="exibicaoMemo", allEntries=true)
 public ResponseEntity <DetalhesExibicaoDTO> visualizados(@PathVariable Long id)
 {	 
	 
	Optional<Video> video= videoRepositorio.findById(id);
	Optional<Exibicao> exibicao=exibicaoRepositorio.findByVideo(video.get());
   
 	if(exibicao.isPresent() && video.isPresent())
 	{	  	      
 	  	
 		if(exibicao.get().isVizualizacao())
 		{	
 	        return ResponseEntity.ok(new DetalhesExibicaoDTO(exibicao.get()));    	
 		}
 				
 	}
 	
 	return ResponseEntity.notFound().build();
 	
 }
 
 
 
 
 @GetMapping("/{id}")
 @Transactional
 @CacheEvict(value="exibicaoMemo", allEntries=true)
 public ResponseEntity <DetalhesExibicaoDTO> detalhar(@PathVariable Long id)
 {
	 	 
	  Optional<Video> video= videoRepositorio.findById(id);
	  Optional<Exibicao> exibicao=exibicaoRepositorio.findByVideo(video.get());
   
 	  if(exibicao.isPresent() && video.isPresent())
 	  {	  	      
 			
 	        return ResponseEntity.ok(new DetalhesExibicaoDTO(exibicao.get()));    	
 		
 	  }
 		
 	  return ResponseEntity.notFound().build();
 	
 }
 
 

}
