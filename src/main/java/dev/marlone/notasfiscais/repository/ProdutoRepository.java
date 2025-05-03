package dev.marlone.notasfiscais.repository;

import dev.marlone.notasfiscais.model.ProdutoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProdutoRepository extends MongoRepository<ProdutoModel, String> {
}
