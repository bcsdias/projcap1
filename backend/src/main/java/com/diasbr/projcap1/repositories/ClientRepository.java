package com.diasbr.projcap1.repositories; //CAMADA DE ACESSO A DADOS

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diasbr.projcap1.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{  // ALTERAR PARA INTERFACE

}
