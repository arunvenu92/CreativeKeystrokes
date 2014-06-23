#include<iostream>
using namespace std;
void checkDuplicate(int arr[]);
void checkDuplicate(int arr[])
{
 int count=0;
  for(int i=0;i<=9;i++)
  {
	 if(arr[i]==1) count++;
  }
  if(count!=4)
  {
    cout<<"Duplicate values"<<endl;
	_sleep(300);
	exit(0);
  }
}

int main()
{
int chooser[4];
int guesser[4];
int flag=0;
int dummy[10]={0},k;

cout<<"Enter the chooser number::"<<endl;
for(int i=0;i<=3;i++)
{
	cin>>chooser[i];
	k=chooser[i];
	dummy[k]=1;
}
checkDuplicate(dummy);

cout<<"There are 5 chances to guess the number"<<endl;
for(int i=1;i<=5;i++)
{
int bulls=0,cows=0;
int dummy1[10]={0},k1;
cout<<"Chance"<<":::"<<i<<endl;
cout<<"Guesser enter the number"<<endl;

for(int i=0;i<=3;i++)
{
	cin>>guesser[i];
	k1=guesser[i];
	dummy1[k1]=1;
}
checkDuplicate(dummy1);
/* Actual Algorithm */
for(int i=0;i<=3;i++)
{
	for(int j=0;j<=3;j++)
	{
	  if(i!=j)
	  {
		  if(chooser[i] == guesser[j])
		  {
		   cows++;
		  }
	  }
	  else
	  {
		  if(chooser[i] == guesser[j])
		  {
		   bulls++;
		   //cows++;
		  }
	  }
	}
}

if(bulls == 4)
{
 flag=1;
 cout<<"U have guessed it right!!! kudos man"<<endl; 
 _sleep(1000);
 break;
}
cout<<"Bulls"<<":::"<<bulls<<endl;
cout<<"Cows"<<":::"<<cows<<endl;
cout<<"\n";
_sleep(1000);
}
if(flag==0)
{
 cout<<"Sorry Try again"<<endl;
 cout<<"Answer is::";
 for(int i=0;i<=3;i++) cout<<chooser[i];
 _sleep(1000);
}

}