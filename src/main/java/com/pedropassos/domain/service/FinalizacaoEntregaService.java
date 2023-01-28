package com.pedropassos.domain.service;

import org.springframework.stereotype.Service;

import com.pedropassos.domain.model.Entrega;
import com.pedropassos.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;
	
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}

}
