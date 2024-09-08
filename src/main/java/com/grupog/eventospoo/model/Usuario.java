package com.grupog.eventospoo.model;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nome;
    private String senha;
    private String tipo; // organizador, visitante ou patrocinador


    private static Map<String, Map<String, String>> credenciaisPorTipo = new HashMap<>();

    static {
        credenciaisPorTipo.put("Visitante", new HashMap<>());
        credenciaisPorTipo.put("Organizador", new HashMap<>());
        credenciaisPorTipo.put("Patrocinador", new HashMap<>());
    }

    
    public Usuario(String nome, String senha, String tipo) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        adicionarCredenciais(tipo, nome, senha);
    }

    private static void adicionarCredenciais(String tipo, String nome, String senha) {
        if (credenciaisPorTipo.containsKey(tipo)) {
            credenciaisPorTipo.get(tipo).put(nome, senha);
        }
    }

    public static boolean autenticar(String tipo, String nome, String senha) {
        if (credenciaisPorTipo.containsKey(tipo)) {
            Map<String, String> credenciais = credenciaisPorTipo.get(tipo);
            return credenciais.containsKey(nome) && credenciais.get(nome).equals(senha); //procurar por usuario e senha correspondente
        }
        return false; // colocar um alert dizendo senha/nome incorreto
    }
}
