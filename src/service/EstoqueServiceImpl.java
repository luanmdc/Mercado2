package service;

import dto.EstoqueDTO;
import dto.ProdutoDTO;
import model.Estoque;
import model.Produto;

public class EstoqueServiceImpl implements EstoqueService {
    @Override
    public EstoqueDTO criaEstoque(EstoqueDTO request) {

            Estoque estoque = new Estoque();
            estoque.setQuantidade((request.getQuantidade()));
            estoque.setProduto(request.getProduto());

            EstoqueDTO response = new EstoqueDTO();
            response.setProduto(estoque.getProduto());
            response.setQuantidade(estoque.getQuantidade());


        return response;
    }

}
