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
import co.ao.OkayulaTech.Netflix.controller.DTOs.UsuarioEnderecoDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesUsuarioEnderecoDTO;
import co.ao.OkayulaTech.Netflix.model.Endereco;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Usuario_Endereco;
import co.ao.OkayulaTech.Netflix.repositorios.EnderecoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioEnderecoRepositorio;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioRepositorio;



@RestController
@RequestMapping("/usuarioEnd")
public class UsuarioEnderecoController {

	
	@Autowired
	private UsuarioEnderecoRepositorio usuarioUsuRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private EnderecoRepositorio enderecoRepositorio;
	
	
	@GetMapping
	 @Transactional
	 @Cacheable(value="usuarioEnderecoMemo")
	 public List <DetalhesUsuarioEnderecoDTO> Buscar()
	 {
	    	
		   List<Usuario_Endereco> endereco=usuarioUsuRepositorio.findAll();
		   return DetalhesUsuarioEnderecoDTO.converter(endereco);	
	    	
	  }
	
	
	@PostMapping
	 @Transactional
	 @CacheEvict(value="usuarioEnderecoMemo", allEntries=true)
	public ResponseEntity  <DetalhesUsuarioEnderecoDTO> cadastrar(@RequestBody @Valid UsuarioEnderecoDTO usuarioEnDTO, UriComponentsBuilder uriBuilder)
	{  		   			
				  	
	    Optional<Usuario> usuario = usuarioRepositorio.findById(usuarioEnDTO.getUsuario());
	    
	   
	    Optional<Endereco> endereco = enderecoRepositorio.findById(usuarioEnDTO.getEndereco());
	    
	    Usuario_Endereco novoUsuEnd= usuarioUsuRepositorio.save(new Usuario_Endereco(usuario.get(),endereco.get()));
	    
	    URI uri=uriBuilder.path("/usuario_end/{id}").buildAndExpand(novoUsuEnd.getId()).toUri();  
	 	    	  
	    return ResponseEntity.created(uri).body(new DetalhesUsuarioEnderecoDTO(novoUsuEnd));
	    
	  }	
	
	
	
	 @PutMapping
	 @Transactional
	 @CacheEvict(value="usuarioEnderecoMemo", allEntries=true)
	    
	    public ResponseEntity<UsuarioEnderecoDTO> actualizar(@RequestBody @Valid Usuario_Endereco usuarioEnd )
	    {
	    	
	        Optional <Usuario_Endereco> optional=usuarioUsuRepositorio.findById(usuarioEnd.getId());
	    	
	    	if(optional.isPresent())
	    	{	
	    		optional.get().setId(usuarioEnd.getId());
	    		usuarioUsuRepositorio.save(optional.get());
	    		

	    	    return ResponseEntity.ok(new UsuarioEnderecoDTO(optional.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    	
	    }
	
	
	 
	 @GetMapping("/{id}")
	 @Transactional
	 @CacheEvict(value="usuarioEnderecoMemo", allEntries=true)
	    
	    public ResponseEntity <DetalhesUsuarioEnderecoDTO> detalhar(@PathVariable Long id)
	    {
	    	Optional <Usuario_Endereco> enderecoUsu=usuarioUsuRepositorio.findById(id);
	    	
	    	if(enderecoUsu.isPresent())
	    	{	
	    	    return ResponseEntity.ok(new DetalhesUsuarioEnderecoDTO(enderecoUsu.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    }
	
	 	
	 	
}
