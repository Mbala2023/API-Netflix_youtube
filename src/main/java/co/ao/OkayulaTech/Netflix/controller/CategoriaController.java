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

import co.ao.OkayulaTech.Netflix.controller.DTOs.CategoriaDTO;
import co.ao.OkayulaTech.Netflix.controller.DTOs.Detalhes.DetalhesCategoriaDTO;
import co.ao.OkayulaTech.Netflix.model.Categoria;
import co.ao.OkayulaTech.Netflix.repositorios.CategoriaRepositorio;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	
	 @GetMapping
	 @Transactional
	 @Cacheable(value="categoriaMemo")
	 public List<DetalhesCategoriaDTO> Buscar()
	 {
	    	
		 List<Categoria> categoria=categoriaRepositorio.findAll();
		 return DetalhesCategoriaDTO.converter(categoria);	
	    	
	 }
	
	
	@PostMapping
	@Transactional
	 @CacheEvict(value="listaDePagamentos", allEntries=true)
	public ResponseEntity  <CategoriaDTO> cadastrar(@RequestBody @Valid Categoria categoria, UriComponentsBuilder uriBuilder)
	{  		   					
		
		Categoria novaCategoria= categoriaRepositorio.save(new Categoria(categoria.isApenasAdulto(),categoria.isEstado(),categoria.getDescricao()));
	    	
	    URI uri=uriBuilder.path("/categorias/{id}").buildAndExpand(novaCategoria.getId()).toUri();
	    			
	    return ResponseEntity.created(uri).body(new CategoriaDTO(novaCategoria));  	    
	    	    		    	
    }	
	
       
	    @PutMapping
	    @Transactional
	    @CacheEvict(value="categoriaMemo", allEntries=true)
	    
	    public ResponseEntity<CategoriaDTO> actualizar(@RequestBody @Valid Categoria categoria )
	    {
	    	
	        Optional <Categoria> optional=categoriaRepositorio.findById(categoria.getId());
	    	
	    	if(optional.isPresent())
	    	{	
	    		optional.get().setDescricao(categoria.getDescricao());
	    		categoriaRepositorio.save(optional.get());
	    		
	
	    	    return ResponseEntity.ok(new CategoriaDTO(optional.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    	
	    }
	 
	 
	    @GetMapping("/{id}")
	    @CacheEvict(value="categoriaMemo", allEntries=true)
	    
	    public ResponseEntity <DetalhesCategoriaDTO> detalhar(@PathVariable Long id)
	    {
	    	Optional <Categoria> categoria=categoriaRepositorio.findById(id);
	    	
	    	if(categoria.isPresent())
	    	{	
	    	    return ResponseEntity.ok(new DetalhesCategoriaDTO(categoria.get()));
	    	}
	    	
	    	return ResponseEntity.notFound().build();
	    }
	
}
