
package exe09;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Prato
class Prato {
    private String nome;
    private double preco;

    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

// Classe Mesa
class Mesa {
    private int numero;
    private boolean reservada;

    public Mesa(int numero) {
        this.numero = numero;
        this.reservada = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void reservar() {
        this.reservada = true;
    }

    public void liberar() {
        this.reservada = false;
    }
}

// Classe Pedido
class Pedido {
    private Mesa mesa;
    private List<Prato> pratos;
    private Date data;

    public Pedido(Mesa mesa, Date data) {
        this.mesa = mesa;
        this.data = data;
        this.pratos = new ArrayList<>();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Date getData() {
        return data;
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public double calcularTotal() {
        double total = 0;
        for (Prato prato : pratos) {
            total += prato.getPreco();
        }
        return total;
    }

    public void exibirPedido() {
        System.out.println("Pedido na Mesa " + mesa.getNumero() + " em " + data);
        for (Prato prato : pratos) {
            System.out.println("- " + prato.getNome() + ": R$ " + prato.getPreco());
        }
        System.out.println("Total: R$ " + calcularTotal());
    }
}

// Classe principal para testar o sistema de gerenciamento de restaurante
public class Exe09 {

    public static void main(String[] args) {
        // Criando pratos
        Prato prato1 = new Prato("Pizza Margherita", 30.0);
        Prato prato2 = new Prato("Spaghetti Carbonara", 25.0);
        Prato prato3 = new Prato("Tiramisu", 15.0);

        // Criando mesas
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);

        // Reservando mesas
        mesa1.reservar();
        mesa2.reservar();

        // Criando pedidos
        Pedido pedido1 = new Pedido(mesa1, new Date());
        pedido1.adicionarPrato(prato1);
        pedido1.adicionarPrato(prato3);

        Pedido pedido2 = new Pedido(mesa2, new Date());
        pedido2.adicionarPrato(prato2);

        // Exibindo pedidos
        pedido1.exibirPedido();
        pedido2.exibirPedido();

        // Exibindo reservas futuras
        exibirReservasFuturas(mesa1, mesa2);
    }

    public static void exibirReservasFuturas(Mesa... mesas) {
        System.out.println("Reservas futuras:");
        for (Mesa mesa : mesas) {
            if (mesa.isReservada()) {
                System.out.println("Mesa " + mesa.getNumero() + " está reservada.");
            }
        }
    }
}

