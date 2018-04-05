#include<stdio.h>
#include<string.h>
#include<stdbool.h>

char RemoveFun(char key1[],char key[]);
char RemoveJ(char alp[]);
char Caps(char key1[]);
int PlayFair(char A,char B,char mat[5][5]);

int main()
{
	int i,j,l=0,m,n;
	char ch='A',key1[40],key[40]={0},pt[1000],pt1[1000],alp[25],mat[5][5];

	printf("Enter a key\n");
	gets(key1);
	Caps(key1);
	RemoveJ(key1);
	RemoveFun(key1,key);
	//Creating Matrix
	for(i=0;i<26;i++)
	{
		alp[i]=ch;
		ch++;
	}
	RemoveJ(alp);
	strcpy(key1,alp);
	RemoveFun(key1,alp);
	strcpy(key1,key);
	i=0;
	j=strlen(key1);
	while(alp[i]!='\0')
	{
		key1[j]=alp[i];
		i++;
		j++;
	}
	RemoveFun(key1,alp);	

	int k=0;
	char X;
	for(i=0;i<5;i++)
	{
		for(j=0;j<5;j++)
		{
			X=alp[k];
			mat[i][j]=X;
			k++;
		}
	}
	printf("Matrix is:\n");
	for(i=0;i<5;i++)
	{
		for(j=0;j<5;j++)
		{
			printf("%c\t",mat[i][j]);
		}
		printf("\n");
	}
	//Matrix complete

	printf("Enter a cipher text\n");
	gets(pt);
	printf("Q is used as Subtitution\n");
	printf("Plain text is \n");
	for(i=0;i<strlen(pt);i++)
	{
		PlayFair(pt[i],pt[i+1],mat);
		i++;
	}
	printf("\n");

	return 0;
}

char RemoveFun(char key1[],char key[])
{
	int f=strlen(key1);
	int i,j,k=0,count=0;
	for(i=0;i<f;i++)
	{
		for(j=0;j<i;j++)
		{
			if(key1[i]==key[j])
			{
				count=1;
			}
		}
		if(count==0)
		{
			key[k++]=key1[i];
		}
		count=0;
	}
	return key;
}

char RemoveJ(char alp[])
{
	for(int i=0;alp[i]!='\0';i++)
	{
		if(alp[i]=='J')
		{
			alp[i]='I';
		}
	}
	return alp;
}

char Caps(char key1[])
{
	for(int i=0;i<strlen(key1);i++)
	{
		key1[i]=toupper(key1[i]);
	}
	return key1;
}

int PlayFair(char A,char B,char mat[5][5])
{
	int w,x,y,z;
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			if(A==mat[i][j])
			{
				w=i;
				x=j;
			}
			else if(B==mat[i][j])
			{
				y=i;
				z=j;
			}
		}
	}
	if(w==y)
	{
		x=(x+4)%5;
		z=(z+4)%5;
		printf("%c%c",mat[w][x],mat[y][z]);
	}
	else if(x==z)
	{
		w=(w+4)%5;
		y=(y+4)%5;
		printf("%c%c",mat[w][x],mat[y][z]);
	}
	else
	{
		printf("%c%c",mat[w][z],mat[y][x]);
	}
	return 0;
}
