package repositories;

import contracts.iAlunoRepository;
import models.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAlunoRepository implements iAlunoRepository {

  public ArrayList<Aluno> alunos = new ArrayList<>();

  public void adicionar(Aluno aluno) {
    alunos.add(aluno);
  }

  public void remover(Aluno aluno) {
    alunos.remove(aluno);
  }

  public Aluno buscar(String nome) {
    for (Aluno aluno : alunos) {
      if (aluno.getNome().equals(nome)) {
        return aluno;
      }
    }
    return null;
  }

  public List<Aluno> listar() {
    return alunos;
  }
}
