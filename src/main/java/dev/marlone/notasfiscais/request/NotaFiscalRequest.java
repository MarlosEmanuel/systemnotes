package dev.marlone.notasfiscais.request;

import java.util.List;

public record NotaFiscalRequest(String clienteId, List<ItemNotaFiscalRequest> items) {
}
