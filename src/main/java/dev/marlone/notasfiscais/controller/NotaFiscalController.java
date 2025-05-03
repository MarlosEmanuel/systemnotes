package dev.marlone.notasfiscais.controller;

import dev.marlone.notasfiscais.Service.NotaFiscalService;
import dev.marlone.notasfiscais.request.NotaFiscalRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/notafiscal")
@AllArgsConstructor
public class NotaFiscalController {

    private NotaFiscalService notaFiscalService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return notaFiscalService.listar();
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody NotaFiscalRequest request){
        return notaFiscalService.criar(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id){
        return notaFiscalService.excluirNota(id);
    }
}
