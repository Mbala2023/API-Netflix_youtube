package co.ao.OkayulaTech.Netflix.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import co.ao.OkayulaTech.Netflix.model.Categoria;


public interface CategoriaRepositorio extends JpaRepository<Categoria,Long>
{

	
}
