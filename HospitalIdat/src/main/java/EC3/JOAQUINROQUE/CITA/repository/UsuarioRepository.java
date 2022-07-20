package EC3.JOAQUINROQUE.CITA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EC3.JOAQUINROQUE.CITA.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsuario(String usuario);

}
