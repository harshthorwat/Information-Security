#include<stdio.h>
#include<string.h>

int Sep(int key);                   //Count the length of key
int Rt(char p[],int c,int j);

int main()
{
	char p[1000];
	int a,b,c,l,k,o,e,f,g,h;
	printf("Enter a cipher text\n");
	gets(p);
	b=strlen(p);
	printf("Enter a key\n");
	scanf("%d",&k);
	l=k;
	c=Sep(l);
	a=b/c;

	int d[c];
	int j=c;
	for(j;j>0;j--)
	{
		o=l%10;
		d[j]=o;
		l=l/10;
	}

	char st[1000];
	h=0;
	for(int i=1;i<=c;i++)
	{
		e=d[i];
		f=a*(e-1);
		g=0;
		while(g<a)
		{
			st[h]=p[f];
			g++;
			h++;
			f++;
		}
	}

	g=0;
	while(g<c-1)
	{
		Rt(st,c,g);
		g++;
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

int Rt(char p[],int c,int j)
{
	char x[50];
	int i=0;
	int k=strlen(p);
	c=c-1;
	while(j<k)
	{
		x[i]=p[j];
		i++;
		j=j+c;
	}
	printf("%s",x);
	return 0;
}
