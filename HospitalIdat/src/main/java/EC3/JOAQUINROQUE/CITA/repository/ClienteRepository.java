package EC3.JOAQUINROQUE.CITA.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EC3.JOAQUINROQUE.CITA.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
