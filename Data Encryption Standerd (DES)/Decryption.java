import java.util.Scanner;

public class Decryption {
    public static void main(String[] args){
        Encryption encryption=new Encryption();
        DecFunction functions=new DecFunction();
        KeyGen keyGen=new KeyGen();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Cipher text: ");
        String d=scanner.nextLine();
        System.out.println("Enter key: ");
        String k=scanner.nextLine();
        int[] dec=encryption.toInt(d);
        int[] key=encryption.toInt(k);


        int[] txt=functions.initPermutation(dec);
        for (int i=15;i>=0;i--){
            int[] K=getKey(key,i);
            functions.setKey(K);
            functions.setPtext(txt);
            int[] a=functions.function();
            txt=a;
        }
        System.out.println("Plain text is: ");
        int[] pt=functions.inverseInitPerm(txt);
        Encryption.Print(pt);
    }

    public static int[] getKey(int[] key,int j){
        KeyGen keyGen=new KeyGen();
        int[] op=keyGen.PCOne(key);
        int[] k2=key;
        for (int i=0;i<=j;i++){
            keyGen.setKey(op);
            k2=keyGen.keyGen(i);
            int[] k3=keyGen.Decrypt(i);
            op=k3;
        }
        return k2;
    }
}
