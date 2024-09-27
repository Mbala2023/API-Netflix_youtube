package co.ao.OkayulaTech.Netflix.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="tb_Endereco")
public class Endereco {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	private String rua;
	
	@Column (nullable=false)
	private String bairro;
	
	@Column (nullable=false)
	private String municipio;
	
	@Column (nullable=false)
	private String provincia;


    @OneToMany(mappedBy="endereco")
	private List <Usuario_Endereco> enderecoUsu;
	
	
	public Endereco()
	{
		this.enderecoUsu=new ArrayList<>();	
	}
	
	
	public Endereco(String rua, String bairro, String municipio, String provincia) 
	{                                              
		                                                 
		this();                                        
		
		this.rua = rua;
		this.bairro = bairro;
		this.municipio = municipio;
		this.provincia = provincia;
		
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
		Endereco other = (Endereco) obj;
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


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public List<Usuario_Endereco> getEnderecoUsu() {
		return enderecoUsu;
	}


	public void setEnderecoUsu(List<Usuario_Endereco> enderecoUsu) {
		this.enderecoUsu = enderecoUsu;
	}


	
	
	
}
