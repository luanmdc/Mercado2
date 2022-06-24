package service;

import dto.ProdutoDTO;
import model.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {

    @Override
    public ProdutoDTO criaProduto(ProdutoDTO request) throws IOException {

        Produto produto = instanciaProduto(request);

        ProdutoDTO response = instanciaResponse(produto);


        bufferedWriter();


        return response;
    }


    @Override
    public List<ProdutoDTO> bulkCreate(List<ProdutoDTO> requests) throws IOException {

//1
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<ProdutoDTO> responses = new ArrayList<>();

//2
        for (ProdutoDTO request : requests) {
            Produto produto = instanciaProduto(request);
//3
            produtos.add(produto);

        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Luan Carvalho\\Documents\\GitHub\\tempfile2.txt"));

//4
        for (Produto produto : produtos) {

            ProdutoDTO response = instanciaResponse(produto);
            responses.add(response);

            writer.write(produto.toString());
            writer.newLine();
        }
        writer.close();

        exibeConfirmacao();

        return produtoDTOS;
    }

    private void exibeConfirmacao() {
        System.out.println("o produto foi criado com sucesso");
    }

    private Produto instanciaProduto(ProdutoDTO request) {

        Produto produto = new Produto();
        produto.setMarca(request.getMarca());
        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());
        return produto;

    }


    private ProdutoDTO instanciaResponse(Produto produto) {

        ProdutoDTO response = new ProdutoDTO();
        response.setMarca(produto.getMarca());
        response.setNome(produto.getNome());
        response.setDescricao(produto.getDescricao());
        response.setPreco(produto.getPreco());

        return response;
    }

    private void bufferedWriter() throws IOException {
        bufferedWriter();
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Luan Carvalho\\Documents\\GitHub\\tempfile.txt"));
        writer.write(toString());
        writer.newLine();
        writer.close();

    }

}


