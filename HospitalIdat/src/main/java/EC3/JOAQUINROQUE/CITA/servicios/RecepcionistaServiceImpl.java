package EC3.JOAQUINROQUE.CITA.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EC3.JOAQUINROQUE.CITA.dto.ClienteDTORequest;
import EC3.JOAQUINROQUE.CITA.dto.ClienteDTOResponse;
import EC3.JOAQUINROQUE.CITA.model.Cliente;
import EC3.JOAQUINROQUE.CITA.repository.ClienteRepository;

@Service
public class RecepcionistaServiceImpl implements RecepcionistaService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarRecepcionista(ClienteDTORequest Recepcionista) {
		
		Cliente p = new Cliente();
		p.setNombre(Recepcionista.getNombre());
		p.setCelular(p.getCelular());
		
		repository.save(p);
	}

	@Override
	public void actualizarRecepcionista(ClienteDTORequest Recepcionista) {
		// TODO Auto-generated method stub
		
		Cliente p = new Cliente();
		p.setIdRecepcionista(Recepcionista.getId());
		p.setNombre(Recepcionista.getNombre());
		p.setCelular(p.getCelular());

		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarRecepcionista(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarRecepcionista() {
		
		List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> p = repository.findAll();
		
		for (Cliente Cliente : p) {
			
			dto = new ClienteDTOResponse();
			
			
			dto.setNombre(Cliente.getNombre());
			dto.setCelular(Cliente.getCelular());
			
			
			listar.add(dto);
		}
		
		return listar;
	}
			
		
	@Override
	public ClienteDTOResponse obtenerRecepcionistaId(Integer id) {
		// TODO Auto-generated method stub
		
		Cliente Cliente = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		
		dto.setNombre(Cliente.getNombre());
		dto.setCelular(Cliente.getCelular());
	
		
		return dto;
	}


}
