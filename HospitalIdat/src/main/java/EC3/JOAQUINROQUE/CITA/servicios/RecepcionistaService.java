package EC3.JOAQUINROQUE.CITA.servicios;

import java.util.List;

import EC3.JOAQUINROQUE.CITA.dto.*;

public interface RecepcionistaService {
	
	void guardarRecepcionista(ClienteDTORequest Recepcionistao);
	void actualizarRecepcionista(ClienteDTORequest Recepcionista);
	void eliminarRecepcionista(Integer id);
	List<ClienteDTOResponse> listarRecepcionista();
	ClienteDTOResponse obtenerRecepcionistaId(Integer id);

}
