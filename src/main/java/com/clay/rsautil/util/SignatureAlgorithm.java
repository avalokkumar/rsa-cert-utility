package com.clay.rsautil.util;

public enum SignatureAlgorithm {

    SHA1_WITH_RSA("SHA1withRSA", "http://www.w3.org/2000/09/xmldsig#rsa-sha1"),
    SHA224_WITH_RSA("SHA224withRSA", "http://www.w3.org/2001/04/xmldsig-more#rsa-sha224"),
    SHA256_WITH_RSA("SHA256withRSA", "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"),
    SHA384_WITH_RSA("SHA384withRSA", "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384"),
    SHA512_WITH_RSA("SHA512withRSA", "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512");

    SignatureAlgorithm(String name, String algorithmUri ) {
        this.name = name;
        this.algorithmUri = algorithmUri;
    }

    String name;
    String algorithmUri;

    public String getAlgorithmUri() {
        return this.algorithmUri;
    }

    public String getName() { return name; }

}
