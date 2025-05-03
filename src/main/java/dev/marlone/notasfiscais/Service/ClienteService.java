package dev.marlone.notasfiscais.Service;

import dev.marlone.notasfiscais.mapper.ClienteMapper;
import dev.marlone.notasfiscais.model.ClienteModel;
import dev.marlone.notasfiscais.repository.ClienteRepository;
import dev.marlone.notasfiscais.request.ClienteRequest;
import dev.marlone.notasfiscais.response.ClienteReponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    //criar um usuario
    public ResponseEntity<?> create(ClienteRequest request){
        if (request == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar cliente !!");
        }
        ClienteModel clienteModel = ClienteMapper.toModel(request);
        clienteRepository.save(clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteModel);
    }

    //Listar os usuarios
    public ResponseEntity<List<ClienteReponse>> read(){
        List<ClienteModel> clienteModels = clienteRepository.findAll();
        if (clienteModels.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteModels.stream()
                .map(ClienteMapper::toResponse)
                .collect(Collectors.toList()));
    }

    public boolean verificarSeClienteExiste(String id){
        return clienteRepository.existsById(id);
    }

}
