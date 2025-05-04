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
import java.util.Optional;
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

    //Delete Usuarios
    public ResponseEntity<?> deleteById(String id){
        if (clienteRepository.findById(id).isPresent()){
            clienteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //PUT
    public ResponseEntity<?> update(String id, ClienteRequest request){
        if (verificarSeClienteExiste(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (request == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar cliente !!");
        }
        Optional<ClienteModel> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ClienteModel clienteModel = cliente.get();

        if (request.nome() != null && !request.nome().isEmpty()){
            clienteModel.setNome(request.nome());
        }
        if (request.email() != null && !request.email().isEmpty()){
            clienteModel.setEmail(request.email());
        }
        if (request.endereco() != null && !request.endereco().isEmpty()){
            clienteModel.setEndereco(request.endereco());
        }
        if (request.cpfOuCnpj() != null && !request.cpfOuCnpj().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteModel));
    }

    public boolean verificarSeClienteExiste(String id){
        return clienteRepository.findById(id).isEmpty();
    }

}
