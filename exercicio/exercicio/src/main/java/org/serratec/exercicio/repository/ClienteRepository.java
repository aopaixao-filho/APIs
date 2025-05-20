package org.serratec.exercicio.repository;

import org.serratec.exercicio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

}
