
package exe08;

import java.util.ArrayList;
import java.util.List;

// Classe Tarefa
class Tarefa {
    private String descricao;
    private int horasEstimadas;

    public Tarefa(String descricao, int horasEstimadas) {
        this.descricao = descricao;
        this.horasEstimadas = horasEstimadas;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }
}

// Classe Desenvolvedor
class Desenvolvedor {
    private String nome;
    private List<Tarefa> tarefas;

    public Desenvolvedor(String nome) {
        this.nome = nome;
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void atribuirTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void listarTarefas() {
        System.out.println("Tarefas do desenvolvedor " + nome + ":");
        for (Tarefa tarefa : tarefas) {
            System.out.println("- " + tarefa.getDescricao() + " (" + tarefa.getHorasEstimadas() + " horas)");
        }
    }
}

// Classe Projeto
class Projeto {
    private String nome;
    private List<Tarefa> tarefas;

    public Projeto(String nome) {
        this.nome = nome;
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public int calcularCargaDeTrabalho() {
        int cargaTotal = 0;
        for (Tarefa tarefa : tarefas) {
            cargaTotal += tarefa.getHorasEstimadas();
        }
        return cargaTotal;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}

// Classe principal para testar o sistema de gerenciamento de projetos
public class Exe08 {

    public static void main(String[] args) {
        // Criando desenvolvedores
        Desenvolvedor dev1 = new Desenvolvedor("Alice");
        Desenvolvedor dev2 = new Desenvolvedor("Bob");

        // Criando tarefas
        Tarefa tarefa1 = new Tarefa("Desenvolver API", 10);
        Tarefa tarefa2 = new Tarefa("Implementar frontend", 8);
        Tarefa tarefa3 = new Tarefa("Testar aplicação", 5);

        // Criando projetos
        Projeto projeto1 = new Projeto("Sistema de Gerenciamento");

        // Atribuindo tarefas ao projeto
        projeto1.adicionarTarefa(tarefa1);
        projeto1.adicionarTarefa(tarefa2);
        projeto1.adicionarTarefa(tarefa3);

        // Atribuindo tarefas aos desenvolvedores
        dev1.atribuirTarefa(tarefa1);
        dev2.atribuirTarefa(tarefa2);
        dev1.atribuirTarefa(tarefa3);

        // Exibindo carga de trabalho do projeto
        System.out.println("Carga de trabalho total do projeto " + projeto1.getNome() + ": " + projeto1.calcularCargaDeTrabalho() + " horas");

        // Listando tarefas dos desenvolvedores
        dev1.listarTarefas();
        dev2.listarTarefas();
    }
}


