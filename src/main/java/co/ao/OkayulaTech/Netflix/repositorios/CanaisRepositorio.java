package co.ao.OkayulaTech.Netflix.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ao.OkayulaTech.Netflix.model.Canais;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Video;

public interface CanaisRepositorio extends JpaRepository<Canais,Long> {

	Optional<Canais> findByUsuario(Usuario usuario);

	Optional<Canais> findByUsuario(Long id);

}
