package org.serratec.aula4.controller;

import org.serratec.aula4.model.Cliente;
import org.serratec.aula4.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    public ClienteRepository repository;

    @PostMapping("/cadastrarCliente")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente).getId().toString();
    }

}
