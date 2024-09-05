
package exe06;


import java.util.ArrayList;
import java.util.List;

// Classe Marca
class Marca {
    private String nome;
    private List<Carro> carros;

    public Marca(String nome) {
        this.nome = nome;
        this.carros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public double calcularMediaPrecos() {
        double soma = 0;
        for (Carro carro : carros) {
            soma += carro.getPreco();
        }
        return carros.size() > 0 ? soma / carros.size() : 0;
    }

    public List<Carro> getCarros() {
        return carros;
    }
}

// Classe Carro
class Carro {
    private String modelo;
    private double preco;
    private Marca marca;

    public Carro(String modelo, double preco, Marca marca) {
        this.modelo = modelo;
        this.preco = preco;
        this.marca = marca;
        marca.adicionarCarro(this);
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public Marca getMarca() {
        return marca;
    }
}

// Classe Vendedor
class Vendedor {
    private String nome;
    private List<Carro> carrosVendidos;

    public Vendedor(String nome) {
        this.nome = nome;
        this.carrosVendidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void venderCarro(Carro carro) {
        carrosVendidos.add(carro);
    }

    public void exibirCarrosVendidos() {
        System.out.println("Carros vendidos por " + nome + ":");
        for (Carro carro : carrosVendidos) {
            System.out.println("- " + carro.getModelo() + " (" + carro.getMarca().getNome() + ")");
        }
    }
}

// Classe principal para testar o sistema de gerenciamento de carros
public class Exe06 {

    public static void main(String[] args) {
        // Criando marcas
        Marca toyota = new Marca("Toyota");
        Marca honda = new Marca("Honda");

        // Criando carros
        Carro carro1 = new Carro("Corolla", 90000.0, toyota);
        Carro carro2 = new Carro("Civic", 85000.0, honda);
        Carro carro3 = new Carro("Hilux", 150000.0, toyota);

        // Criando vendedores
        Vendedor vendedor1 = new Vendedor("Carlos");
        Vendedor vendedor2 = new Vendedor("Ana");

        // Vendendo carros
        vendedor1.venderCarro(carro1);
        vendedor2.venderCarro(carro2);
        vendedor1.venderCarro(carro3);

        // Calculando a média de preços por marca
        System.out.println("Média de preços dos carros da Toyota: " + toyota.calcularMediaPrecos());
        System.out.println("Média de preços dos carros da Honda: " + honda.calcularMediaPrecos());

        // Exibindo carros vendidos por cada vendedor
        vendedor1.exibirCarrosVendidos();
        vendedor2.exibirCarrosVendidos();
    }
}
