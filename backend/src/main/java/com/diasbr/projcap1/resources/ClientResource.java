package com.diasbr.projcap1.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.diasbr.projcap1.entities.Client;

@RestController //informar a annotation para configurar o controlador REST
@RequestMapping(value = "/clients") //informa a rota/caminho do recurso REST
public class ClientResource {

	@GetMapping // annotation para configurar como endpoint/web service
	public ResponseEntity<List<Client>> findAll(){ //ResponseEntity encapsula respota http
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L, "Bruno", "111.111.111-11", 1000D, null, 1));
		list.add(new Client(2L, "Isabela", "222.222.222-22", 2000D, null, 2));
		list.add(new Client(3L, "Viviane", "333.333.333-33", 3000D, null, 3));
		list.add(new Client(4L, "Lorena", "444.444.444-44", 4000D, null, 4));
		return ResponseEntity.ok().body(list);
		
	}
}
