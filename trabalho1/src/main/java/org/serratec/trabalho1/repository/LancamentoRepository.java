package org.serratec.trabalho1.repository;
import org.serratec.trabalho1.entity.LancamentoVendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {

}
