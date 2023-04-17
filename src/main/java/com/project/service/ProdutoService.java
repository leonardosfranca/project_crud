package com.project.service;

import com.project.entity.Produto;
import com.project.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public Produto salvarProduto(Produto produto){
        return repository.save(produto);
    }

    public Produto buscarProdutoId(Long id)  {
        return repository.getReferenceById(id);
    }

    public void excluirProdutoPorId(Long id){
        repository.deleteById(id);
    }
    public List<Produto> listarProdutos(){
        return repository.findAll();
    }

    public Produto atualizar(Produto produto) {
       return repository.save(produto);

    }

}
