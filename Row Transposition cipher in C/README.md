For Running in Windows use Code Bolcks IDE

For running in Linux use following instructions.

1. Open Terminal in the folder where code is present.

2. For Encryption:

    Compile using:
    
         gcc -o enc RT.c
    
    Run using:
    
        ./enc
        
3. Give Plain text and key as input. key is a integer which contens digits from 1 to n eg. 54231.

4. You will get cipher text as output.

5. For Decryption:

  Compile Using:
  
    gcc -o dec Dec.c
    
  Run Using:
  
    ./dec

6. Give ciphertext and key same as used in Encryption as input. You will get plain text as output.

7. This program usages 'Q' as extra characters so 'Q' can appear at end of your decrepted message and in between your ciphertext.
