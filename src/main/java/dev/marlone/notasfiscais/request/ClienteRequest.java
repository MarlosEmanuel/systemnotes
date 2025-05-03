package dev.marlone.notasfiscais.request;

import lombok.Builder;

public record ClienteRequest(String nome, String cpfOuCnpj, String endereco, String email) {
}
