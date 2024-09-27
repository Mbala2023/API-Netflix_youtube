package co.ao.OkayulaTech.Netflix.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.ao.OkayulaTech.Netflix.controller.DTOs.CategoriaDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.VideoDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesVideoDTO;
import co.ao.OkayulaTech.Netflix.model.Canais;
import co.ao.OkayulaTech.Netflix.model.Categoria;
import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Video;
import co.ao.OkayulaTech.Netflix.repositorios.CanaisRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.ExibicaoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.VideoRepositorio;



@RestController
@RequestMapping("/videos")
public class VideoController {
	
	@Autowired
	private VideoRepositorio videoRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private CanaisRepositorio canalRepositorio;

	
	@Autowired
	private ExibicaoRepositorio exibicaoRepositorio;
	
	
	
	 @GetMapping
	 @Transactional
	 @Cacheable(value="videoMemo")
	 public List<DetalhesVideoDTO> Buscar()
	 {
	    	
		 List<Video> video=videoRepositorio.findAll();
		 return DetalhesVideoDTO.converter(video);	
	    	
	 }
	
	
	@PostMapping
	@Transactional
	 @CacheEvict(value="videoMemo", allEntries=true)
	public ResponseEntity  <VideoDTO> cadastrar(@RequestBody @Valid VideoDTO videoDTO, UriComponentsBuilder uriBuilder)
	{  
		
		Usuario usuarioLogado=  (Usuario)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    
	    Optional<Canais> usuarioCanal=canalRepositorio.findByUsuario(usuarioLogado);
	      
	 //  List<Usuario> todosUsuarios=usuarioRepositorio.findAll();
	       
	    
	    if(usuarioCanal.isPresent())
	    {
			
		   Video novoVideo= new Video(videoDTO.getDescricao(),videoDTO.getTitulo(),videoDTO.getUrl(),usuarioCanal.get().getUsuario(),videoDTO.getPacote());
    	
		   CategoriaDTO categoria = videoDTO.getCategoria();
		
		   novoVideo.getCategoria().add(new Categoria(categoria.isApenasAdulto(),categoria.isEstado(),categoria.getDescricao()));
	
		   Video novoVideo1= videoRepositorio.save(novoVideo);
		   
		   
		 /*  for(int i = 0; i < todosUsuarios.size(); i++) {
              		  			 
	    			 String to="victoriapreciosaesmeralda@email.com";
	    			 String subject="Notificação de Novo Vídeo";
	    	         String text="Veja agora  <<"+ videoDTO.getTitulo() +">> " +videoDTO.getDescricao()+" na Netflix";
	    	    	 emailService.sendSimpleMessage(to, subject, text); 
	    		  
	        //  } */
	    	
		   
	       URI uri=uriBuilder.path("/videos/{id}").buildAndExpand(novoVideo1.getId()).toUri(); 
	    			
	       return ResponseEntity.created(uri).body(new VideoDTO(novoVideo1));  	
	    
	    }
	    
	  	return ResponseEntity.notFound().build();
	    	    		    	
    }	
	
       
	    @PutMapping
	    @Transactional
		 @CacheEvict(value="videoMemo", allEntries=true)
	    
	    public ResponseEntity<VideoDTO> actualizar(@RequestBody @Valid Video video )
	    {
	    	
	        Optional <Video> optional=videoRepositorio.findById(video.getId());
	    	
	    	if(optional.isPresent())
	    	{	
	    		optional.get().setTitulo(video.getTitulo());
	    		videoRepositorio.save(optional.get());
	    		
	
	    	    return ResponseEntity.ok(new VideoDTO(optional.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    	
	    }    
	   
	    
	    @GetMapping("/{id}/exibir")
	    @Transactional
		 @CacheEvict(value="videoMemo", allEntries=true)
	    public ResponseEntity  <DetalhesVideoDTO> exibir(@PathVariable Long id)
	    {  		   		          
	    	
	      Usuario usuario=  (Usuario)  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      
	      Optional<Video> video = videoRepositorio.findById(id);  
	      
	      Optional<Canais> usuarioCanal=canalRepositorio.findByUsuario(usuario);
		    
		 	
	 	    if(usuarioCanal.isPresent() && video.get().getUsuario()==usuario)
	 	                                                                                                                                           
	 	    	return ResponseEntity.notFound().build(); 
	 	    
	 	        Optional<Exibicao> exibicao=exibicaoRepositorio.findByVideoAndUsuario(video.get(),usuario);
	                                                   
	     	    if(exibicao.isEmpty())
	     	    {          								
	     	    	 exibicaoRepositorio.save(new Exibicao(video.get(),usuarioRepositorio.findById(usuario.getId()).get(),0,false));   	    		     
	     	    }		  
	     	    		 
	     	    return ResponseEntity.ok(new DetalhesVideoDTO(video.get()));    		  
	 	    
	    }
	 
	 
	    @GetMapping("/{id}")
	    @Transactional
		 @CacheEvict(value="videoMemo", allEntries=true)
	    
	    public ResponseEntity <DetalhesVideoDTO> detalhar(@PathVariable Long id )
	    {
		 
	      Optional<Video> video=videoRepositorio.findById(id);
	    	
	    	if(video.isPresent())
	    	{	  	    
	    	   	    	    	 
	    	         return ResponseEntity.ok(new DetalhesVideoDTO(video.get()));    	         	    	
	    	    
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    }

}
