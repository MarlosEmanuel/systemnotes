package dev.marlone.notasfiscais.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "notas_fiscais")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotaFiscalModel {

    @Id
    private String id;
    @DBRef
    private ClienteModel cliente;
    private List<ItemNotaFiscalModel> produtos;
    private double valorTotal;
    private LocalDateTime dataEmissao;
}
