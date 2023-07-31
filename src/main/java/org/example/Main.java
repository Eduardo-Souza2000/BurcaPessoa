package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        List<Enderecos> enderecos = new ArrayList<>();
        boolean parar = false;


        while (!parar){
            System.out.println(" Novo Cadastro - 1\n");
            System.out.println(" Burcar Pessoa - 2 \n");
            System.out.println(" Sair - 3 \n");

            int opcao = scanner.nextInt();
            scanner.reset();
            switch (opcao){
                case 1:

                        System.out.println(" Insira o nome\n");
                        String nome = scanner.nextLine();
                        System.out.println(" Insira a Idade\n");
                        int idade = scanner.nextInt();

                        /*while (true)
                        {
                            System.out.println(" Novo Endereço - 1\n");
                            System.out.println(" Sair - 2 \n");

                            int opcaoEndereco = scanner.nextInt();
                            scanner.reset();

                            switch (opcaoEndereco){
                                case 1:
                                    String endereco =

                            }
                        }*/







            }
        }

    }
}