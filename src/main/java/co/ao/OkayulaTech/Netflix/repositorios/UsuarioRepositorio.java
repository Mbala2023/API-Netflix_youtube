package co.ao.OkayulaTech.Netflix.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ao.OkayulaTech.Netflix.Enuns.PacotesNetflix;
import co.ao.OkayulaTech.Netflix.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long>{

	

	

	Optional<Usuario> findByEmail(String username);

	Usuario findByPacote(PacotesNetflix pacote);

	Optional<Usuario> findById(String nomeUsu);

	Optional<Usuario> findByNome(String nomeUsu);



	
}
