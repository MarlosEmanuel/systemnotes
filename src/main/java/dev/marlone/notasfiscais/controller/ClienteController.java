package dev.marlone.notasfiscais.controller;

import dev.marlone.notasfiscais.Service.ClienteService;
import dev.marlone.notasfiscais.request.ClienteRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@Tag(name = "Cliente", description = "Gerenciamento de Clientes")
public class ClienteController {

    private ClienteService clienteService;

    //Listar
    @GetMapping
    @Operation(summary = "Listar Clientes", description = "Retorna todos os clientes cadastrados")
    public ResponseEntity<?> listar() {
        return clienteService.read();
    }

    //Criar
    @PostMapping
    @Operation(summary = "Cadastrar Clientes", description = "Cria os clientes")
    public ResponseEntity<?> salvar(@RequestBody ClienteRequest clienteRequest) {
        return clienteService.create(clienteRequest);
    }

    //Deletar
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Cliente", description = "Deleta um cliente com base no ID")
    public ResponseEntity<?> deletar(@PathVariable String id){
        return clienteService.deleteById(id);
    }
}
