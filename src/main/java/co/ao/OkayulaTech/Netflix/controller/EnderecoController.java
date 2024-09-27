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

import co.ao.OkayulaTech.Netflix.controller.DTOs.EnderecoDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesEnderecoDTO;
import co.ao.OkayulaTech.Netflix.model.Endereco;
import co.ao.OkayulaTech.Netflix.repositorios.EnderecoRepositorio;



@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	
	@Autowired
	private EnderecoRepositorio enderecoRepo;
	
	
	 @GetMapping
	 @Transactional
	 @Cacheable(value="enderecoMemo")
	 public List<DetalhesEnderecoDTO> Buscar(Endereco endereco1)
	 {
	    	
		 List<Endereco> endereco=enderecoRepo.findAll();
		 return DetalhesEnderecoDTO.converter(endereco);	
	    	
	 }
	
	
	@PostMapping
	@Transactional
	 @CacheEvict(value="enderecoMemo", allEntries=true)
	public ResponseEntity  <EnderecoDTO> cadastrar(@RequestBody @Valid Endereco endereco, UriComponentsBuilder uriBuilder)
	{  		   					
		
		Endereco novoEndereco= enderecoRepo.save(new Endereco(endereco.getRua(),endereco.getBairro(),endereco.getMunicipio(),endereco.getProvincia()));
	    	
	    URI uri=uriBuilder.path("/enderecos/{id}").buildAndExpand(novoEndereco.getId()).toUri();
	    			
	    return ResponseEntity.created(uri).body(new EnderecoDTO(novoEndereco));  	    
	    	    		    	
    }	
	
       
	 @PutMapping
	    @Transactional
	    @CacheEvict(value="enderecoMemo", allEntries=true)
	 
	    public ResponseEntity<EnderecoDTO> actualizar(@RequestBody @Valid Endereco endereco )
	    {
	    	
	        Optional <Endereco> optional=enderecoRepo.findById(endereco.getId());
	    	
	    	if(optional.isPresent())
	    	{	
	    		optional.get().setBairro(endereco.getBairro());
	    		enderecoRepo.save(optional.get());
	    		
	
	    	    return ResponseEntity.ok(new EnderecoDTO(optional.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    	
	    }
	 
	 
	 @GetMapping("/{id}")
	 @Transactional
	 @CacheEvict(value="enderecoMemo", allEntries=true)
	    
	    public ResponseEntity <DetalhesEnderecoDTO> detalhar(@PathVariable Long id)
	    {
	    	Optional <Endereco> endereco=enderecoRepo.findById(id);
	    	
	    	if(endereco.isPresent())
	    	{	
	    	    return ResponseEntity.ok(new DetalhesEnderecoDTO(endereco.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    }
	

}
