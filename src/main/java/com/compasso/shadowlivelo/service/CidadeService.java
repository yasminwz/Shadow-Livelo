package com.compasso.shadowlivelo.service;

import com.compasso.shadowlivelo.domain.dto.CidadeDtoRequest;
import com.compasso.shadowlivelo.domain.dto.CidadeDtoResponse;
import com.compasso.shadowlivelo.domain.model.Cidade;
import com.compasso.shadowlivelo.repository.CidadeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CidadeDtoResponse create(CidadeDtoRequest cidadeDtoRequest) {
        Cidade cidade = modelMapper.map(cidadeDtoRequest, Cidade.class);
        this.cidadeRepository.save(cidade);
        return modelMapper.map(cidade, CidadeDtoResponse.class);

    }
        public CidadeDtoResponse findByNome (String nome){
            Cidade cidade = cidadeRepository.findByNome(nome);
            return modelMapper.map(cidade, CidadeDtoResponse.class);


    }
    public CidadeDtoResponse findByEstado (String estado){
        Cidade cidade = cidadeRepository.findByEstado(estado);
        return modelMapper.map(cidade, CidadeDtoResponse.class);

    }

}