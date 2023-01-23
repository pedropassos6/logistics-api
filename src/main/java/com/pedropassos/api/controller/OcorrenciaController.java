package com.pedropassos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedropassos.api.assembler.OcorrenciaAssembler;
import com.pedropassos.api.model.Ocorrencia;
import com.pedropassos.api.model.OcorrenciaModel;
import com.pedropassos.api.model.input.OcorrenciaInput;
import com.pedropassos.domain.model.Entrega;
import com.pedropassos.domain.service.BuscaEntregaService;
import com.pedropassos.domain.service.RegistroOcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entrega/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private BuscaEntregaService buscaEntregaService;
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrenciaInput.getDescicao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
	
	

}
