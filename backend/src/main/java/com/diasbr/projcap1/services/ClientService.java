package com.diasbr.projcap1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diasbr.projcap1.dto.ClientDTO;
import com.diasbr.projcap1.entities.Client;
import com.diasbr.projcap1.repositories.ClientRepository;
import com.diasbr.projcap1.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true) // IMPORTAR DO SPRING
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		
		// CONVERTER LISTA DE CLIENT PARA UMA LISTA CLIENTDTO
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
				
		/* OUTRA FORMA PARA CONVERTER LISTA DE CLIENT PARA UMA LISTA CLIENTDTO
		List<ClientDTO> listDto = new ArrayList<>();
		for (Client cli : list) {
			listDto.add(new ClientDTO(cli));
		}
		
		return listDto;
		*/
		
		
	}
	@Transactional(readOnly = true) // IMPORTAR DO SPRING
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Entidade não encontada"));
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		entity = repository.save(entity);

		return new ClientDTO(entity);
	}
	
}
