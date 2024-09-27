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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import co.ao.OkayulaTech.Netflix.controller.DTOs.CanaisDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesCanaisDTO;
import co.ao.OkayulaTech.Netflix.model.Canais;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.repositorios.CanaisRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioRepositorio;


@RestController
@RequestMapping("/canais")
public class CanaisController {

	@Autowired
	private CanaisRepositorio canaisRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	
	@GetMapping
	@Transactional
	@Cacheable(value="canaisMemoria")
	 public List <DetalhesCanaisDTO> Buscar()
	 {
	    	
		   List<Canais> exibicao=canaisRepositorio.findAll();
		   return DetalhesCanaisDTO.converter(exibicao);	
	    	
	  }
 


@PostMapping
@Transactional
@CacheEvict(value="canaisMemoria", allEntries=true)
public ResponseEntity  <DetalhesCanaisDTO> cadastrar(@RequestBody @Valid CanaisDTO canaisDTO, UriComponentsBuilder uriBuilder)
{  		   		
   
	Optional<Usuario> usuario= usuarioRepositorio.findById(canaisDTO.getUsuario());
      
    Canais novoCanal = canaisRepositorio.save(new Canais(usuario.get(),canaisDTO.getNome()));
      
    URI uri=uriBuilder.path("/canais/{id}").buildAndExpand(novoCanal.getId()).toUri();    	   		  	    	
   
    return ResponseEntity.created(uri).body(new DetalhesCanaisDTO(novoCanal));
    
  }	

   
    @PutMapping
    @Transactional
    @CacheEvict(value="canaisMemoria", allEntries=true)
    
    public ResponseEntity<CanaisDTO> actualizar(@RequestBody @Valid Canais canais )
    {
    	
        Optional <Canais> optional=canaisRepositorio.findByUsuario(canais.getUsuario());
    	
    	if(optional.isPresent())
    	{	
    		optional.get().setNome(canais.getNome());
    		canaisRepositorio.save(optional.get());
    		

    	    return ResponseEntity.ok(new CanaisDTO(optional.get()));
    	}
    	
    	return ResponseEntity.notFound().build();
    	
    }
 
   
 
 @GetMapping("/{id}")
 @Transactional
 @CacheEvict(value="canaisMemoria", allEntries=true)
 public ResponseEntity <DetalhesCanaisDTO> detalhar(@PathVariable Long id)
 {
	 
	  Optional <Canais> optional=canaisRepositorio.findByUsuario(id);
   
 	if(optional.isPresent())
 	{	  	      
 	    	 
 	     return ResponseEntity.ok(new DetalhesCanaisDTO(optional.get()));    	      
 	    
 	}
 	
 	return ResponseEntity.notFound().build();
 	
 }
	
}
