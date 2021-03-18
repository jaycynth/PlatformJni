package com.julie.jffi_issue;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import dev.paseto.jpaseto.Pasetos;

@RequiresApi(api = Build.VERSION_CODES.O)
public class pas {

    static String key = "76mwj+nKNqhT51W2B/6mUrAm94rQlR3r7+UcExASBjk=";
    static byte[] sk = Base64.getDecoder().decode(key);
    static SecretKey bk = new SecretKeySpec(sk, "none");

    public static void main(String[] args) {


        Instant now = Instant.now();

        String token = Pasetos.V2.LOCAL.builder()
                .setSharedSecret(bk)
                .setIssuedAt(now)
                .setExpiration(now.plus(30000, ChronoUnit.SECONDS))
                .setKeyId("a32d27a04589e87b806c3b1cecb1c9e3c1397dec")
                .compact();

        System.out.println(token);

    }

    public static String generateToken() {
        Instant now = Instant.now();

        return Pasetos.V2.LOCAL.builder()
                .setSharedSecret(bk)
                .setIssuedAt(now)
                .setExpiration(now.plus(30000, ChronoUnit.SECONDS))
                .setKeyId("a32d27a04589e87b806c3b1cecb1c9e3c1397dec")
                .compact();
    }
}
