package ru.margarita.ExpertSystem.security;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.SHA256Digest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AuthUtil {

    public static String generateRefreshToken(String... args) {
        StringBuilder stringForToken = new StringBuilder();

        for (String arg : args) {
            stringForToken.append(arg);
        }

        try {
            byte [] hashInBytes = MessageDigest.getInstance("SHA-256")
                  .digest(stringForToken.toString().getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashInBytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new IllegalStateException (e.getMessage());
        }
    }
}
