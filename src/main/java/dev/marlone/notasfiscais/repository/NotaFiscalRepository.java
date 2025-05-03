package dev.marlone.notasfiscais.repository;

import dev.marlone.notasfiscais.model.NotaFiscalModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotaFiscalRepository extends MongoRepository<NotaFiscalModel, String> {
}
