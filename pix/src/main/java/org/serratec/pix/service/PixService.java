package org.serratec.pix.service;

import org.serratec.pix.entity.Pix;
import org.serratec.pix.repository.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PixService {

    @Autowired
    private PixRepository pixRepository;

    public Pix criarPix (Pix pix){return pixRepository.save(pix);}

    public Pix buscarporNumero(String numeroConta) {
        return pixRepository.findByNumeroConta(numeroConta)
                .orElseThrow(() -> new RuntimeException("Pix não encontrado"));
    }
    
    public void atualizarConta(Pix Pix) {
        pixRepository.save(Pix);
    }



}