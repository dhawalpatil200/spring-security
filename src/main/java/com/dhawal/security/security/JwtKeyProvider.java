package com.dhawal.security.security;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Component
public class JwtKeyProvider {

    private final Key secretKey;

    // Inject the secret key from the properties file
    public JwtKeyProvider(@Value("${auth.jwt.secret}") String secret) {
        this.secretKey = convertStringToKey(secret);
    }

    // Convert the secret string into a Key object
    private Key convertStringToKey(String secret) {
        // Decode the secret if it's Base64 encoded, else directly use it
        byte[] keyBytes = secret.getBytes();
        if (Base64.getEncoder().encodeToString(keyBytes).equals(secret)) {
            keyBytes = Base64.getDecoder().decode(secret);
        }

        // Ensure the key is the right size (e.g., AES needs 128/192/256 bits)
        byte[] adjustedKeyBytes = new byte[32]; // For HS256, key size should be 256 bits
        System.arraycopy(keyBytes, 0, adjustedKeyBytes, 0, Math.min(keyBytes.length, 32));

        return new SecretKeySpec(adjustedKeyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    public Key getSecretKey() {
        return secretKey;
    }
}
