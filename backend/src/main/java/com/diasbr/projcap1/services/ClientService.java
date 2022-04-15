package com.diasbr.projcap1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diasbr.projcap1.entities.Client;
import com.diasbr.projcap1.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true) // IMPORTAR DO SPRING
	public List<Client> findAll(){
		return repository.findAll();
		
	}
	
}
