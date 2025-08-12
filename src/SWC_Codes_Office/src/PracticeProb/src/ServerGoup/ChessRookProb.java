/*
#include <iostream>

//using namespace std;
char data[4][4];
char data1[4][4];
int M,N;
int minimumfair = 99999;
int nTotalRooks = 0;
int nTotalRooks1 = 0;
//int Visited[100];
//int visitednodes = 0;

void ChessRook()
{	
	//check the connected nodes
	for(int i=0; i<N; i++)
		for(int j=0; j<N; j++)
		{
			

			bool bPossible = true;

			if(data[i][j] == 'X')
				continue;

			//check in the row
			for(int k=0; k<=j; k++)
			{
				if(data[i][k] == 'X')
					bPossible = true;
				else if(data[i][k] == 'O')
					bPossible = false;

			}
			//if rowwsie possible then check columnwise
			if(bPossible == true)
			{
				for(int k=0; k<=i; k++)
				{
					if(data[k][j] == 'X')
						bPossible = true;
					else if(data[k][j] == 'O')
						bPossible = false;

				}
			}

			if(bPossible == true)
			{
				data[i][j] = 'O';
				nTotalRooks++;
			}

		
		}	

		for(int i=N-1; i>=0; i--)
			for(int j=N-1; j>=0; j--)
			{

				bool bPossible = true;

				if(data1[i][j] == 'X')
					continue;
								
				//check in the row
				for(int k=N-1; k>=j; k--)
				{
					if(data1[i][k] == 'X')
						bPossible = true;
					else if(data1[i][k] == 'O')
						bPossible = false;

				}
				//if rowwsie possible then check columnwise
				if(bPossible == true)
				{
					for(int k=N-1; k>=i; k--)
					{
						if(data1[k][j] == 'X')
							bPossible = true;
						else if(data1[k][j] == 'O')
							bPossible = false;

					}
				}

				if(bPossible == true)
				{
					data1[i][j] = 'O';
					nTotalRooks1++;
				}

		
			}

			if(nTotalRooks1> nTotalRooks)
				nTotalRooks = nTotalRooks1;
}

int main(int argc, char** argv)
{
	int tc, T;
	
	int totalMinFair = 0;
    FILE* pp;
	//freopen_s(&pp,"input.txt", "r", stdin);

	cin >> T;
	for(tc = 1; tc <= T; tc++)
	{
		int i,j;
		nTotalRooks = 0;
		nTotalRooks1 = 0;
		
		cin >> N;
		
		for(i=0; i<N; i++) 
		{			
			for(j=0; j<N; j++)
			{
				cin >> data[i][j];
				data1[i][j] = data[i][j];
			}
		}
		
		ChessRook();			
		cout<<"Case #"<<tc<<endl;
		cout<<nTotalRooks<<endl;
		
	}

	return 0;//Your program should return 0 on normal termination.
}


*/
/*Case #1
5
Case #2
1
Case #3
5
Case #4
2
Case #5
4*/

