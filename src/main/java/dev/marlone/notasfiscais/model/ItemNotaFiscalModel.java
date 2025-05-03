package dev.marlone.notasfiscais.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemNotaFiscalModel {


    private ProdutoModel produto;
    private int quantidade;
    private double precoUnitario;

}
