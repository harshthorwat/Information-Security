public class Encryption {
    private int[] pt;
    private int[] k1;
    private int[] k2;
    int[][] S1={{1,0,3,2},{3,2,1,0},{0,2,1,3},{3,1,3,2}};
    int[][] S2={{0,1,2,3},{2,0,1,3},{3,0,1,0},{2,1,0,3}};
    void setpt(int[] pt){
        this.pt=pt;
    }
    void setk1(int[] k1){
        this.k1=k1;
    }
    void setk2(int[] k2){
        this.k2=k2;
    }
    void encryption(){
        MainEnc mainEnc=new MainEnc();
        int[] ip=new int[8];
        int[] ct=new int[8];
        IP(pt,ip);
        fk(ip,k1,ct);
        SW(ct,ip);
        fk(ip,k2,ct);
        IPInverse(ct,ip);
        System.out.println("Cipher text is: ");
        mainEnc.print(ip);
    }
    int[] IP(int[] ip,int[] op){
        op[0]=ip[1]; op[1]=ip[5]; op[2]=ip[2]; op[3]=ip[0];
        op[4]=ip[3]; op[5]=ip[7]; op[6]=ip[4]; op[7]=ip[6];
        return op;
    }
    void print(int[] ip){
        for (int j=0;j<ip.length;j++)
            System.out.print(ip[j]);
        System.out.println();
    }
    int[] IPInverse(int[] ip,int[] op){
        op[0]=ip[3]; op[1]=ip[0]; op[2]=ip[2]; op[3]=ip[4];
        op[4]=ip[6]; op[5]=ip[1]; op[6]=ip[7]; op[7]=ip[5];
        return op;
    }
    int[] fk(int[] ip,int[] k ,int[] op) {
        int[] L = new int[4];
        int[] R = new int[4];
        int[] ep = new int[8];
        int[] ex = new int[8];
        int[] i = new int[4];
        int[] j = new int[4];
        Right(ip, R);
        EP(R, ep);
        ExOr(ep, k, ex);
        SBox(ex, S1, i);
        p4(i, j);
        Left(ip, L);
        ExOr(L, j, i);
        Add(i, R, op);
        return op;
    }
    int[] Add(int[] i,int[] j,int[] o){
        for (int k=0;k<4;k++)
            o[k]=i[k];
        for (int k=0,l=4;k<4;k++,l++)
            o[l]=j[k];
        return o;
    }
    int[] Left(int[] ip,int[] op){
        for (int i=0;i<4;i++)
            op[i]=ip[i];
        return op;
    }
    int[] Right(int[] ip,int[] op){
        for (int i=0,j=4;i<4;i++,j++)
            op[i]=ip[j];
        return op;
    }
    int[] EP(int[] ip, int[] op){
        op[0]=ip[3]; op[1]=ip[0]; op[2]=ip[1]; op[3]=ip[2];
        op[4]=ip[1]; op[5]=ip[2]; op[6]=ip[3]; op[7]=ip[0];
        return op;
    }
    int[] SBox(int[] ip, int[][] s, int[] op){
        int[] Left=new int[]{ip[0],ip[1],ip[2],ip[3]};
        int[] Right=new int[]{ip[4],ip[5],ip[6],ip[7]};
        int[] rc=new int[2];
        int[] r=new int[2];
        Sbox(Left,rc);
        s1(rc,r);
        op[0]=r[0]; op[1]=r[1];
        Sbox(Right,rc);
        s2(rc,r);
        op[2]=r[0]; op[3]=r[1];
        return op;
    }
    int[] s1(int[] rc,int[] r){
        int i=rc[0],j=rc[1];
        int k=S1[i][j];
        switch (k){
            case 0:
                r[0]=0;r[1]=0; break;
            case 1:
                r[0]=0;r[1]=1; break;
            case 2:
                r[0]=1;r[1]=0; break;
            case 3:
                r[0]=1;r[1]=1; break;
        }
        return r;
    }
    int[] s2(int[] rc,int[] r){
        int i=rc[0],j=rc[1];
        int k=S2[i][j];
        switch (k){
            case 0:
                r[0]=0;r[1]=0; break;
            case 1:
                r[0]=0;r[1]=1; break;
            case 2:
                r[0]=1;r[1]=0; break;
            case 3:
                r[0]=1;r[1]=1; break;
        }return r;
    }
    int[] Sbox(int[] Left,int[] rc){
        int r=0,c=0;
        if (Left[0]==0){
            if (Left[3]==0)
                r=0;
            else if (Left[3]==1)
                r=1;
        }else if (Left[0]==1){
            if (Left[3]==0)
                r=2;
            else if (Left[3]==1)
                r=3;
        }
        if (Left[1]==0){
            if (Left[2]==0)
                c=0;
            else if (Left[2]==1)
                c=1;
        }else if (Left[1]==1){
            if (Left[2]==0)
                c = 2;
            else if (Left[2]==1)
                c=3;
        }
        rc[0]=r;
        rc[1]=c;
        return rc;
    }
    int[] p4(int[] ip,int[] op){
        op[0]=ip[1]; op[1]=ip[3]; op[2]=ip[2]; op[3]=ip[0];
        return ip;
    }
    int[] ExOr(int[] ip,int[] key,int[] op){
        for (int i=0;i<ip.length;i++)
            op[i]=ip[i]^key[i];
        return op;
    }
    int[] SW(int[] ip,int[] op){
        for (int i=0,j=4;i<4;i++,j++)
            op[i]=ip[j];
        for (int i=0,j=4;i<4;i++,j++)
            op[j]=ip[i];
        return op;
    }
}