
:: The symmetric cipher commands allow data to be encrypted or decrypted using various
:: block and stream ciphers using keys based on passwords or explicitly provided.
:: Base64 encoding or decoding can also be performed either by itself or in addition to the encryption or decryption.

:: Standard form of enc command:
:: openssl enc -ciphername [-in filename] [-out filename] [-pass arg] [-e] [-d] [-a/-base64] [-A]
:: [-k password] [-kfile filename] [-K key] [-iv IV] [-S salt] [-salt] [-nosalt] [-z] [-md] [-p]
:: [-P] [-bufsize number] [-nopad] [-debug] [-none] [-engine id]

:: -ciphers            List ciphers
:: -in infile          Input file
:: -out outfile        Output file
:: -pass val           Passphrase source
:: -e                  Encrypt
:: -d                  Decrypt
:: -p                  Print the iv/key
:: -P                  Print the iv/key and exit
:: -v                  Verbose output
:: -nopad              Disable standard block padding
:: -salt               Use salt in the KDF (default)
:: -nosalt             Do not use salt in the KDF
:: -debug              Print debug info
:: -a                  Base64 encode/decode, depending on encryption flag
:: -base64             Same as option -a
:: -A                  Used with -[base64|a] to specify base64 buffer as a single line
:: -bufsize val        Buffer size
:: -k val              Passphrase
:: -kfile infile       Read passphrase from file
:: -K val              Raw key, in hex
:: -S val              Salt, in hex
:: -iv val             IV in hex
:: -md val             Use specified digest to create a key from the passphrase
:: -iter +int          Specify the iteration count and force use of PBKDF2
:: -pbkdf2             Use password-based key derivation function 2
:: -none               Don't encrypt
:: -*                  Any supported cipher
:: -rand val           Load the file(s) into the random number generator
:: -writerand outfile  Write random data to the specified file
:: -engine val         Use engine, possibly a hardware device


openssl enc -aes-256-cbc -in file.pem -out out/enc/aes-256-cbc.bin