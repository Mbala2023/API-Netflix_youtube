package co.ao.OkayulaTech.Netflix.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Visualizadores;

public interface VisualizacoesRepositorios extends JpaRepository<Visualizadores,Long> {

	Optional<Visualizadores> findByExibicao(Exibicao exibicao);

	Optional<Visualizadores> findByExibicaoAndUsuario(Exibicao exibicao, Usuario usuario);

}
