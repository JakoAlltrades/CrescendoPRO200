//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sun.net.ssl.internal.ssl;

import java.security.AccessController;
import java.security.PrivilegedAction;

public final class Provider extends java.security.Provider {
    private static String a = "Sun JSSE provider(implements RSA Signatures, PKCS12, SunX509 key/trust factories, SSLv3, TLSv1)";

    public Provider() {
        super("SunJSSE", 1.02D, a);
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                Provider.this.put("KeyFactory.RSA", "com.sun.net.ssl.internal.ssl.JSA_RSAKeyFactory");
                Provider.this.put("KeyPairGenerator.RSA", "com.sun.net.ssl.internal.ssl.JSA_RSAKeyPairGenerator");
                Provider.this.put("Signature.MD2withRSA", "com.sun.net.ssl.internal.ssl.JSA_MD2RSASignature");
                Provider.this.put("Signature.MD5withRSA", "com.sun.net.ssl.internal.ssl.JSA_MD5RSASignature");
                Provider.this.put("Signature.SHA1withRSA", "com.sun.net.ssl.internal.ssl.JSA_SHA1RSASignature");
                Provider.this.put("KeyManagerFactory.SunX509", "com.sun.net.ssl.internal.ssl.KeyManagerFactoryImpl");
                Provider.this.put("TrustManagerFactory.SunX509", "com.sun.net.ssl.internal.ssl.TrustManagerFactoryImpl");
                Provider.this.put("SSLContext.SSL", "com.sun.net.ssl.internal.ssl.SSLContextImpl");
                Provider.this.put("SSLContext.SSLv3", "com.sun.net.ssl.internal.ssl.SSLContextImpl");
                Provider.this.put("SSLContext.TLS", "com.sun.net.ssl.internal.ssl.SSLContextImpl");
                Provider.this.put("SSLContext.TLSv1", "com.sun.net.ssl.internal.ssl.SSLContextImpl");
                Provider.this.put("KeyStore.PKCS12", "com.sun.net.ssl.internal.ssl.PKCS12KeyStore");
                return null;
            }
        });
    }

    public static synchronized void install() {
    }
}