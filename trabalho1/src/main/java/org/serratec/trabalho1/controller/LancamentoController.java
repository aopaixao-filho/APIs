package org.serratec.trabalho1.controller;
import org.serratec.trabalho1.dto.LancamentoVendasRequestDTO;
import org.serratec.trabalho1.dto.LancamentoVendasResponseDTO;
import org.serratec.trabalho1.exception.ResourceNotFoundException;
import org.serratec.trabalho1.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            LancamentoVendasResponseDTO response = service.listarPorId(id);
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<LancamentoVendasResponseDTO> inserir(
    @RequestBody @Valid LancamentoVendasRequestDTO lancamentoDTO) {
    
    LancamentoVendasResponseDTO response = service.inserirLancamento(lancamentoDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}