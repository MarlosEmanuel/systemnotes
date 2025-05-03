package dev.marlone.notasfiscais.response;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record NotaFiscalResponse(String id, String clienteId, String clienteNome, List<ItemNotaFiscalResponse> itemNotaFiscalResponse, LocalDateTime dataEmissao, double valorTotal) {
}
