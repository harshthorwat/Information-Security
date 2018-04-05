import java.util.Scanner;
public class MainEnc {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a 10 bit key");
        int k=sc.nextInt();
        System.out.println("Enter a 8 bit plain text");
        int p=sc.nextInt();
        int[] pt=new int[8];
        int[] key=new int[10];
        Convert(k,key,9);
        KeyGen KG=new KeyGen();
        KG.setkey(key);
        KG.keygen();
        int[] k1=KG.getK1();
        int[] k2=KG.getK2();
        Convert(p,pt,7);
        Encryption Ec = new Encryption();
        Ec.setpt(pt);
        Ec.setk1(k1);
        Ec.setk2(k2);
        Ec.encryption();
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