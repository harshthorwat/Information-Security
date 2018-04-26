public class DecFunction {
    private int[] Key=new int[48];
    private int[] Ptext=new int[64];

    public final int[][] S1={{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},{0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},{4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},{15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}};
    public final int[][] S2={{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},{0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
    public final int[][] S3={{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},{13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},{13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},{1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};
    public final int[][] S4={{7,12,14,3,0,6,9,10,1,2,8,5,11,12,4,15},{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},{10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};
    public final int[][] S5={{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},{14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},{4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},{11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};
    public final int[][] S6={{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},{10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},{9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},{4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};
    public final int[][] S7={{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},{13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},{1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},{6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}};
    public final int[][] S8={{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},{1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},{7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},{2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}};

    public void setKey(int[] key){
        Key=key;
    }

    public void setPtext(int[] ptext){
        Ptext=ptext;
    }

    public int[] function(){
        KeyGen keyGen=new KeyGen();
        int[] Right=keyGen.Left(Ptext);
        int[] ep=expansionPermutation(Right);
        int[] xor=XOR(ep,Key);//48
        int[] sb=SBox(xor);//48
        int[] op=Final(Right,sb);
        return op;
    }

    public int[] Final(int[] Right,int[] Round){
        int[] op = new int[64];

        for (int i=0;i<Right.length;i++){
            op[i]=Round[i];
        }
        for (int i=0,j=Right.length;i<Right.length;i++,j++){
            op[j]=Right[i];
        }

        return op;
    }

    public int[] initPermutation(int[] ip){
        int[] op=new int[64];

        op[0]=ip[57];  op[1]=ip[49];  op[2]=ip[41];  op[3]=ip[33];  op[4]=ip[25];  op[5]=ip[17];  op[6]=ip[9];   op[7]=ip[1];
        op[8]=ip[59];  op[9]=ip[51];  op[10]=ip[43]; op[11]=ip[35]; op[12]=ip[27]; op[13]=ip[19]; op[14]=ip[11]; op[15]=ip[3];
        op[16]=ip[61]; op[17]=ip[53]; op[18]=ip[45]; op[19]=ip[37]; op[20]=ip[29]; op[21]=ip[21]; op[22]=ip[13]; op[23]=ip[5];
        op[24]=ip[63]; op[25]=ip[55]; op[26]=ip[47]; op[27]=ip[39]; op[28]=ip[31]; op[29]=ip[23]; op[30]=ip[15]; op[31]=ip[7];
        op[32]=ip[56]; op[33]=ip[48]; op[34]=ip[40]; op[35]=ip[32]; op[36]=ip[24]; op[37]=ip[16]; op[38]=ip[8];  op[39]=ip[0];
        op[40]=ip[58]; op[41]=ip[50]; op[42]=ip[42]; op[43]=ip[34]; op[44]=ip[26]; op[45]=ip[18]; op[46]=ip[10]; op[47]=ip[2];
        op[48]=ip[60]; op[49]=ip[52]; op[50]=ip[44]; op[51]=ip[36]; op[52]=ip[28]; op[53]=ip[20]; op[54]=ip[12]; op[55]=ip[4];
        op[56]=ip[62]; op[57]=ip[54]; op[58]=ip[47]; op[59]=ip[38]; op[60]=ip[30]; op[61]=ip[22]; op[62]=ip[14]; op[63]=ip[6];

        return op;
    }

    public int[] inverseInitPerm(int[] ip){
        int[] op=new int[64];

        op[0]=ip[39];  op[1]=ip[7];  op[2]=ip[47];  op[3]=ip[15];  op[4]=ip[55];  op[5]=ip[23];  op[6]=ip[63];  op[7]=ip[31];
        op[8]=ip[38];  op[9]=ip[6];  op[10]=ip[46]; op[11]=ip[14]; op[12]=ip[54]; op[13]=ip[22]; op[14]=ip[62]; op[15]=ip[30];
        op[16]=ip[37]; op[17]=ip[5]; op[18]=ip[45]; op[19]=ip[13]; op[20]=ip[53]; op[21]=ip[21]; op[22]=ip[61]; op[23]=ip[29];
        op[24]=ip[36]; op[25]=ip[4]; op[26]=ip[44]; op[27]=ip[12]; op[28]=ip[52]; op[29]=ip[20]; op[30]=ip[60]; op[31]=ip[28];
        op[32]=ip[35]; op[33]=ip[3]; op[34]=ip[43]; op[35]=ip[11]; op[36]=ip[51]; op[37]=ip[19]; op[38]=ip[59]; op[39]=ip[27];
        op[40]=ip[34]; op[41]=ip[2]; op[42]=ip[42]; op[43]=ip[10]; op[44]=ip[50]; op[45]=ip[18]; op[46]=ip[58]; op[47]=ip[26];
        op[48]=ip[33]; op[49]=ip[1]; op[50]=ip[41]; op[51]=ip[9];  op[52]=ip[49]; op[53]=ip[17]; op[54]=ip[57]; op[55]=ip[25];
        op[56]=ip[32]; op[57]=ip[0]; op[58]=ip[40]; op[59]=ip[8];  op[60]=ip[48]; op[61]=ip[16]; op[62]=ip[56]; op[63]=ip[23];

        return op;
    }

    public int[] expansionPermutation(int[] ip){
        int[] op=new int[48];

        op[0]=ip[31];  op[1]=ip[0];   op[2]=ip[1];   op[3]=ip[2];   op[4]=ip[3];   op[5]=ip[4];   op[6]=ip[3];   op[7]=ip[4];
        op[8]=ip[5];   op[9]=ip[6];   op[10]=ip[7];  op[11]=ip[8];  op[12]=ip[7];  op[13]=ip[8];  op[14]=ip[9];  op[15]=ip[10];
        op[16]=ip[11]; op[17]=ip[12]; op[18]=ip[11]; op[19]=ip[12]; op[20]=ip[13]; op[21]=ip[14]; op[22]=ip[15]; op[23]=ip[16];
        op[24]=ip[15]; op[25]=ip[16]; op[26]=ip[17]; op[27]=ip[18]; op[28]=ip[19]; op[29]=ip[20]; op[30]=ip[19]; op[31]=ip[20];
        op[32]=ip[21]; op[33]=ip[22]; op[34]=ip[23]; op[35]=ip[24]; op[36]=ip[23]; op[37]=ip[24]; op[38]=ip[25]; op[39]=ip[26];
        op[40]=ip[27]; op[41]=ip[28]; op[42]=ip[27]; op[43]=ip[28]; op[44]=ip[29]; op[45]=ip[30]; op[46]=ip[31]; op[47]=ip[0];

        return op;
    }

    public int[] permutitionFunc(int[] ip){
        int[] op=new int[32];

        op[0]=ip[15];  op[1]=ip[7];   op[2]=ip[19];  op[3]=ip[20];  op[4]=ip[28];  op[5]=ip[11];  op[6]=ip[27];  op[7]=ip[16];
        op[8]=ip[0];   op[9]=ip[14];  op[10]=ip[22]; op[11]=ip[25]; op[12]=ip[4];  op[13]=ip[17]; op[14]=ip[30]; op[15]=ip[9];
        op[16]=ip[1];  op[17]=ip[7];  op[18]=ip[23]; op[19]=ip[13]; op[20]=ip[31]; op[21]=ip[26]; op[22]=ip[2];  op[23]=ip[8];
        op[24]=ip[18]; op[25]=ip[12]; op[26]=ip[29]; op[27]=ip[5];  op[28]=ip[21]; op[29]=ip[10]; op[30]=ip[3];  op[31]=ip[24];

        return op;
    }

    public int[] XOR(int[] pt,int[] key){
        int[] op=new int[pt.length];
        for (int i=0;i<pt.length;i++){
            op[i]=pt[i]^key[i];
        }
        return op;
    }

    public int[] SBox(int[] ip){
        KeyGen keyGen=new KeyGen();
        int[] op=new int[32];
        int[] s1={ip[0],ip[1],ip[2],ip[3],ip[4],ip[5]};
        int[] s2={ip[6],ip[7],ip[8],ip[9],ip[10],ip[11]};
        int[] s3={ip[12],ip[13],ip[14],ip[15],ip[16],ip[17]};
        int[] s4={ip[18],ip[19],ip[20],ip[21],ip[22],ip[23]};
        int[] s5={ip[24],ip[25],ip[26],ip[27],ip[28],ip[29]};
        int[] s6={ip[30],ip[31],ip[32],ip[33],ip[34],ip[35]};
        int[] s7={ip[36],ip[37],ip[38],ip[39],ip[40],ip[41]};
        int[] s8={ip[42],ip[43],ip[44],ip[45],ip[46],ip[47]};

        int[] a1=S(s1,S1);
        Make(a1,op,0);
        int[] a2=S(s2,S2);
        Make(a2,op,4);
        int[] a3=S(s3,S3);
        Make(a3,op,8);
        int[] a4=S(s4,S4);
        Make(a4,op,12);
        int[] a5=S(s5,S5);
        Make(a5,op,16);
        int[] a6=S(s6,S6);
        Make(a6,op,20);
        int[] a7=S(s7,S7);
        Make(a7,op,24);
        int[] a8=S(s8,S8);
        Make(a8,op,28);

        int[] pf=permutitionFunc(op);
        int[] Left=keyGen.Right(Ptext);
        op=XOR(pf,Left);
        return op;
    }

    public int[] S(int[] ip,int[][] S){
        int[] op;
        int row=0,col=0,num;

        if (ip[0]==0){
            if (ip[5]==0){
                row=0;
            }
            else if (ip[5]==1){
                row=1;
            }
        }else if (ip[0]==1){
            if (ip[5]==0){
                row=2;
            }else if (ip[5]==1){
                row=3;
            }
        }

        if (ip[1]==1)
            col=col+8;
        if (ip[2]==1)
            col=col+4;
        if (ip[3]==1)
            col=col+2;
        if (ip[4]==1)
            col=col+1;

        num=S[row][col];
        op=decToBin(num);
        return op;
    }

    public int[] Make(int[] ip,int[] op,int i){
        for (int j=0;j<4;j++,i++){
            op[i]=ip[j];
        }
        return op;
    }

    public int[] decToBin(int num){
        int[] op=new int[4];
        int i=3;
        while (num>0){
            op[i]=num%2;
            num=num/2;
            i--;
        }
        return op;
    }
}