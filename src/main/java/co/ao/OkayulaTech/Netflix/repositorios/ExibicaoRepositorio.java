package co.ao.OkayulaTech.Netflix.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ao.OkayulaTech.Netflix.model.Exibicao;
import co.ao.OkayulaTech.Netflix.model.Usuario;
import co.ao.OkayulaTech.Netflix.model.Video;



public interface ExibicaoRepositorio extends JpaRepository<Exibicao,Long> {

	
	Optional<Exibicao> findByUsuario(Optional<Usuario> usuario);
	
	//@Query("SELECT exibicao.id FROM Exibicao WHERE video_id > :idVideo")
    Optional<Exibicao> findByVideo(Video video);

	Optional<Exibicao> findByVideoAndUsuario(Video video, Usuario usuario);

	Optional<Exibicao> findByVideo(Long id);

}
