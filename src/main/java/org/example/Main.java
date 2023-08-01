package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean opcMenu = false;
        while (!opcMenu){
            System.out.println(" Cadastrar Pessoa - 1\n");
            System.out.println(" Buscar Pessoa - 2 \n");
            System.out.println(" Lista de Pessoa - 3 \n");
            System.out.println(" Sair - 4 \n");
            int opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    pessoas = cadastrarPessoas(pessoas);
                    break;
                case 2:
                    burcarPessoas(pessoas);
                    break;
                case 3:
                    listarPessoas(pessoas);
                    break;
                case 4:
                    return;
            }

        }



    }



    public static List<Pessoa> cadastrarPessoas (List<Pessoa> pessoas){

        Scanner sc = new Scanner(System.in);
        boolean sair = false;
        do{
            System.out.println("Digite o nome e a idade: ");
            String nome = sc.next();
            int idade = sc.nextInt();
            List<Endereco> enderecos = new ArrayList<>();
            boolean sairEndereco = false;
            int confirmaEndereco = 0;
            int sairCadastro = 0;

            do {
                System.out.println("Digite o endereco rua numero: ");
                Endereco endereco = new Endereco(sc.next(), sc.nextInt());
                System.out.println("Sair?");
                System.out.println("Sim 1\nNao 2");
                confirmaEndereco = sc.nextInt();
                sc.reset();
                if(confirmaEndereco == 1){
                    sairEndereco = true;
                }
                enderecos.add(endereco);

            } while(!sairEndereco);
            pessoas.add(new Pessoa(nome, idade, enderecos));

            System.out.println("Cadastrar outra pessoa - 1");
            System.out.println("Sair - 2");
            sairCadastro = sc.nextInt();

            if(sairCadastro == 2){
                sair = true;
            }

        }while(!sair);
        return pessoas;
    }

    public  static void burcarPessoas (List<Pessoa> pessoas){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o Nome da Pessoa: ");
        String nome = sc.nextLine();
        AtomicBoolean encontrou = new AtomicBoolean(false);

        pessoas.forEach(pessoa -> {
            if (pessoa.getNome().equals(nome)){
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Idade: " + pessoa.getIdade());
                pessoa.getEnderecos().forEach(endereco -> {
                    System.out.println("Numero: " + endereco.getNumero());
                    System.out.println("Rua: " + endereco.getRua());
                });
                encontrou.set(true);
            }
        });
        if(!encontrou.get()){
            System.out.println("Nome nao encontrado" );
        }


    }

    public static void listarPessoas (List<Pessoa> pessoas){
        pessoas.forEach(pessoa -> {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());
            pessoa.getEnderecos().forEach(endereco -> {
                System.out.println("Numero: " + endereco.getNumero());
                System.out.println("Rua: " + endereco.getRua());
            });
        });
    }

}

