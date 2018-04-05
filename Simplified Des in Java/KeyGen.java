public class KeyGen {
    private int[] k;
    private int[] k1=new int[8];
    private int[] k2=new int[8];
    void setkey(int[] k){
        this.k=k;
    }
    void keygen(){
        int[] p1 = new int[10];
        int[] l1 = new int[10];
        int[] l2 = new int[10];
        p10(k,p1);
        LeftShift(p1,l1,1);
        p8(l1,k1);
        LeftShift(l1,l2,2);
        p8(l2,k2);
    }
    int[] getK1(){
        return k1;
    }
    int[] getK2(){
        return k2;
    }
    int[] p10(int[] ip,int[] op){
        op[0]=ip[2]; op[1]=ip[4]; op[2]=ip[1]; op[3]=ip[6]; op[4]=ip[3];
        op[5]=ip[9]; op[6]=ip[0]; op[7]=ip[8]; op[8]=ip[7]; op[9]=ip[5];
        return op;
    }
    int[] p8(int ip[], int[] op){
        op[0]=ip[5]; op[1]=ip[2]; op[2]=ip[6]; op[3]=ip[3];
        op[4]=ip[7]; op[5]=ip[4]; op[6]=ip[9]; op[7]=ip[8];
        return op;
    }
    int[] LeftShift(int ip[],int[] op,int i){
        if (i==1){
            op[0]=ip[1]; op[1]=ip[2]; op[2]=ip[3]; op[3]=ip[4]; op[4]=ip[0];
            op[5]=ip[6]; op[6]=ip[7]; op[7]=ip[8]; op[8]=ip[9]; op[9]=ip[5];
        }
        else if (i==2){
            op[0]=ip[2]; op[1]=ip[3]; op[2]=ip[4]; op[3]=ip[0]; op[4]=ip[1];
            op[5]=ip[7]; op[6]=ip[8]; op[7]=ip[9]; op[8]=ip[5]; op[9]=ip[6];
        }
        return op;
    }
}