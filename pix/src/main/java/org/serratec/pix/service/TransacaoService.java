package org.serratec.pix.service;

import java.time.LocalDateTime;
import java.util.List;

import org.serratec.pix.entity.Pix;
import org.serratec.pix.entity.Transacao;
import org.serratec.pix.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    @Autowired
    private PixService pixService;

    @Autowired
    private TransacaoRepository transacaoRepo;

    public String realizarPIX(String origem, String destino, double valor) {
        if (valor <= 0) return "Valor deve ser positivo.";

        Pix contaOrigem = pixService.buscarporNumero(origem);
        Pix contaDestino = pixService.buscarporNumero(destino);

        if (contaOrigem.getSaldo() < valor)
            return "Saldo insuficiente.";

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        pixService.atualizarConta(contaOrigem);
        pixService.atualizarConta(contaDestino);

        Transacao t = new Transacao();
        t.setContaOrigem(origem);
        t.setContaDestino(destino);
        t.setValor(valor);
        t.setDataHora(LocalDateTime.now());

        transacaoRepo.save(t);
        return "PIX realizado com sucesso.";
    }

    public List<Transacao> listarTransacoes() {
        return transacaoRepo.findAllByOrderByDataHoraDesc()
                .map(List::of)
                .orElseGet(List::of);
    }
}