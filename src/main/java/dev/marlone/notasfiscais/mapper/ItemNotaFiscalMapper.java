package dev.marlone.notasfiscais.mapper;

import dev.marlone.notasfiscais.model.ItemNotaFiscalModel;
import dev.marlone.notasfiscais.model.ProdutoModel;
import dev.marlone.notasfiscais.repository.ProdutoRepository;
import dev.marlone.notasfiscais.request.ItemNotaFiscalRequest;
import dev.marlone.notasfiscais.response.ItemNotaFiscalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ItemNotaFiscalMapper {

    private ProdutoRepository produtoRepository;

    public ItemNotaFiscalModel toModel(ItemNotaFiscalRequest request) {

        ProdutoModel produto = produtoRepository.findById(request.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + request.produtoId() ));

        return ItemNotaFiscalModel.builder()
                .produto(produto)
                .quantidade(request.quantidade())
                .precoUnitario(produto.getPreco())
                .build();
    }

    public ItemNotaFiscalResponse toResponse(ItemNotaFiscalModel model) {
        return ItemNotaFiscalResponse.builder()
                .id(model.getProduto().getId())
                .nome(model.getProduto().getNome())
                .quantidade(model.getQuantidade())
                .precoUnitario(model.getPrecoUnitario())
                .build();
    }
}
