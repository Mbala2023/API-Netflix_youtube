package co.ao.OkayulaTech.Netflix.controller.DTOs;

import java.time.LocalDate;
import co.ao.OkayulaTech.Netflix.model.Canais;


public class CanaisDTO {

	 private Long id;
		
		private Long usuario;
				
		private LocalDate dataCadastro;
				
		private String nome;
		
		
		
		public CanaisDTO()
		{}
		
		public CanaisDTO(Canais canais) {
			
			
			this.id=canais.getId();
			this.usuario = canais.getUsuario().getId();
			this.nome =canais.getNome();	
	
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getUsuario() {
			return usuario;
		}

		public void setUsuario(Long usuario) {
			this.usuario = usuario;
		}

		public LocalDate getDataCadastro() {
			return dataCadastro;
		}

		public void setDataCadastro(LocalDate dataCadastro) {
			this.dataCadastro = dataCadastro;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
	
}
