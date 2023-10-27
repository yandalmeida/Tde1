package model;

public class Aluno {
    private int matricula;
    private String nome;
    private int codigoCurso;

    public Aluno(int matricula, String nome, int codigoCurso) {
        this.matricula = matricula;
        this.nome = nome;
        this.codigoCurso = codigoCurso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return "Aluno [Matrícula=" + matricula + ", Nome=" + nome + ", Código do Curso=" + codigoCurso + "]";
    }
}