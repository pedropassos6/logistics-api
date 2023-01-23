package com.pedropassos.domain.service;

import org.springframework.stereotype.Service;

import com.pedropassos.domain.exception.EntidadeNaoEncontradaException;
import com.pedropassos.domain.exception.NegocioException;
import com.pedropassos.domain.model.Entrega;
import com.pedropassos.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não Encontrada"));
	}

}
