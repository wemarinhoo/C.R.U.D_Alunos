import contracts.iAlunoRepository;
import models.Aluno;
import repositories.ArrayListAlunoRepository;
import exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

      iAlunoRepository repositorio = new ArrayListAlunoRepository();

      while (true) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha o Número que Representa a Operação Desejada");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Buscar Aluno");
        System.out.println("3 - Remover Aluno");
        System.out.println("4 - Listar Alunos Cadastrados");
        int operacao = scan.nextInt();
        scan.nextLine();

        switch (operacao) {
          case 0:
            break;
          case 1:
            System.out.print("Insira o Nome do Aluno: ");
            String nome = scan.nextLine();
            System.out.print("Insira a Matrícula do Aluno: ");
            String matricula = scan.nextLine();
            if (!nome.matches("[A-Za-z]+")) {
              System.out.println("O Nome Deve Conter Apenas Letras");
            } else if (!matricula.matches("\\d+")){
              System.out.println("A Matrícula Deve Conter Apenas Números");
            } else if (matricula.length() != 10){
              throw new MatriculaInvalidaException("Matrícula Inválida, Deve Possuir 10 números");
            }else {
              repositorio.adicionar(new Aluno(nome, matricula));
              System.out.println("Aluno Cadastrado Com Sucesso");
              System.out.println("-------------------------------------------------");
            }
            break;
          case 2:
            System.out.print("Digite o Nome do Aluno Que Deseja Buscar: ");
            String nome_busca = scan.nextLine();
            Aluno aluno_busca = repositorio.buscar(nome_busca);
            if (aluno_busca == null) {
              throw new AlunoNaoEncontradoException("O Aluno Não Foi Encontrado");
            } else {
              System.out.println("Informações do Aluno Buscado");
              System.out.println("Nome: " + aluno_busca.getNome());
              System.out.println("Matrícula: " + aluno_busca.getMatricula());
              System.out.println("-------------------------------------------------");
            }
            break;
          case 3:
            System.out.print("Insira o Nome do Aluno Que Deseja Remover: ");
            String nome_remover = scan.nextLine();
            Aluno aluno_remover = repositorio.buscar(nome_remover);
            if (aluno_remover == null) {
              System.out.println("Não Foi Possível Remover, Aluno Não Encontrado");
              System.out.println("-------------------------------------------------");
            } else {
              repositorio.remover(aluno_remover);
              System.out.println("O Aluno " + nome_remover + " Foi Removido");
              System.out.println("-------------------------------------------------");
            }
            break;
          case 4:
            System.out.println("Alunos Cadastrados:");
            for (Aluno aluno : repositorio.listar()) {
              System.out.println("Nome: " + aluno.getNome());
              System.out.println("Matrícula: " + aluno.getMatricula());
              System.out.println("-------------------------------------------------");
            }
            break;
          default:
            System.out.println("Operação Inválida");
          }
        }
      }
    }