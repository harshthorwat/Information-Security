import java.util.Scanner;
public class Decryption {
    public static void main(String [] args){
        Encryption encryption=new Encryption();
        KeyGen keyGen=new KeyGen();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a 10 bit Key");
        int k=scanner.nextInt();
        System.out.println("Enter 8 bit cipher Text");
        int c=scanner.nextInt();
        int[] Key=new int[10];
        int[] ct=new int[8];
        Convert(k,Key,9);
        Convert(c,ct,7);
        keyGen.setkey(Key);
        keyGen.keygen();
        int[] k1=keyGen.getK1();
        int[] k2=keyGen.getK2();
        int[] ip=new int[8];
        encryption.IP(ct,ip);
        encryption.fk(ip,k2,ct);
        encryption.SW(ct,ip);
        encryption.fk(ip,k1,ct);
        encryption.IPInverse(ct,ip);
        System.out.println("Plain text is" );
        print(ip);
    }
    static int[] Convert(int k,int[] op,int i){
        while (k>0){
            int j=k%10;
            op[i]=j;
            k=k/10;
            i--;
        }
        return op;
    }
    static void print(int[] ip){
        for (int j=0;j<ip.length;j++)
            System.out.print(ip[j]);
        System.out.println();
    }
}
