package dev.marlone.notasfiscais.Service;

import dev.marlone.notasfiscais.mapper.ProdutoMapper;
import dev.marlone.notasfiscais.model.ProdutoModel;
import dev.marlone.notasfiscais.repository.ProdutoRepository;
import dev.marlone.notasfiscais.request.ProdutoRequest;
import dev.marlone.notasfiscais.response.ProdutoResponse;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    //Criar Produto
    public ResponseEntity<?> criar(ProdutoRequest request){
        if (request == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        produtoRepository.save(ProdutoMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Listar produtos
    public ResponseEntity<List<ProdutoResponse>> listar(){
        List<ProdutoModel> produtos = produtoRepository.findAll();
        if (produtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtos.stream()
                .map(ProdutoMapper::toResponse)
                .collect(Collectors.toList()));
    }

    //Deletar
    public ResponseEntity<?> deleteById(String id){
        if (produtoRepository.findById(id).isPresent()){
            produtoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    public boolean verificaSeProdutoExiste(String id){
        return produtoRepository.existsById(id);
    }

    public void retirarEstoque(String id, int quantidade){
        ProdutoModel produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));
        if (produto.getEstoque() < quantidade){
            throw new RuntimeException("Estoque insuficiente");
        }
        produto.setEstoque(produto.getEstoque() - quantidade);
        produtoRepository.save(produto);
    }
}
