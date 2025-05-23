package org.serratec.trabalho1.service;

import org.serratec.trabalho1.dto.LancamentoVendasRequestDTO;
import org.serratec.trabalho1.dto.LancamentoVendasResponseDTO;
import org.serratec.trabalho1.entity.LancamentoVendas;
import org.serratec.trabalho1.entity.Vendedor;
import org.serratec.trabalho1.exception.ResourceNotFoundException;
import org.serratec.trabalho1.repository.LancamentoRepository;
import org.serratec.trabalho1.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    
    @Autowired
    private VendedorRepository vendedorRepository;

    public LancamentoVendasResponseDTO listarPorId(Long id) {
        LancamentoVendas lancamento = lancamentoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Lançamento não encontrado"));
        
        String nomeVendedor = lancamento.getVendedor() != null 
            ? lancamento.getVendedor().getNome() 
            : "Vendedor não informado";

        return new LancamentoVendasResponseDTO(
            lancamento.getDataVenda(),
            lancamento.getValorVenda(),
            nomeVendedor
        );
    }

    public LancamentoVendasResponseDTO inserirLancamento(LancamentoVendasRequestDTO dto) {
        Vendedor vendedor = vendedorRepository.findById(dto.getVendedor().getCodigoVendedor())
            .orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado"));

        LancamentoVendas lancamento = new LancamentoVendas();
        lancamento.setDataVenda(dto.getDataVenda());
        lancamento.setValorVenda(dto.getValorVenda());
        lancamento.setVendedor(vendedor);

        LancamentoVendas lancamentoSalvo = lancamentoRepository.save(lancamento);

        return new LancamentoVendasResponseDTO(
            lancamentoSalvo.getDataVenda(),
            lancamentoSalvo.getValorVenda(),
            vendedor.getNome()
        );
    }
}