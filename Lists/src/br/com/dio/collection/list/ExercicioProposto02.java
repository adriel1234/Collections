package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char resposta;
        List<String> perguntas = new ArrayList<>(){{
            add("Telefonou para a vítima?");
            add("Esteve no local do crime?");
            add("Mora perto da vítima?");
            add("Devia para a vítima?");
            add("Já trabalhou com a vítima?");
        }};
        int cont=0;

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(perguntas.get(i)+"\ns - para sim\nn - para não\n");
            resposta = sc.next().charAt(0);

            if(resposta == 's' || resposta == 'S'){
                cont++;
            }

        }

        if(cont <2){
            System.out.println("Inocente");
        }else if(cont == 2){
            System.out.println("Supeita");
        }else if(cont < 5){
            System.out.println("Cúmplice");
        }else if(cont == 5 ){
            System.out.println("Assassina");
        }

    }
}
