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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import co.ao.OkayulaTech.Netflix.controller.DTOs.UsuarioDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesUsuarioDTO;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.repositorios.UsuarioRepositorio;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	 @GetMapping
	 @Transactional
	 @Cacheable(value="usuariosMemo")
	 public List<DetalhesUsuarioDTO> Buscar()
	 {
	    	
		 List<Usuario> usuario=usuarioRepositorio.findAll();
		 return DetalhesUsuarioDTO.converter(usuario);	
	    	
	 }
	
	
	@PostMapping
	 @Transactional
	 @CacheEvict(value="usuariosMemo", allEntries=true)
	public ResponseEntity  <DetalhesUsuarioDTO> cadastrar(@RequestBody @Valid UsuarioDTO usuario, UriComponentsBuilder uriBuilder)
	{  		   		
		
		Optional<Usuario> usu= usuarioRepositorio.findByEmail(usuario.getEmail());
		
		if(!usu.isPresent())
		{
		
	    String senhaEncriptada=new BCryptPasswordEncoder().encode(usuario.getSenha());
		
		Usuario novoUsuario= new Usuario(usuario.getNome(),usuario.getNif(),usuario.getTelefone(),usuario.getEmail(),usuario.getDataNascimento(),usuario.getSexo(),usuario.getPacote(),senhaEncriptada);
	                             
		Usuario novoUsuario1= usuarioRepositorio.save(novoUsuario);
		
	    
	    URI uri=uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario1.getId()).toUri();
	    			
	    return ResponseEntity.created(uri).body(new DetalhesUsuarioDTO(novoUsuario1));  	
	    
		
		
		}
		
		else {
			
			return ResponseEntity.notFound().build();
		}
		
	
    }	
	
       
	 @PutMapping
	 @Transactional
	 @CacheEvict(value="usuariosMemo", allEntries=true)
	    
	    public ResponseEntity<DetalhesUsuarioDTO> actualizar(@RequestBody @Valid Usuario usuario )
	    {
	    	
	        Optional <Usuario> optional=usuarioRepositorio.findById(usuario.getId());
	    	
	    	if(optional.isPresent())
	    	{	
	    		optional.get().setNome(usuario.getNome());
	    		usuarioRepositorio.save(optional.get());
	    		
	
	    	    return ResponseEntity.ok(new DetalhesUsuarioDTO(optional.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    	
	    }
	 
	 
	 @GetMapping("/{id}")
	 @Transactional
	 @CacheEvict(value="usuariosMemo", allEntries=true)
	    
	    public ResponseEntity <DetalhesUsuarioDTO> detalhar(@PathVariable Long id)
	    {
	    	Optional <Usuario> usuario=usuarioRepositorio.findById(id);
	    	
	    	if(usuario.isPresent())
	    	{	
	    	    return ResponseEntity.ok(new DetalhesUsuarioDTO(usuario.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    }
	


}
