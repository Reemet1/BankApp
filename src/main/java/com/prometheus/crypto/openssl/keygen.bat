
:: genpkey standard form:
:: openssl genpkey [-out filename] [-outform PEM|DER] [-pass arg] [-cipher] [-engine id]
:: [-paramfile file] [-algorithm alg] [-pkeyopt opt:value] [-genparam] [-text]

:: -out outfile       Output file
:: -outform PEM|DER   output format (DER or PEM)
:: -pass val          Output file pass phrase source
:: -paramfile infile  Parameters file
:: -algorithm val     The public key algorithm
:: -pkeyopt val       Set the public key algorithm option as opt:value
:: -genparam          Generate parameters, not key
:: -text              Print the in text
:: -*                 Cipher to use to encrypt the key
:: -engine val        Use engine, possibly a hardware device


:: genpkey is replacement for genrsa
openssl genrsa -out out/keys/keypair-rsa.pem 1024
openssl genpkey -algorithm rsa -out out/keys/private-rsa.pem

:: reading rsa private key
openssl rsa -in out/keys/private-rsa.pem -text