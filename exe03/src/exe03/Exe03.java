package exe03;
import java.util.ArrayList;
import java.util.List;

// Classe Comentario
class Comentario {
    private String autor;
    private String texto;

    public Comentario(String autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }
}

// Classe Publicacao
class Publicacao {
    private String autor;
    private String conteudo;
    private List<Comentario> comentarios;

    public Publicacao(String autor, String conteudo) {
        this.autor = autor;
        this.conteudo = conteudo;
        this.comentarios = new ArrayList<>();
    }

    public String getAutor() {
        return autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    public void exibirComentarios() {
        System.out.println("Comentários na publicação de " + autor + ":");
        for (Comentario c : comentarios) {
            System.out.println("- " + c.getAutor() + ": " + c.getTexto());
        }
    }
}

// Classe Usuario
class Usuario {
    private String nome;
    private List<Publicacao> publicacoes;

    public Usuario(String nome) {
        this.nome = nome;
        this.publicacoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void criarPublicacao(String conteudo) {
        Publicacao publicacao = new Publicacao(this.nome, conteudo);
        publicacoes.add(publicacao);
    }

    public void comentarPublicacao(Publicacao publicacao, String texto) {
        Comentario comentario = new Comentario(this.nome, texto);
        publicacao.adicionarComentario(comentario);
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void listarPublicacoes() {
        System.out.println("Publicações de " + nome + ":");
        for (Publicacao p : publicacoes) {
            System.out.println("- " + p.getConteudo());
        }
    }
}


public class Exe03 {

    public static void main(String[] args) {
        
        Usuario usuario1 = new Usuario("Alice");
        Usuario usuario2 = new Usuario("Bob");

        
        usuario1.criarPublicacao("Meu primeiro post!");
        usuario1.criarPublicacao("Adoro programação!");

        
        usuario2.criarPublicacao("Hoje está um belo dia!");

        
        usuario1.comentarPublicacao(usuario2.getPublicacoes().get(0), "Concordo, o tempo está ótimo!");

       
        usuario1.listarPublicacoes();
        usuario2.listarPublicacoes();

       
        usuario2.getPublicacoes().get(0).exibirComentarios();
    }
}
