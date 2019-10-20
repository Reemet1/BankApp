::   Digest algorithms:
::   blake2b512        blake2s256        gost              md4
::   md5               mdc2              rmd160            sha1
::   sha224            sha256            sha3-224          sha3-256
::   sha3-384          sha3-512          sha384            sha512
::   sha512-224        sha512-256        shake128          shake256
::   sm3

:: openssl dgst -algorithm -out output.file inputfile

:: -c                  Print the digest with separating colons
:: -r                  Print the digest in coreutils format
:: -out outfile        Output to filename rather than stdout
:: -passin val         Input file pass phrase source
:: -sign val           Sign digest using private key
:: -verify val         Verify a signature using public key
:: -prverify val       Verify a signature using private key
:: -signature infile   File with signature to verify
:: -keyform format     Key file format (PEM or ENGINE)
:: -hex                Print as hex dump
:: -binary             Print in binary form
:: -d                  Print debug info
:: -debug              Print debug info
:: -fips-fingerprint   Compute HMAC with the key used in OpenSSL-FIPS fingerprint
:: -hmac val           Create hashed MAC with key
:: -mac val            Create MAC (not necessarily HMAC)
:: -sigopt val         Signature parameter in n:v form
:: -macopt val         MAC algorithm parameters in n:v form or key
:: -*                  Any supported digest
:: -rand val           Load the file(s) into the random number generator
:: -writerand outfile  Write random data to the specified file
:: -engine val         Use engine e, possibly a hardware device
:: -engine_impl        Also use engine given by -engine for digest operations



openssl dgst -c -blake2b512 file.pem
openssl dgst -r -md5 file.pem
openssl dgst -debug -sha224 file.pem
openssl dgst -sha3-384 file.pem
openssl dgst -sha512-224 file.pem
openssl dgst -sm3 file.pem
openssl dgst -blake2s256 file.pem
openssl dgst -mdc2 file.pem
openssl dgst -sha256 file.pem
openssl dgst -sha3-512  file.pem
openssl dgst -sha512-256 file.pem
openssl dgst -gost file.pem
openssl dgst -rmd160 file.pem
openssl dgst -sha3-224 file.pem
openssl dgst -sha384 file.pem
openssl dgst -shake128 file.pem
openssl dgst -md4 file.pem
openssl dgst -sha1 file.pem
openssl dgst -sha3-256 file.pem
openssl dgst -sha512 file.pem
openssl dgst -shake256 file.pem

:: Output digest into file
openssl dgst -blake2b512 -out out/dgst/blake2b512.txt file.pem
openssl dgst -md5 -out out/dgst/md5.txt file.pem
openssl dgst -sha224 -out out/dgst/sha224.txt file.pem
openssl dgst -sha3-384 -out out/dgst/sha3-384.txt file.pem
openssl dgst -sha512-224 -out out/dgst/sha512-224.txt file.pem
openssl dgst -sm3 -out out/dgst/sm3.txt file.pem
openssl dgst -blake2s256 -out out/dgst/blake2s256.txt file.pem
openssl dgst -mdc2 -out out/dgst/mdc2.txt file.pem
openssl dgst -sha256 -out out/dgst/sha256.txt file.pem
openssl dgst -sha3-512  -out out/dgst/sha3-512.txt file.pem
openssl dgst -sha512-256 -out out/dgst/sha512-256.txt file.pem
openssl dgst -gost -out out/dgst/gost.txt file.pem
openssl dgst -rmd160 -out out/dgst/rmd160.txt file.pem
openssl dgst -sha3-224 -out out/dgst/sha3-224.txt file.pem
openssl dgst -sha384 -out out/dgst/sha384.txt file.pem
openssl dgst -shake128 -out out/dgst/shake128.txt file.pem
openssl dgst -md4 -out out/dgst/md4.txt file.pem
openssl dgst -sha1 -out out/dgst/sha1.txt file.pem
openssl dgst -sha3-256 -out out/dgst/sha3-256.txt file.pem
openssl dgst -sha512 -out out/dgst/sha512.txt file.pem
openssl dgst -shake256 -out out/dgst/shake256.txt file.pem




