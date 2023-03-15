package br.com.dio.collection.map;

/*
Dada a população estimada de alguns estados do nordeste brasileiro, faça:
 Estado = PE - população = 9.616.621
 Estado = AL - população = 3.351.543
 Estado = CE - população  = 9.187.103
 Estado = RN - população = 3.534.265
 */

import java.util.*;
public class ExercicioProposto01 {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que relacione os estados e suas respectivas populações: ");
        Map<String, Integer> populacaoEstadosNE = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(populacaoEstadosNE);
        System.out.println("Substitua a população do estado RN por : 3.534.165");
        populacaoEstadosNE.put("PE",3534165);
        System.out.println(populacaoEstadosNE);


        System.out.println("Confira se o estado da Paraíba (PB) tucson está no dicionário, caso não, adicione " +
                "PB - 4.039.277: ");
        boolean existePb=false;
        for (Map.Entry<String, Integer> p: populacaoEstadosNE.entrySet()) {
            if(p.getKey().equals("PB")){
                existePb=true;
            }
        }

        if (existePb == false){
            populacaoEstadosNE.put("PB",4039277);
        }
        System.out.println(populacaoEstadosNE);

        System.out.println("Exiba a população do estado PE: " +populacaoEstadosNE.get("PE"));


        System.out.println("Exiba todos os estados e suas populaçãos na ordem em que foram informados: ");
        Map<String,Integer>populacaoEstadosNE2 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        System.out.println(populacaoEstadosNE2);

        System.out.println("Exiba todos os estados e suas populações na ordem alfabética: ");

        Map<String,Integer>populacaoEstadosNE3 = new TreeMap<>(populacaoEstadosNE);

        System.out.println(populacaoEstadosNE3);

        Collection<Integer> populacao = populacaoEstadosNE.values();

        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";

        for (Map.Entry<String, Integer> p: populacaoEstadosNE.entrySet()) {
            if(p.getValue().equals(Collections.max(populacao))){
                estadoMaiorPopulacao = p.getKey();
            }
            if(p.getValue().equals(Collections.min(populacao))){
                estadoMenorPopulacao = p.getKey();
            }
        }
        System.out.printf("Exiba o estado com o menor população (%s) e seu respectivo valor (%d)\n",
                estadoMenorPopulacao, Collections.min(populacao));
        System.out.printf("Exiba o estado com a maior população (%s) e seu respectivo valor (%d)\n",
                estadoMaiorPopulacao, Collections.max(populacao));

        int soma = 0;

        Iterator<Integer> iterator = populacaoEstadosNE3.values().iterator();
        while (iterator.hasNext()){
            soma += iterator.next();
        }

        System.out.println("Exiba a soma da população desses estados: " + soma);

        System.out.println("Exiba a média da população deste dicionário de estados: "+(soma/populacaoEstadosNE3.size()));

        System.out.println("Remova os estados com a população menor que 4.000.000: ");
        Iterator<Integer> iterator2 = populacaoEstadosNE3.values().iterator();
        while (iterator2.hasNext()){
            if(iterator2.next() <=4000000){
                iterator2.remove();
            }
        }
        System.out.println(populacaoEstadosNE3);
        System.out.println("Apague o dicionario de estados com suas respectivas populações estimadas: ");
        populacaoEstadosNE.clear();
        System.out.println(populacaoEstadosNE);
        System.out.println("Confira se a lista está vazia: " + populacaoEstadosNE.isEmpty());

    }
}
