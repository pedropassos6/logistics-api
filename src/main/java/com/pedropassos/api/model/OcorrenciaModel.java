package com.pedropassos.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaModel {
	
	private Long id;
	private String descicao;
	private OffsetDateTime dataRegistro;

}
