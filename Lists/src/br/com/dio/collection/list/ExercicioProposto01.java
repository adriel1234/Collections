package br.com.dio.collection.list;

import java.util.*;

public class ExercicioProposto01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> meses = new ArrayList<>(){{
            add("Janeiro");
            add("Fevereiro");
            add("Março");
            add("Abril");
            add("Maio");
            add("Junho");
        }};

        List<Double> temperatura = new ArrayList<>(Arrays.asList(45.5, 32.5,39.3,42.6,40.14,30.5));

        //for(int i=0;i<6;i++){
         //   System.out.println("Informe a temperatura");
        //    temperatura.add(sc.nextDouble());
        //}


        //exibindo todas as temperaturas:
        System.out.print("Todas as temperaturas: ");
        temperatura.forEach(t -> System.out.print(t + " "));

        // calculando a media
        Iterator<Double> iterator = temperatura.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma+=next;
        }

        Double media = soma/temperatura.size();

        System.out.printf("\nMédia das temperaturas: %.1f\n", media);

        for(int i = 0;i<temperatura.size();i++){
            if(temperatura.get(i)>media){
                System.out.println("\nTemperatura: "+temperatura.get(i)+"Cº  Mês: "+meses.get(i));
            }
        }
    }
}
