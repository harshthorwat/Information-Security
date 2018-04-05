#include<stdio.h>
#include<string.h>
int main()
{
	char str[1000];
	int i,n,k;

	printf("Enter a CIPHER TEXT\n");
	gets(str);
	printf("Enter a Key\n");
	scanf("%d",&k);
	n=strlen(str);

	for(i = 0; str[i] != '\0'; i++)
	{
		str[i]=str[i]-k;
		if(str[i]<65)
		{
			str[i]=str[i]+26;
		}
	}
	puts(str);
	return 0;
} 

