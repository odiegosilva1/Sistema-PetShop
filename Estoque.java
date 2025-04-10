import java.util.ArrayList;

class Estoque {
    ArrayList<Produto> produtos;

    Estoque() {
        produtos = new ArrayList<>();
    }

    void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    void removerProduto(String nomeProduto) {
        produtos.removeIf(p -> p.nome.equals(nomeProduto));
    }
}