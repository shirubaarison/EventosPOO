package com.grupog.eventospoo.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ArquivoUtils {

    private static final String ARQUIVO_CREDENCIAIS = "credenciais.txt";

    public static void salvarCredenciais(Map<String, String> credenciais) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CREDENCIAIS))) {
            for (Map.Entry<String, String> entry : credenciais.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        }
    }

    public static Map<String, String> carregarCredenciais() throws IOException {
        Map<String, String> credenciais = new HashMap<>();
        File file = new File(ARQUIVO_CREDENCIAIS);
        if (!file.exists()) return credenciais;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 2) {
                    credenciais.put(partes[0], partes[1]);
                }
            }
        }
        return credenciais;
    }
}
