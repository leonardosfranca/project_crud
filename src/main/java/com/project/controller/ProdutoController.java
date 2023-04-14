package com.project.controller;

import com.project.entity.Produto;
import com.project.exception.ProdutoNaoEncontradoException;
import com.project.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class ProdutoController {
    @Autowired
    ProdutoService service;

    @PostMapping("/salvar")
    public ResponseEntity<Produto>criarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok(service.criarProduto(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoId(@PathVariable("id") Long id) {
        try {
            Produto produto = service.buscarProdutoId(id);
            return ResponseEntity.ok(produto);
        } catch (ProdutoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> exlcuirProduto(@PathVariable("id") Long id){

        try {
            service.excluirProdutoPorId(id);
            return ResponseEntity.noContent().build();
        } catch (ProdutoNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Produto>atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        return ResponseEntity.ok(service.atualizar(produtoAtualizado));
    }

    @GetMapping("/produtos")
    public ResponseEntity<?> listarProdutos() {
        List<Produto> produtos = service.listarProdutos();
        return ResponseEntity.ok(produtos);
    }


}
