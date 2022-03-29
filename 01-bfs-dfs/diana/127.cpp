#include<bits/stdc++.h>

using namespace std;

const int MAX_N = 101;
const int UNREACHABLE = -1;

int main()
{
    int n, start, end;
    int adj_matrix[MAX_N][MAX_N];
   
    cin>>n;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            cin>>adj_matrix[i][j];
    cin>>start>>end;
    start--;
    end--;
    
    queue<int> que;
    int dist_to_node[MAX_N];
    for(int i=0;i<n;i++)
        dist_to_node[i] = UNREACHABLE;
    
    dist_to_node[start] = 0;
    que.push(start);
    while(!que.empty()){
        int curr_node = que.front();
        que.pop();
        for(int i=0;i<n;i++){
            if(adj_matrix[curr_node][i] && dist_to_node[i] == UNREACHABLE){
                dist_to_node[i] = dist_to_node[curr_node] + 1;
                que.push(i);
            }
        }
    }
        
    cout<<dist_to_node[end];
    
    
    return 0;
}
