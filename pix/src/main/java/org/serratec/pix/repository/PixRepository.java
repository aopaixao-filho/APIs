package org.serratec.pix.repository;
import java.util.Optional;

import org.serratec.pix.entity.Pix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PixRepository extends JpaRepository<Pix, Long> {
    Optional<Pix> findByNumeroConta(String numeroConta);
}