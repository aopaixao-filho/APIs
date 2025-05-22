package org.serratec.aula6.controller;
import org.serratec.aula6.entity.Usuario;
import org.serratec.aula6.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public Iterable<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    
}
