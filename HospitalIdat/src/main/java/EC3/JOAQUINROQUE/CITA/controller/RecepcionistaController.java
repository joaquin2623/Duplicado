package EC3.JOAQUINROQUE.CITA.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import EC3.JOAQUINROQUE.CITA.dto.ClienteDTORequest;
import EC3.JOAQUINROQUE.CITA.dto.ClienteDTOResponse;
import EC3.JOAQUINROQUE.CITA.servicios.RecepcionistaService;


@Controller
@RequestMapping( path = "/Recepcionista/v1")
public class RecepcionistaController {
	@Autowired
	private RecepcionistaService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<ClienteDTOResponse>>  listar() {
		
		return new ResponseEntity<List<ClienteDTOResponse>>(service.listarRecepcionista(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest Recepcionista) {
		service.guardarRecepcionista(Recepcionista);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		ClienteDTOResponse p =service.obtenerRecepcionistaId(id);
		if(p != null) {
			service.eliminarRecepcionista(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody ClienteDTORequest productos) {
		ClienteDTOResponse p =service.obtenerRecepcionistaId(productos.getId());
		if(p != null) {
			service.actualizarRecepcionista(productos);
			return  new ResponseEntity<Void>(HttpStatus.OK);
		}
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOResponse> obtenerId(@PathVariable Integer id) {
		ClienteDTOResponse p =service.obtenerRecepcionistaId(id);
		if(p != null) {
			return  new ResponseEntity<ClienteDTOResponse>(service.obtenerRecepcionistaId(id),HttpStatus.OK);
		}
		return  new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
}

	
	


