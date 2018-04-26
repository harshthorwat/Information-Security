public class KeyGen {

    private int[] Key=new int[56];

    public void setKey(int[] key){
        Key=key;
    }

    public int[] keyGen(int count){
        int[] Left=Left(Key);
        int[] Right=Right(Key);
        int[] l=circularShift(Left,LSSchedul(count));
        int[] r=circularShift(Right,LSSchedul(count));
        int[] k=Concat(l,r);
        int[] k1=PCTwo(k);
        return k1;
    }

    public int[] Decrypt(int count) {
        int[] Left = Left(Key);
        int[] Right = Right(Key);
        int[] l = circularShift(Left, LSSchedul(count));
        int[] r = circularShift(Right, LSSchedul(count));
        int[] k = Concat(l, r);
        return k;
    }

    public int[] PCOne(int[] ip){
        int[] op=new int[56];

        op[0]=ip[56];  op[1]=ip[48];  op[2]=ip[40];  op[3]=ip[32];  op[4]=ip[24];  op[5]=ip[16];  op[6]=ip[8];
        op[7]=ip[0];   op[8]=ip[57];  op[9]=ip[49];  op[10]=ip[41]; op[11]=ip[33]; op[12]=ip[25]; op[13]=ip[17];
        op[14]=ip[9];  op[15]=ip[1];  op[16]=ip[58]; op[17]=ip[50]; op[18]=ip[42]; op[19]=ip[34]; op[20]=ip[26];
        op[21]=ip[18]; op[22]=ip[10]; op[23]=ip[2];  op[24]=ip[59]; op[25]=ip[51]; op[26]=ip[43]; op[27]=ip[35];
        op[28]=ip[62]; op[29]=ip[54]; op[30]=ip[46]; op[31]=ip[38]; op[32]=ip[30]; op[33]=ip[22]; op[34]=ip[14];
        op[35]=ip[6];  op[36]=ip[61]; op[37]=ip[53]; op[38]=ip[45]; op[39]=ip[37]; op[40]=ip[29]; op[41]=ip[21];
        op[42]=ip[13]; op[43]=ip[5];  op[44]=ip[60]; op[45]=ip[52]; op[46]=ip[44]; op[47]=ip[36]; op[48]=ip[28];
        op[49]=ip[20]; op[50]=ip[12]; op[51]=ip[4];  op[52]=ip[27]; op[53]=ip[19]; op[54]=ip[11]; op[55]=ip[3];

        return op;
    }

    public int[] PCTwo(int[] ip){
        int[] op=new int[48];

        op[0]=ip[13];  op[1]=ip[16];  op[2]=ip[10];  op[3]=ip[23];  op[4]=ip[0];   op[5]=ip[4];   op[6]=ip[2];   op[7]=ip[27];
        op[8]=ip[14];  op[9]=ip[5];   op[10]=ip[20]; op[11]=ip[9];  op[12]=ip[22]; op[13]=ip[18]; op[14]=ip[11]; op[15]=ip[3];
        op[16]=ip[25]; op[17]=ip[7];  op[18]=ip[15]; op[19]=ip[6];  op[20]=ip[26]; op[21]=ip[19]; op[22]=ip[12]; op[23]=ip[1];
        op[24]=ip[40]; op[25]=ip[51]; op[26]=ip[30]; op[27]=ip[36]; op[28]=ip[46]; op[29]=ip[54]; op[30]=ip[29]; op[31]=ip[39];
        op[32]=ip[50]; op[33]=ip[44]; op[34]=ip[32]; op[35]=ip[47]; op[36]=ip[43]; op[37]=ip[48]; op[38]=ip[38]; op[39]=ip[55];
        op[40]=ip[33]; op[41]=ip[52]; op[42]=ip[45]; op[43]=ip[41]; op[44]=ip[49]; op[45]=ip[35]; op[46]=ip[28]; op[47]=ip[31];

        return op;
    }

    public int LSSchedul(int i){
        int[] sch={1,1,2,2,2,2,2,2,1,2,2,2,2,2,2,1};
        return sch[i];
    }

    public int[] circularShift(int[] ip,int by){
        int j=ip.length;
        int[] op=new int[j];

        if (by==1){
            for (int i=0;i<j-1;i++){
                op[i]=ip[i+1];
            }
            op[j-1]=ip[0];
        }
        else if (by==2){
            for (int i=0;i<j-2;i++){
                op[i]=ip[i+2];
            }
            op[j-2]=ip[0];
            op[j-1]=ip[1];
        }
        return op;
    }

    int[] Concat(int[] left,int[] right){
        int j=left.length;
        int[] op=new int[j*2];
        for (int i=0;i<j;i++){
            op[i]=left[i];
        }
        for (int i=0,k=j;i<j;i++,k++){
            op[k]=right[i];
        }
        return op;
    }

    public int[] Left(int[] ip){
        int[] left=new int[ip.length/2];
        for (int i=0;i<ip.length/2;i++){
            left[i]=ip[i];
        }
        return left;
    }

    public int[] Right(int[] ip){
        int j=ip.length/2;
        int[] right=new int[j];
        int i=0,k=j;
        while (i<j){
            right[i]=ip[k];
            k++;
            i++;
        }
        return right;
    }
}