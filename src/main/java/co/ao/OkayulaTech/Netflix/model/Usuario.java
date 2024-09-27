package co.ao.OkayulaTech.Netflix.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.ao.OkayulaTech.Netflix.Enuns.PacotesNetflix;
import co.ao.OkayulaTech.Netflix.Enuns.Sexo;



@Entity
public class Usuario  implements UserDetails{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	
	private String email;
	
	
	private String senha;
	
	
	private String nif;
	
	
	private String telefone;
	
	
	private LocalDate dataNascimento;
	
	@Enumerated
	private Sexo sexo;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Perfil> perfis=new ArrayList<>(); 
	
	@Enumerated
	private PacotesNetflix pacote;
	
	@OneToMany(mappedBy="usuario")
	private List <Exibicao> exibicao;
	
	@OneToMany(mappedBy="usuario")
	private List <Visualizadores> visualizacoes;
	
	@OneToMany(mappedBy="usuario")
	private List <Ponctuacoes> ponctuacoes;
	
	@OneToMany(mappedBy="usuario")
	private List <Usuario_Endereco> enderecoUsu;
	
	@OneToMany(mappedBy="usuario")
	private List <Canais> canais;
	
	@OneToMany(mappedBy="usuario")
	private List <Video> video;
	

	public Usuario()
	{
		
		this.exibicao=new ArrayList<>();
		this.enderecoUsu=new ArrayList<>();
		this.canais=new ArrayList<>();
		
	}
	
	
	public Usuario(String nome, String nif,String telefone,String email, LocalDate dataNascimento,Sexo sexo,PacotesNetflix pacote,String senha) 
	{                                              
		
		this();                                        
		
		this.nome = nome;
		this.email = email;
		this.nif = nif;
		this.dataNascimento = dataNascimento;
		this.telefone=telefone;
		this.sexo=sexo;
		this.pacote=pacote;
		this.senha=senha;
		
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
		Usuario other = (Usuario) obj;
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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public PacotesNetflix getPacote() {
		return pacote;
	}


	public void setPacote(PacotesNetflix pacote) {
		this.pacote = pacote;
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public List<Exibicao> getExibicao() {
		return exibicao;
	}

	

	public List<Usuario_Endereco> getEnderecoUsu() {
		return enderecoUsu;
	}


	public void setEnderecoUsu(List<Usuario_Endereco> enderecoUsu) {
		this.enderecoUsu = enderecoUsu;
	}


	public String getSenha() {
		return senha;
	}                                                            
	                                                            
                                                                
	public List<Visualizadores> getVisualizacoes() {                                                 
		return visualizacoes;                                                               
	}


	public void setVisualizacoes(List<Visualizadores> visualizacoes) {
		this.visualizacoes = visualizacoes;
	}


	public List<Ponctuacoes> getPonctuacoes() {
		return ponctuacoes;
	}


	public void setPonctuacoes(List<Ponctuacoes> ponctuacoes) {
		this.ponctuacoes = ponctuacoes;
	}


	public List<Video> getVideo() {
		return video;
	}


	public void setVideo(List<Video> video) {
		this.video = video;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void setExibicao(List<Exibicao> exibicao) {
		this.exibicao = exibicao;
	}

	public List<Canais> getCanais() {
		return canais;
	}


	public void setCanais(List<Canais> canais) {
		this.canais = canais;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.perfis;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
