package org.serratec.aula3.controller;

import java.time.LocalDate;
import java.util.List;

import org.serratec.aula3.model.Produto;
import org.serratec.aula3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public Produto inserir(@RequestBody Produto produto) {
        if (produto.getDataCadastro() == null) {
            
            produto.setDataCadastro(LocalDate.now());
        }
        repository.save(produto);
        return produto;
    }

    @PostMapping("/multi")
    public List<Produto> inserirMultiplos(@RequestBody List<Produto> produtos) {
        produtos.forEach(produto -> {
            if (produto.getDataCadastro() == null) {
                produto.setDataCadastro(LocalDate.now());
            }
        });
        return repository.saveAll(produtos);
    }

    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarporId (@PathVariable Long id) {
            return repository.findById(id).orElse(null); //Lambda. tipagem própria do SpringBoot; se não encontrar retorna null;
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        if(repository.findById(id).isPresent()) {
            produto.setId(id);
            return repository.save(produto);
        } else {         
            throw new RuntimeException("Produto não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}