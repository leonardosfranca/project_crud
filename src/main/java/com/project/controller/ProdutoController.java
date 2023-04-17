package com.project.controller;

import com.project.entity.Produto;
import com.project.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/p1")
public class ProdutoController {
    @Autowired
    ProdutoService produtoServiceservice;

    @PostMapping("/salvar")
    public Produto salvarProduto(@RequestBody Produto produto){

        return produtoServiceservice.salvarProduto(produto);
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoId(@PathVariable("id") Long id) {
        return produtoServiceservice.buscarProdutoId(id);
    }
    @DeleteMapping("/deletar/{id}")
    public void exlcuirProduto(@PathVariable("id") Long id){
        produtoServiceservice.excluirProdutoPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado){
        return produtoServiceservice.atualizar(produtoAtualizado);
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return (produtoServiceservice.listarProdutos());
    }

}
