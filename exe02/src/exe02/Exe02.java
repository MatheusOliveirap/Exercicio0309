

package exe02;
import java.util.ArrayList;
import java.util.List;

// Classe Funcionario
class Funcionario {
    private String nome;
    private double salario;
    private List<Projeto> projetos;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.projetos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    public void exibirProjetos() {
        System.out.println("Projetos do funcionário " + nome + ":");
        for (Projeto projeto : projetos) {
            System.out.println("- " + projeto.getNome());
        }
    }
}

// Classe Departamento
class Departamento {
    private String nome;
    private List<Funcionario> funcionarios;

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public double calcularMediaSalarial() {
        double somaSalarios = 0;
        for (Funcionario f : funcionarios) {
            somaSalarios += f.getSalario();
        }
        return funcionarios.size() > 0 ? somaSalarios / funcionarios.size() : 0;
    }
}

// Classe Projetoimport java.util.ArrayList;


class Projeto {
    private String nome;
    private List<Funcionario> funcionarios; // Corrigido para Funcionario, não Funcionarios

    public Projeto(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>(); // Inicializa a lista de funcionários
    }

    public String getNome() {
        return nome;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario); // Adiciona um funcionário ao projeto
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios; // Retorna a lista de funcionários atribuídos ao projeto
    }

    public void exibirFuncionarios() {
        System.out.println("Funcionários no projeto " + nome + ":");
        for (Funcionario f : funcionarios) {
            System.out.println("- " + f.getNome());
        }
    }
}


public class Exe02 {
    public static void main(String[] args) {
        // Criando departamentos
        Departamento deptTI = new Departamento("TI");
        Departamento deptRH = new Departamento("Recursos Humanos");

        // Criando funcionários
        Funcionario f1 = new Funcionario("Alice", 5000.0);
        Funcionario f2 = new Funcionario("Bob", 6000.0);
        Funcionario f3 = new Funcionario("Carlos", 4000.0);

        // Adicionando funcionários aos departamentos
        deptTI.adicionarFuncionario(f1);
        deptTI.adicionarFuncionario(f2);
        deptRH.adicionarFuncionario(f3);

        // Criando projetos
        Projeto p1 = new Projeto("Projeto X");
        Projeto p2 = new Projeto("Projeto Y");

        // Atribuindo projetos aos funcionários
        f1.adicionarProjeto(p1);
        f2.adicionarProjeto(p2);
        f3.adicionarProjeto(p1);
        f3.adicionarProjeto(p2);

        // Exibindo projetos de um funcionário
        f1.exibirProjetos();
        f3.exibirProjetos();

        // Calculando média salarial dos departamentos
        System.out.println("Média salarial do departamento TI: " + deptTI.calcularMediaSalarial());
        System.out.println("Média salarial do departamento RH: " + deptRH.calcularMediaSalarial());
    }
}
