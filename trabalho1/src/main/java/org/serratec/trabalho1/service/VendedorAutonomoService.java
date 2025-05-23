package org.serratec.trabalho1.service;

import java.util.List;
import java.util.Optional;

import org.serratec.trabalho1.entity.VendedorAutonomo;
import org.serratec.trabalho1.repository.VendedorAutonomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorAutonomoService {

    @Autowired
    private VendedorAutonomoRepository repository;

    public List<VendedorAutonomo> listarTodos() {
        return repository.findAll();
    }

    public Optional<VendedorAutonomo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public VendedorAutonomo salvar(VendedorAutonomo autonomo) {
        return repository.save(autonomo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}