
package exe04;


import java.util.ArrayList;
import java.util.List;

// Classe Passageiro
class Passageiro {
    private String nome;
    private List<Reserva> reservas;

    public Passageiro(String nome) {
        this.nome = nome;
        this.reservas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void listarReservas() {
        System.out.println("Reservas de " + nome + ":");
        for (Reserva reserva : reservas) {
            System.out.println("- Voo " + reserva.getVoo().getNumeroVoo() + " para " + reserva.getVoo().getDestino());
        }
    }
}

// Classe Voo
class Voo {
    private String numeroVoo;
    private String destino;
    private int capacidade;
    private int lugaresOcupados;

    public Voo(String numeroVoo, String destino, int capacidade) {
        this.numeroVoo = numeroVoo;
        this.destino = destino;
        this.capacidade = capacidade;
        this.lugaresOcupados = 0;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getDestino() {
        return destino;
    }

    public boolean temDisponibilidade() {
        return lugaresOcupados < capacidade;
    }

    public void reservarAssento() {
        if (temDisponibilidade()) {
            lugaresOcupados++;
        } else {
            System.out.println("Não há assentos disponíveis no voo " + numeroVoo);
        }
    }
}

// Classe Reserva
class Reserva {
    private Passageiro passageiro;
    private Voo voo;

    public Reserva(Passageiro passageiro, Voo voo) {
        this.passageiro = passageiro;
        this.voo = voo;
    }

    public Voo getVoo() {
        return voo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }
}

// Classe principal para testar o sistema de reservas
public class Exe04 {

    public static void main(String[] args) {
        // Criando voos
        Voo voo1 = new Voo("AA123", "São Paulo", 2);
        Voo voo2 = new Voo("BB456", "Rio de Janeiro", 1);

        // Criando passageiros
        Passageiro passageiro1 = new Passageiro("Alice");
        Passageiro passageiro2 = new Passageiro("Bob");

        // Fazendo reservas
        if (voo1.temDisponibilidade()) {
            voo1.reservarAssento();
            Reserva reserva1 = new Reserva(passageiro1, voo1);
            passageiro1.adicionarReserva(reserva1);
        }

        if (voo1.temDisponibilidade()) {
            voo1.reservarAssento();
            Reserva reserva2 = new Reserva(passageiro2, voo1);
            passageiro2.adicionarReserva(reserva2);
        }

        // Tentativa de reservar mais um assento em voo1, mesmo após a capacidade ser atingida
        if (voo1.temDisponibilidade()) {
            voo1.reservarAssento();
            Reserva reserva3 = new Reserva(passageiro1, voo1);
            passageiro1.adicionarReserva(reserva3);
        }

        // Fazendo reserva no segundo voo
        if (voo2.temDisponibilidade()) {
            voo2.reservarAssento();
            Reserva reserva4 = new Reserva(passageiro1, voo2);
            passageiro1.adicionarReserva(reserva4);
        }

        // Listando reservas dos passageiros
        passageiro1.listarReservas();
        passageiro2.listarReservas();
    }
}
