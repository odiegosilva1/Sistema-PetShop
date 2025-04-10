import java.util.ArrayList;

class Cliente {
    String nome;
    String endereco;
    ArrayList<Pet> listaPets;

    Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaPets = new ArrayList<>();
    }

    void adicionarPet(Pet pet) {
        listaPets.add(pet);
    }
}