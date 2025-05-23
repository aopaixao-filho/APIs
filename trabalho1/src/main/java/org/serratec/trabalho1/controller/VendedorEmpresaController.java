package org.serratec.trabalho1.controller;

import java.util.List;

import org.serratec.trabalho1.entity.VendedorEmpresa;
import org.serratec.trabalho1.repository.VendedorEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendedores/empresa")
public class VendedorEmpresaController {

    @Autowired
    private VendedorEmpresaRepository vendedorEmpresaRepository;

    @GetMapping
    public ResponseEntity<List<VendedorEmpresa>> listar() {
        return ResponseEntity.ok(vendedorEmpresaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<List<VendedorEmpresa>> criar(@RequestBody @Valid List<VendedorEmpresa> vendedores) {
        List<VendedorEmpresa> salvos = vendedorEmpresaRepository.saveAll(vendedores);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }
}