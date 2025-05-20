package org.serratec.aula2.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.aula2.model.Aluno;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private List<Aluno> alunos = new ArrayList<>();

    public AlunoController() {
        alunos.add(new Aluno(1L, "Jorge", "jorge@gmail.com"));
        alunos.add(new Aluno(2L, "Maria", "maria@gmail.com"));
        alunos.add(new Aluno(3L, "João", "joao@gmail.com"));
    }

    @GetMapping
    public List<Aluno> ListarTodos() {
        return alunos;
    }

    @RequestMapping("/listar")
    public List<Aluno> listar() {
        return alunos;
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getMatricula().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
    }

    @PostMapping("/cadastrar")
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    @PostMapping("/cadastrar_varios")
    public List<Aluno> cadastrarVarios(@RequestBody List<Aluno> novosAlunos) {
        alunos.addAll(novosAlunos);
        return alunos;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunos.removeIf(aluno -> aluno.getMatricula().equals(id));
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
                alunos.stream()
                .filter(aluno1 -> aluno1.getMatricula().equals(id))
                .findFirst()
                .ifPresent(a -> {
                    a.setEmail(aluno.getEmail());
                    a.setNome(aluno.getNome());
                });
            return null;
    }
}