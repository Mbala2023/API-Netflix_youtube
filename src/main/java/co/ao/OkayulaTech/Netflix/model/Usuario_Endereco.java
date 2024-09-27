package co.ao.OkayulaTech.Netflix.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Tb_Endereco_Usuario")
public class Usuario_Endereco {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuarioID",nullable=false)
	private Usuario usuario;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="enderecoID",nullable=false)
	private Endereco endereco;
	
	
	
	public Usuario_Endereco() {
		
	}
	
	
	public Usuario_Endereco(Usuario usuario,Endereco endereco)
	{
		this.usuario=usuario;
		this.endereco=endereco;
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
		Usuario_Endereco other = (Usuario_Endereco) obj;
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


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
