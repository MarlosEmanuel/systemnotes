package dev.marlone.notasfiscais.Service;

import dev.marlone.notasfiscais.mapper.NotaFiscalMapper;
import dev.marlone.notasfiscais.model.NotaFiscalModel;
import dev.marlone.notasfiscais.repository.NotaFiscalRepository;
import dev.marlone.notasfiscais.request.ItemNotaFiscalRequest;
import dev.marlone.notasfiscais.request.NotaFiscalRequest;
import dev.marlone.notasfiscais.response.NotaFiscalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotaFiscalService {

    private NotaFiscalRepository notaFiscalRepository;
    private NotaFiscalMapper notaFiscalMapper;
    private ClienteService clienteService;
    private ProdutoService produtoService;

    //criar
    public ResponseEntity<?> criar(NotaFiscalRequest request){
        if (request == null || request.items() == null || request.items().isEmpty()) {
            return ResponseEntity.badRequest().body("Requisição inválida.");
        }
        if (!verificaTodosOsItens(request.items())) {
            return ResponseEntity.badRequest().body("Produto inválido na nota.");
        }
        if (clienteService.verificarSeClienteExiste(request.clienteId())) {
            return ResponseEntity.badRequest().body("Cliente não encontrado.");
        }
        for (ItemNotaFiscalRequest item : request.items()) {
            produtoService.retirarEstoque(item.produtoId(), item.quantidade());
        }
        notaFiscalRepository.save(notaFiscalMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    //listar
    public ResponseEntity<List<NotaFiscalResponse>> listar(){
        List<NotaFiscalModel> models = notaFiscalRepository.findAll();
        if (models.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(models.stream()
                .map(notaFiscalMapper::toResponse)
                .collect(Collectors.toList()));
    }

    //Deletar
    public ResponseEntity<?> excluirNota(String id){
        if (notaFiscalRepository.existsById(id)){
            notaFiscalRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private boolean verificaTodosOsItens(List<ItemNotaFiscalRequest> items) {
        for (ItemNotaFiscalRequest item : items) {
            if (!produtoService.verificaSeProdutoExiste(item.produtoId())) {
                return false; // Se qualquer produto não existir, retorna falso
            }
        }
        return true; // Todos os produtos existem
    }


}
