#include<stdio.h>
#include<string.h>
int main()
{
	char str[1000];
	int i,n,k,j=0;

	printf("Enter a PLANE TEXT\n");
	gets(str);
	printf("Enter a Key\n");
	scanf("%d",&k);
	n=strlen(str);

	while(j<n)
	{
		str[j]=toupper(str[j]);
		j++;
	}

	for(i=0;str[i]!='\0';i++)
	{
		str[i]=str[i]+k;
		if(str[i]>90)
		{
			str[i]=str[i]-26;
		}
	}
	puts(str);
	return 0;
} 