#include<stdio.h>
#include<string.h>

char Case(char str[]);
int Vigenere(char K,char P);

int main()
{
	int i=0,j,l,m,n;
	char k[30],pt[1000];
	printf("Enter a key\n");
	gets(k);
	Case(k);
	printf("Enter a cipher text\n");
	gets(pt);
	Case(pt);
	n=strlen(k);
	l=strlen(pt);
	printf("Cipher text is\n");
	for(i;i<l;i++)
	{
		j=i%n;
		Vigenere(k[j],pt[i]);
	}
	printf("\n");
	return 0;
}

char Case(char str[])
{
	for(int i=0;i<strlen(str);i++)
	{
		str[i]=toupper(str[i]);
	}
	return str;
}

int Vigenere(char K,char P)
{
	int D=K%64;
	char C=P-D;
	if(C<65)
	{
		C=C+26;
	}
	printf("%c",C);
	return 0;
}
