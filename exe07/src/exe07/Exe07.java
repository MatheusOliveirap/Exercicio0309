
package exe07;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Classe Autor
class Autor {
    private String nome;

    public Autor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

// Classe Livro
class Livro {
    private String titulo;
    private Autor autor;
    private int totalEmprestimos;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totalEmprestimos = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void incrementarEmprestimos() {
        totalEmprestimos++;
    }

    public int getTotalEmprestimos() {
        return totalEmprestimos;
    }
}

// Classe Usuario
class Usuario {
    private String nome;
    private List<Emprestimo> emprestimos;

    public Usuario(String nome) {
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}

// Classe Emprestimo
class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private static final double MULTA_POR_DIA = 2.0; // Multa por dia de atraso

    public Emprestimo(Livro livro, Usuario usuario, Date dataEmprestimo, Date dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        livro.incrementarEmprestimos();
        usuario.adicionarEmprestimo(this);
    }

    public Livro getLivro() {
        return livro;
    }

    public double calcularMulta() {
        Date hoje = new Date();
        if (hoje.after(dataDevolucao)) {
            long diffInMillies = Math.abs(hoje.getTime() - dataDevolucao.getTime());
            long diasAtraso = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            return diasAtraso * MULTA_POR_DIA;
        }
        return 0;
    }
}

// Classe principal para testar o sistema de biblioteca virtual
public class Exe07 {

    public static void main(String[] args) {
        // Criando autores
        Autor autor1 = new Autor("George Orwell");
        Autor autor2 = new Autor("J.K. Rowling");

        // Criando livros
        Livro livro1 = new Livro("1984", autor1);
        Livro livro2 = new Livro("Harry Potter e a Pedra Filosofal", autor2);

        // Criando usuários
        Usuario usuario1 = new Usuario("Alice");
        Usuario usuario2 = new Usuario("Bob");

        // Realizando empréstimos
        Emprestimo emprestimo1 = new Emprestimo(livro1, usuario1, new Date(), new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7)));
        Emprestimo emprestimo2 = new Emprestimo(livro2, usuario2, new Date(), new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7)));

        // Calculando multas (simulação)
        System.out.println("Multa para " + usuario1.getNome() + ": R$ " + emprestimo1.calcularMulta());
        System.out.println("Multa para " + usuario2.getNome() + ": R$ " + emprestimo2.calcularMulta());

        // Exibindo livros mais populares
        List<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);

        listarLivrosMaisPopulares(livros);
    }

    public static void listarLivrosMaisPopulares(List<Livro> livros) {
        System.out.println("Livros mais populares:");
        livros.sort((l1, l2) -> Integer.compare(l2.getTotalEmprestimos(), l1.getTotalEmprestimos()));
        for (Livro livro : livros) {
            System.out.println("- " + livro.getTitulo() + " (" + livro.getTotalEmprestimos() + " empréstimos)");
        }
    }
}


