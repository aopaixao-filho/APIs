package org.serratec.pix.repository;

import java.util.Optional;

import org.serratec.pix.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Optional<Transacao> findAllByOrderByDataHoraDesc();
}
