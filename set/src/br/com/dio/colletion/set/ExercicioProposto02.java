package br.com.dio.colletion.set;

import java.util.*;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
*/
public class ExercicioProposto02 {
    public static void main(String[] args) {
        Set<LinguagemFavorita> minhasLinguagensFavoritas = new HashSet<>();
        minhasLinguagensFavoritas.add(new LinguagemFavorita("Python", 1991, "Pycharm"));
        minhasLinguagensFavoritas.add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
        minhasLinguagensFavoritas.add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));

        Set<LinguagemFavorita> minhasLinguagensFavoritas1 = new LinkedHashSet<>() {{
            add(new LinguagemFavorita("Python", 1991, "Pycharm"));
            add(new LinguagemFavorita("JavaScript", 1995, "IntelliJ"));
            add(new LinguagemFavorita("Java", 1991, "Visual Studio Code"));
        }};
        System.out.println(" Ordem de inserção:");
        System.out.println(minhasLinguagensFavoritas1);

        System.out.println("Ordem natural(nome)");
        Set<LinguagemFavorita> minhasLinguagensFavoritas2 = new TreeSet<>(minhasLinguagensFavoritas1);
        for (LinguagemFavorita l : minhasLinguagensFavoritas2) {
            System.out.println(l.getNome() + " - " + l.getanoDeCriacao() + " - " + l.getIde());
        }

        System.out.println(" IDE");
        Set<LinguagemFavorita> minhasLinguagensFavoritas3 = new TreeSet<>(new ComparatorIde());
        minhasLinguagensFavoritas3.addAll(minhasLinguagensFavoritas1);

        for (LinguagemFavorita l : minhasLinguagensFavoritas3) {
            System.out.println(l.getNome() + " - " + l.getanoDeCriacao() + " - " + l.getIde());
        }

        System.out.println("Ano de criação e nome");
        Set<LinguagemFavorita> minhasLinguagensFavoritas4 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        minhasLinguagensFavoritas4.addAll(minhasLinguagensFavoritas1);
        for (LinguagemFavorita l : minhasLinguagensFavoritas4) {
            System.out.println(l.getNome() + " - " + l.getanoDeCriacao() + " - " + l.getIde());
        }

        System.out.println(" Nome, ano de criação e IDE");
        Set<LinguagemFavorita> minhasLinguagensFavoritas5 = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
        minhasLinguagensFavoritas5.addAll(minhasLinguagensFavoritas1);
        for (LinguagemFavorita l : minhasLinguagensFavoritas5) {
            System.out.println(l.getNome() + " - " + l.getanoDeCriacao() + " - " + l.getIde());
        }

    }

}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacaoo, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacaoo;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getanoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.nome.compareToIgnoreCase(linguagemFavorita.getNome());
    }
}


class ComparatorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().compareToIgnoreCase(l2.getNome());
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getanoDeCriacao(), l2.getanoDeCriacao());
        if (anoCriacao != 0) return anoCriacao;
        return l1.getNome().compareToIgnoreCase(l2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        int anoCriacao = Integer.compare(l1.getanoDeCriacao(), l2.getanoDeCriacao());

        if (nome != 0) return nome;
        if (anoCriacao != 0) return anoCriacao;



        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}
