package com.pedropassos.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pedropassos.api.model.Ocorrencia;
import com.pedropassos.domain.exception.NegocioException;
import com.pedropassos.domain.model.Entrega;
import com.pedropassos.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaID, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaID);
		
		return entrega.adicionarOcorrencia(descricao);
	}
	
	
	

}
