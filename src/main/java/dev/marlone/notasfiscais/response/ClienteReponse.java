package dev.marlone.notasfiscais.response;

import lombok.Builder;

@Builder
public record ClienteReponse(String clienteId, String nome, String cpfOuCnpj, String endereco, String email) {
}
