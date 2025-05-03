package dev.marlone.notasfiscais.response;

import lombok.Builder;

@Builder
public record ItemNotaFiscalResponse(String id,String nome, int quantidade, double precoUnitario) {
}
