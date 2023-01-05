<img width="800" alt="Screenshot 2023-01-05 at 8 41 55 AM" src="https://user-images.githubusercontent.com/6371078/210693214-36865205-2b85-4949-a9a5-89a648e69259.png">



# Introduction
A Spring, MySQL, and Gradle-based service to generate public keys, private keys, and X509Certificates is a web service that allows users to generate secure cryptographic keys and certificates. 

It is built using the Spring Framework and uses MySQL as its database, and is built and managed using the Gradle build tool. The service provides a set of APIs that allow users to generate public and private keys, as well as X509Certificates, which are widely used to secure communication over the internet. This service can be useful for domain owners and system administrators who need to generate secure keys and certificates for use in their applications or websites.

## Utility to generate RSA public & private key along with X509Certificate
APIs to generate RSA Keys and X509Certificate (Self Signed Certificate) built using Spring Boot, MySQL, Spring Data JPA, Lombok, Bouncy Castle, Mapstruct

## KeyGeneration Service:
* It provides APIs to get, create and delete KeyPairs generated based on the algorithm and keySize provided

## Request for KeyPair Generation:

* algorithm [Ex: RSA, DSA...]
* key_size [Ex: 1024, 2048...]


## Response for KeyPair Generation:
* id
* algorithm 
* key_size
* public_key
* encrypted_private_key

## Digital Certificate Generation Service:
* It Provides APIs to get, create and delete X509Certificate(Self Signed Certificate) based on the parameters provided

### Request for Digital Certificate Generation:
* algorithm
* key_size
* signature_algorithm
* common_name
* certificate_expiry_months


### Response for Digital Certificate Generation:
* id
* x509certificate
* signature_algorithm
* common_name
* certificate_expiry_months
