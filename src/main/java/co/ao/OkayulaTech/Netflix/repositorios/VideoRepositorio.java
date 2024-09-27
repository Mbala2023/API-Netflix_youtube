package co.ao.OkayulaTech.Netflix.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Video;

public interface VideoRepositorio extends JpaRepository<Video,Long>{

	Optional<Video> findByTitulo(String titulo);

	Optional<Video> findByUrl(String url);

	Optional<Video> findByUsuarioAndId(Usuario usuario, Long id);

	Optional<Video> findByUsuario(Usuario usuario);

	Optional<Video> findByIdAndUsuario(Long id, Usuario usuario);

	
	

}
