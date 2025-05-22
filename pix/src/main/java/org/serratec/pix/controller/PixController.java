package org.serratec.pix.controller;

import java.util.List;
import java.util.Map;

import org.serratec.pix.entity.Pix;
import org.serratec.pix.entity.Transacao;
import org.serratec.pix.service.PixService;
import org.serratec.pix.service.TransacaoService;
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
public class PixController {

    @Autowired
    private PixService contaService;

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/contas")
    public ResponseEntity<Pix> criarConta(@RequestBody Pix pix) {
        return ResponseEntity.ok(contaService.criarPix(pix));
    }

    @GetMapping("/contas/{numero}")
    public ResponseEntity<Pix> buscarConta(@PathVariable String numero) {
        return ResponseEntity.ok(contaService.buscarporNumero(numero));
    }

    @PostMapping("/pix")
    public ResponseEntity<String> realizarPix(@RequestBody Map<String, Object> body) {
        String origem = body.get("contaOrigem").toString();
        String destino = body.get("contaDestino").toString();
        double valor = Double.parseDouble(body.get("valor").toString());

        String resposta = transacaoService.realizarPIX(origem, destino, valor);

        if (resposta.contains("sucesso"))
            return ResponseEntity.ok(resposta);
        return ResponseEntity.badRequest().body(resposta);
    }

    @GetMapping("/transacoes")
    public ResponseEntity<List<Transacao>> listar() {
        return ResponseEntity.ok(transacaoService.listarTransacoes());
    }
}