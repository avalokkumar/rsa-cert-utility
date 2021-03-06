# Utility to generate RSA public & private along with X509Certificate
APIs to generate RSA Keys and X509Certificate (Self Signed Certificate) built using Spring Boot, MySQL, Spring Data JPA, Lombok, Bouncy Castle, Mapstruct

KeyGeneration Service:
=====
* It provides APIs to get, create and delete KeyPairs generated based on the algorithm and keySize provided

Request for KeyPair Generation:
=====

* algorithm [Ex: RSA, DSA...]
* key_size [Ex: 1024, 2048...]


Response for KeyPair Generation:
=====
* id
* algorithm 
* key_size
* public_key
* encrypted_private_key

#Digital Certificate Generation Service:
* It Provides APIs to get, create and delete X509Certificate(Self Signed Certificate) based on the parameters provided

Request for Digital Certificate Generation:
=====
* algorithm
* key_size
* signature_algorithm
* common_name
* certificate_expiry_months


Response for Digital Certificate Generation:
=====
* id
* x509certificate
* signature_algorithm
* common_name
* certificate_expiry_months
