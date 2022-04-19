package com.diasbr.projcap1.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diasbr.projcap1.dto.ClientDTO;
import com.diasbr.projcap1.services.ClientService;

@RestController // informar a annotation para configurar o controlador REST
@RequestMapping(value = "/clients") // informa a rota/caminho do recurso REST
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping // annotation para configurar como endpoint/web service
	public ResponseEntity<List<ClientDTO>> findAll() { // ResponseEntity encapsula respota http
		/*
		 * List<Client> list = new ArrayList<>();
		 * list.add(new Client(1L, "Bruno", "111.111.111-11", 1000D, null, 1));
		 * list.add(new Client(2L, "Isabela", "222.222.222-22", 2000D, null, 2));
		 * list.add(new Client(3L, "Viviane", "333.333.333-33", 3000D, null, 3));
		 * list.add(new Client(4L, "Lorena", "444.444.444-44", 4000D, null, 4));
		 */
		
		List<ClientDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping(value = "/{id}") // annotation para configurar como endpoint/web service
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) { // ResponseEntity encapsula resposta http
			ClientDTO dto = service.findById(id);			
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
