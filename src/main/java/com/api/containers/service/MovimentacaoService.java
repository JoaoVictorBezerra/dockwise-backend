package com.api.containers.service;

import com.api.containers.model.MovimentacaoModel;
import com.api.containers.repositories.MovimentacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimentacaoService {

    final MovimentacaoRepository movimentacaoRepository;
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }
    @Transactional
    public MovimentacaoModel salvarMovimentacao(MovimentacaoModel movimentacaoModel) {
        return movimentacaoRepository.save(movimentacaoModel);
    }

    public List<MovimentacaoModel> findAll() {
        return movimentacaoRepository.findAll();
    }
}
