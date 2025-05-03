package dev.marlone.notasfiscais.mapper;

import dev.marlone.notasfiscais.model.ClienteModel;
import dev.marlone.notasfiscais.model.ItemNotaFiscalModel;
import dev.marlone.notasfiscais.model.NotaFiscalModel;
import dev.marlone.notasfiscais.repository.ClienteRepository;
import dev.marlone.notasfiscais.request.NotaFiscalRequest;
import dev.marlone.notasfiscais.response.NotaFiscalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class NotaFiscalMapper {

    private ClienteRepository clienteRepository;
    private ItemNotaFiscalMapper itemNotaFiscalMapper;

    public NotaFiscalModel toModel(NotaFiscalRequest request) {
        ClienteModel cliente = clienteRepository.findById(request.clienteId()).orElseThrow(()
                -> new RuntimeException("Cliente não encontrado: "+request.clienteId()));

        List<ItemNotaFiscalModel> itens = request.items().stream()
                .map(item -> itemNotaFiscalMapper.toModel(item))
                .collect(Collectors.toList());

        double valorTotal = itens.stream()
                .mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
                .sum();

        return NotaFiscalModel.builder()
                .cliente(cliente)
                .produtos(itens)
                .valorTotal(valorTotal)
                .dataEmissao(LocalDateTime.now())
                .build();
    }

    public NotaFiscalResponse toResponse(NotaFiscalModel model) {
        return NotaFiscalResponse.builder()
                .id(model.getId())
                .clienteId(model.getCliente().getId())
                .clienteNome(model.getCliente().getNome())
                .itemNotaFiscalResponse(model.getProdutos().stream()
                        .map(itemNotaFiscalMapper::toResponse).collect(Collectors.toList()))
                .dataEmissao(model.getDataEmissao())
                .valorTotal(model.getValorTotal())
                .build();
    }
}
