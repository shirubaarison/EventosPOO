package com.grupog.eventospoo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    public static String hashPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser nula ou vazia");
        }

        try {
            // Hash feito com SHA-256, não deve ser tão seguro, mas é o que iremos utilizar nesse projeto
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            digest.update(password.getBytes());

            return new String(digest.digest());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error ao dar hashing na senha", e);
        }
    }

    public static boolean verificarSenha(String rawPassword, String storedHash) {
        String hashedPassword = hashPassword(rawPassword);

        return hashedPassword.equals(storedHash);
    }
}
