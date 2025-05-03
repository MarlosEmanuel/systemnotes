package dev.marlone.notasfiscais.request;

public record ProdutoRequest(String nome, double preco, String descricao, int estoque) {
}
