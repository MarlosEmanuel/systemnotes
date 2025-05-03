package dev.marlone.notasfiscais.mapper;

import dev.marlone.notasfiscais.model.ClienteModel;
import dev.marlone.notasfiscais.request.ClienteRequest;
import dev.marlone.notasfiscais.response.ClienteReponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClienteMapper {

    public ClienteModel toModel(ClienteRequest request){
        return ClienteModel.builder()
                .nome(request.nome())
                .cpfOuCnpj(request.cpfOuCnpj())
                .endereco(request.endereco())
                .email(request.email())
                .build();
    }

    public ClienteReponse toResponse(ClienteModel clienteModel){
        return ClienteReponse.builder()
                .clienteId(clienteModel.getId())
                .nome(clienteModel.getNome())
                .cpfOuCnpj(clienteModel.getCpfOuCnpj())
                .endereco(clienteModel.getEndereco())
                .email(clienteModel.getEmail())
                .build();
    }
}
