package org.serratec.aula4.repository;

import java.util.UUID;

import org.serratec.aula4.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}