package co.ao.OkayulaTech.Netflix.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_Canais")
public class Canais {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioID",nullable=false)
	private Usuario usuario;
	
	@Column (nullable=false)
	private String nome;
	
	@Column (nullable=false)
	private LocalDate dataCadastro;
			
	
	
	public Canais()
	{
		this.dataCadastro=LocalDate.now();	
	}
	
	
	public Canais( Usuario usuario,String nome) 
	{                                              
		                                                 
		this();                                        
		
		
		this.usuario = usuario;
		this.nome=nome;
		
	}


	@Override
	public int hashCode() 
	{		
                                       	                                                                         
		final int prime = 31;                                                                                                                                                                                                                                                      
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;	
		
	}                                                                                                                                              
    
	
	@Override
	public boolean equals(Object obj)
	{
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canais other = (Canais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDate getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
	

}
