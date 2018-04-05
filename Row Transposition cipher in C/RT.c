#include<stdio.h>
#include<string.h>
int Sep(int key);                      //Count the length of key.
char Rt(char p[],int c,int j);
int main()
{
	char p[1000];
	int l,m,c,k,o,q,z;
	printf("Enter a plain text\n");
	gets(p);
	z=strlen(p);
	printf("Enter a key\n");
	scanf("%d",&k);
	l=k;
	c=Sep(l);
	q=z%c;
	if(q>0)                             //Add 'Q' if the matrix is not formed.
	{
		while(q>0)
		{
			p[z]='Q';
			q--;
			z++;
		}
		p[z]='\0';
	}
	int d[c];                        //Array of key digits.
	int j=c;
	for(j;j>0;j--)                   //Separate all digits in the key.
	{
		o=l%10;
		d[j]=o;
		l=l/10;
	}
	int n=1;
	char s1[50],s2[1000];
	while(n<=c)
	{
		for(j=1;j<=c;j++)
		{
			if(d[j]==n)
			{
				Rt(p,c,j);
			}
		}
		n++;
	}
	printf("\n");
	return 0;
}
int Sep(int key)
{
	int c=0;
	int j;
	while(key!=0)
	{
		j=key%10;
		key=key/10;
		c++;
	}
	return c;
}
char Rt(char p[],int c,int j)
{
	char q[50];
	int i=0;
	int k=strlen(p);
	j=j-1;
	while(j<k)
	{
		q[i]=p[j];
		i++;
		j=j+c;
	}
	printf("%s",q);
	return q;
}

