
package exe05;

    import java.util.ArrayList;
import java.util.Date;
import java.util.List;


    


// Classe Paciente
class Paciente {
    private String nome;

    public Paciente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

// Classe Medico
class Medico {
    private String nome;
    private List<Paciente> pacientes;
    private List<Consulta> consultas;

    public Medico(String nome) {
        this.nome = nome;
        this.pacientes = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void agendarConsulta(Consulta consulta) {
        consultas.add(consulta);
        if (!pacientes.contains(consulta.getPaciente())) {
            pacientes.add(consulta.getPaciente());
        }
    }

    public void listarPacientes() {
        System.out.println("Pacientes do Dr. " + nome + ":");
        for (Paciente paciente : pacientes) {
            System.out.println("- " + paciente.getNome());
        }
    }

    public void exibirProximasConsultas() {
        System.out.println("Próximas consultas do Dr. " + nome + ":");
        for (Consulta consulta : consultas) {
            System.out.println("- " + consulta.getData() + " com " + consulta.getPaciente().getNome());
        }
    }
}

// Classe Consulta
class Consulta {
    private Paciente paciente;
    private Medico medico;
    private Date data;

    public Consulta(Paciente paciente, Medico medico, Date data) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Date getData() {
        return data;
    }
}

// Classe principal para testar o sistema de gerenciamento de clínica
public class Exe05 {

    public static void main(String[] args) {
        // Criando médicos
        Medico medico1 = new Medico("Carlos");
        Medico medico2 = new Medico("Ana");

        // Criando pacientes
        Paciente paciente1 = new Paciente("João");
        Paciente paciente2 = new Paciente("Maria");

        // Agendando consultas
        Consulta consulta1 = new Consulta(paciente1, medico1, new Date());
        medico1.agendarConsulta(consulta1);

        Consulta consulta2 = new Consulta(paciente2, medico1, new Date());
        medico1.agendarConsulta(consulta2);

        Consulta consulta3 = new Consulta(paciente2, medico2, new Date());
        medico2.agendarConsulta(consulta3);

        // Listando pacientes do Dr. Carlos
        medico1.listarPacientes();

        // Exibindo próximas consultas do Dr. Carlos
        medico1.exibirProximasConsultas();

        // Exibindo próximas consultas da Dra. Ana
        medico2.exibirProximasConsultas();
    }
}
