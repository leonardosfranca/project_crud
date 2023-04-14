package com.project.service;

import com.project.entity.Produto;
import com.project.exception.AtributoInvalidoException;
import com.project.exception.ProdutoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository repository;

    public Produto criarProduto(Produto produto){
        return repository.save(produto);
    }

    public Produto buscarProdutoId(Long id)  {
        Optional<Produto> produtoOptional = repository.findById(id);
        if (produtoOptional.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado com o ID: " + id);
        }
        return produtoOptional.get();
    }

    public void excluirProdutoPorId(Long id){
        boolean produtoExiste = repository.existsById(id);
        if (!produtoExiste){
            throw new ProdutoNaoEncontradoException("Produto não existe" );
        }
        repository.deleteById(id);
    }
    public List<Produto> listarProdutos(){
        return repository.findAll();
    }

    public Produto atualizar(Produto produto) {
        if (produto.getId() == null){
            throw new AtributoInvalidoException("id obrigatório");
        }
       Produto produtoSalvo =  repository.getReferenceById(produto.getId());
        if (produto.getNome() != null){
           produtoSalvo.setNome(produto.getNome());
       }
       if (produto.getPreco() != null){
           produtoSalvo.setPreco(produto.getPreco());
       }
       if (produto.getQuantidadeEstoque() != null){
           produtoSalvo.setQuantidadeEstoque(produto.getQuantidadeEstoque());
       }
       return repository.save(produtoSalvo);

    }
}
