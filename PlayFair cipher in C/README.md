For Running in Windows use Code Bolcks IDE

For Running this program in Linux use following instructions.

Open Terminal in the directory where code is present.

1. For Encryption: 
  
   compile using:
   
        gcc -o enc play.c
   
   run using:
   
        ./enc
   
2. Give a text Key.

3. The program will give generated Matrix for you.

4. Then enter a plain text.

5. CipherText will be generated as Output.

6. For Decryption:
  
   Compile using:
    
        gcc -o dec playDec.c
     
    run using:
      
        ./dec
    
7. Give key same as used in Encryption and cipherText as input.

8. You will get plainText as output.

9. 'Q' is used as substitution character in code so 'Q' can appear at the end of decrypted message.
