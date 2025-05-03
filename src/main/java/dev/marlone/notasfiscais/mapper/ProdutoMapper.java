package dev.marlone.notasfiscais.mapper;

import dev.marlone.notasfiscais.model.ProdutoModel;
import dev.marlone.notasfiscais.request.ProdutoRequest;
import dev.marlone.notasfiscais.response.ProdutoResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoMapper {

    public ProdutoModel toModel(ProdutoRequest request) {
        return ProdutoModel.builder()
                .nome(request.nome())
                .preco(request.preco())
                .estoque(request.estoque())
                .descricao(request.descricao())
                .build();
    }

    public ProdutoResponse toResponse(ProdutoModel model) {
        return ProdutoResponse.builder()
                .id(model.getId())
                .nome(model.getNome())
                .precoUnitario(model.getPreco())
                .descricao(model.getDescricao())
                .estoque(model.getEstoque())
                .build();
    }
}
