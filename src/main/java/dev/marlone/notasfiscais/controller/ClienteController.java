package dev.marlone.notasfiscais.controller;

import dev.marlone.notasfiscais.Service.ClienteService;
import dev.marlone.notasfiscais.request.ClienteRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return clienteService.read();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody ClienteRequest clienteRequest) {
        return clienteService.create(clienteRequest);
    }
}
