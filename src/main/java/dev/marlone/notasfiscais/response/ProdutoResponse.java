package dev.marlone.notasfiscais.response;
import lombok.Builder;

@Builder
public record ProdutoResponse(String id, String nome, double precoUnitario, String descricao, int estoque) {
}
