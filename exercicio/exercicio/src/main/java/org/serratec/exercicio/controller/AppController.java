package org.serratec.exercicio.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.exercicio.entity.Cliente;
import org.serratec.exercicio.entity.Endereco;
import org.serratec.exercicio.entity.Pedido;
import org.serratec.exercicio.repository.ClienteRepository;
import org.serratec.exercicio.repository.EnderecoRepository;
import org.serratec.exercicio.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Inserir um endereço
    @PostMapping("/enderecos")
    public ResponseEntity<Endereco> inserirEndereco(@RequestBody Endereco endereco) {
        Endereco salvo = enderecoRepository.save(endereco);
        return ResponseEntity.ok(salvo);
    }

    // Inserir um cliente
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> inserirCliente(@RequestBody Cliente cliente) {
        // Se o cliente vier com um endereço com id, buscar e associar
        if (cliente.getEndereco() != null && cliente.getEndereco().getId() != null) {
            Optional<Endereco> enderecoOpt = enderecoRepository.findById(cliente.getEndereco().getId());
            if (enderecoOpt.isPresent()) {
                cliente.setEndereco(enderecoOpt.get());
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        Cliente salvo = clienteRepository.save(cliente);
        return ResponseEntity.ok(salvo);
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> inserirPedido(@RequestBody Pedido pedido) {
        if (pedido.getCliente() == null || !clienteRepository.existsById(pedido.getCliente().getIdCliente())) {
            return ResponseEntity.badRequest().build();
        }
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente()).get();
        pedido.setCliente(cliente);
        Pedido salvo = pedidoRepository.save(pedido);
        return ResponseEntity.ok(salvo);
    }
    @GetMapping("/clientes/{idCliente}/pedidos")
    public ResponseEntity<List<Pedido>> listarPedidosPorCliente(@PathVariable Long idCliente) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
        if (clienteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = clienteOpt.get();
        return ResponseEntity.ok(cliente.getPedido());
    }
}