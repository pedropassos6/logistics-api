package com.pedropassos.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pedropassos.domain.exception.NegocioException;
import com.pedropassos.domain.model.Cliente;
import com.pedropassos.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente Não encontrado"));
	}
	
	
	
	@Transactional
	public Cliente salvar (Cliente cliente) {
		
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe esse email cadastrado");
		}
		
		return clienteRepository.save(cliente);
		
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	

}
