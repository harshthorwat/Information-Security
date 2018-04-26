import java.util.Scanner;

public class Encryption {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Encryption encryption=new Encryption();
        Functions functions=new Functions();
        KeyGen keyGen=new KeyGen();

        String K;
        String P;

        System.out.println("Enter a 64 bit key");
        K=scanner.nextLine();
        System.out.println("Enter a 64 bit PlainText");
        P=scanner.nextLine();

        int[] Key=encryption.toInt(K);
        int[] Ptxt=encryption.toInt(P);
        int[] k1=keyGen.PCOne(Key);

        int[] ct=functions.initPermutation(Ptxt);

        for (int i=0;i<16;i++){
            keyGen.setKey(k1);
            int[] k2=keyGen.keyGen(i);
            int[] k3=keyGen.Decrypt(i);
            functions.setPtext(ct);
            functions.setKey(k2);
            ct=functions.function();
            k1=k3;
        }

        System.out.println("Cipher text is: ");
        Ptxt=functions.inverseInitPerm(ct);
        Print(Ptxt);
    }

    int[] toInt(String ip){
        int[] op=new int[64];
        int i=0;

        while (i<64){
            if (ip.charAt(i)=='0'){
                op[i]=0;
            }
            else if (ip.charAt(i)=='1'){
                op[i]=1;
            }
            i++;
        }
        return op;
    }

    static void Print(int[] i){
        for (int j=0;j<i.length;j++){
            System.out.print(i[j]);
        }
        System.out.println();
    }
}