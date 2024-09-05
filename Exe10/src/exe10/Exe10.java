
package exe10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe Disciplina
class Disciplina {
    private String nome;
    private Professor professor;
    private List<Estudante> estudantes;
    private Map<Estudante, Double> notas;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.estudantes = new ArrayList<>();
        this.notas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void matricularEstudante(Estudante estudante, double nota) {
        if (!estudantes.contains(estudante)) {
            estudantes.add(estudante);
            notas.put(estudante, nota);
            estudante.adicionarDisciplina(this);
        }
    }

    public double calcularMedia() {
        if (notas.isEmpty()) return 0;
        double soma = 0;
        for (double nota : notas.values()) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }
}

// Classe Estudante
class Estudante {
    private String nome;
    private List<Disciplina> disciplinas;

    public Estudante(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }

    public void matricularDisciplina(Disciplina disciplina, double nota) {
        disciplina.matricularEstudante(this, nota);
    }

    public double calcularMedia(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            System.out.println("O estudante não está matriculado nesta disciplina.");
            return 0;
        }
        return disciplina.calcularMedia();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}

// Classe Professor
class Professor {
    private String nome;
    private List<Disciplina> disciplinas;

    public Professor(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
        }
    }

    public void listarDisciplinas() {
        System.out.println("Disciplinas lecionadas por " + nome + ":");
        for (Disciplina disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNome());
        }
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}

// Classe principal para testar o sistema de gerenciamento de estudantes
public class Exe10 {

    public static void main(String[] args) {
        // Criando professores
        Professor prof1 = new Professor("Dr. Silva");
        Professor prof2 = new Professor("Sra. Oliveira");

        // Criando disciplinas
        Disciplina disciplina1 = new Disciplina("Matemática", prof1);
        Disciplina disciplina2 = new Disciplina("História", prof2);

        // Adicionando disciplinas aos professores
        prof1.adicionarDisciplina(disciplina1);
        prof2.adicionarDisciplina(disciplina2);

        // Criando estudantes
        Estudante aluno1 = new Estudante("Ana");
        Estudante aluno2 = new Estudante("Pedro");

        // Matriculando estudantes nas disciplinas
        aluno1.matricularDisciplina(disciplina1, 8.5);
        aluno1.matricularDisciplina(disciplina2, 7.0);
        aluno2.matricularDisciplina(disciplina1, 9.0);

        // Listando disciplinas de cada professor
        prof1.listarDisciplinas();
        prof2.listarDisciplinas();

        // Calculando médias
        System.out.println("Média de Matemática: " + disciplina1.calcularMedia());
        System.out.println("Média de História: " + disciplina2.calcularMedia());

        // Calculando a média do aluno na disciplina
        System.out.println("Média do aluno Ana em Matemática: " + aluno1.calcularMedia(disciplina1));
        System.out.println("Média do aluno Pedro em Matemática: " + aluno2.calcularMedia(disciplina1));
    }
}


