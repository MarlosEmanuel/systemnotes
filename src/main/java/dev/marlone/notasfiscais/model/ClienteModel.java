package dev.marlone.notasfiscais.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ClienteModel {

    @Id
    private String id;
    private String nome;
    private String cpfOuCnpj;
    private String endereco;
    private String email;
}
