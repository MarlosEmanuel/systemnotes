package dev.marlone.notasfiscais.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    private String id;
    private String nome;
    private double preco;
    private String descricao;
    private int estoque;
}
