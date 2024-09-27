package co.ao.OkayulaTech.Netflix.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Ponctuacoes;
import co.ao.OkayulaTech.Netflix.model.Usuario;


public interface PonctucaoesRepositorios extends JpaRepository<Ponctuacoes,Long>{

	

	Optional<Ponctuacoes> findByExibicao(Exibicao exibicao);

	Optional<Ponctuacoes> findByExibicaoAndUsuario(Exibicao exibicao, Usuario usuario);

}
