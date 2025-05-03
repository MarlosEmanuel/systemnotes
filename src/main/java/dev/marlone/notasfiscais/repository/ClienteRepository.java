package dev.marlone.notasfiscais.repository;


import dev.marlone.notasfiscais.model.ClienteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<ClienteModel, String> {
}
