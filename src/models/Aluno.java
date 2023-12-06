package models;

import exceptions.*;

public class Aluno{
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws MatriculaInvalidaException{
        this.matricula = matricula;
        if (matricula.length() != 10){
            throw new MatriculaInvalidaException("A Matrícula Precisa Possuir 10 Números");
        }
    }
}
