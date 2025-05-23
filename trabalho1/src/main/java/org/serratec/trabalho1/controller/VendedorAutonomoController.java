package org.serratec.trabalho1.controller;

import java.util.List;

import org.serratec.trabalho1.entity.VendedorAutonomo;
import org.serratec.trabalho1.repository.VendedorAutonomoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vendedores/autonomos")
public class VendedorAutonomoController {

    @Autowired
    private VendedorAutonomoRepository vendedorAutonomoRepository;

    @PostMapping
    public ResponseEntity<List<VendedorAutonomo>> criar(@RequestBody @Valid List<VendedorAutonomo> vendedores) {
        List<VendedorAutonomo> salvos = vendedorAutonomoRepository.saveAll(vendedores);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvos);
    }
}