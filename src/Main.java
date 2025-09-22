import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cadastro> lista = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String menu = """
                [    Cadastro de Alunos    ]
                [ 1 ] Cadastrar
                [ 2 ] Buscar
                [ 3 ] Exibir lista de alunos
                [ 4 ] Sair
                ----------------------------
                """;

        while (true) {

            System.out.println(menu);
            System.out.print("Escolha: ");
            int opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do Aluno: ");
                String nome = input.nextLine();
                int matricula = 1;
                boolean encontrado = false;
                for (Cadastro cadastro : lista) {
                    while (!encontrado) {
                        System.out.print("Numero de Matricula: ");
                        int num = input.nextInt();
                        input.nextLine();
                        if (cadastro.getMatricula() == num || num == 0) {
                            System.out.println("Verifique se alguém já tem esse numero de matricula");
                            System.out.println("OBS: 0 Não é permitido");
                        } else {
                            matricula = num;
                            encontrado = true;
                            break;
                        }
                    }
                }
                System.out.print("Nome do Curso: ");
                String curso = input.nextLine();
                lista.add(new Cadastro(nome, matricula, curso));
                System.out.println("Ok, cadastrado com sucesso");
                System.out.println("----------------------------");
            } else if (opcao == 2) {

                System.out.print("Certo, digite o numero de matricula: ");
                int numero = input.nextInt();
                boolean encontrado = false;
                for (Cadastro cadastro : lista) {

                    if (cadastro.getMatricula() == numero) {
                        System.out.println("Nome: " + cadastro.getNome());
                        System.out.println("Curso: " + cadastro.getCurso());
                        System.out.println("----------------------------");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Esse usuario não existe");
                    System.out.println("----------------------------");
                }

            } else if (opcao == 3) {

                System.out.println("----------- Lista dos Alunos -----------");
                if (lista.isEmpty()) {
                    System.out.println("Não tem ninguem da lista");
                } else {
                    for (Cadastro cadastro : lista) {

                        System.out.println("Nome: " + cadastro.getNome());
                        System.out.println("Matricula: " + cadastro.getMatricula());
                        System.out.println("Curso: " + cadastro.getCurso());
                        System.out.println("-------------------------------------");

                    }
                }
            }else if (opcao == 4) {
                break;
            } else {
                System.out.println("Perdão, essa opção não está disposivel");
            }
        }

    }

}