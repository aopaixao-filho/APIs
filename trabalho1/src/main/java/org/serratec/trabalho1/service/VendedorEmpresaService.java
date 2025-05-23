package org.serratec.trabalho1.service;

import java.util.List;
import java.util.Optional;

import org.serratec.trabalho1.entity.VendedorEmpresa;
import org.serratec.trabalho1.repository.VendedorEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorEmpresaService {

    @Autowired
    private VendedorEmpresaRepository repository;

    public List<VendedorEmpresa> listarTodos() {
        return repository.findAll();
    }

    public Optional<VendedorEmpresa> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public VendedorEmpresa salvar(VendedorEmpresa empresa) {
        return repository.save(empresa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}