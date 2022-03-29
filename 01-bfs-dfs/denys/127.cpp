#include <bits/stdc++.h>

using namespace std;

int main()
{
    
    int n;
    cin >> n;
    int mas[n][n];
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j< n; j++) {
            cin >> mas[i][j];
        }
    }
    
    int str,fin;
    cin >> str >> fin;
    str--; fin--;
    
    if(str==fin) {
        cout << 0;
        return 0;
    }
    
    queue<int> q;
    q.push(str);
    
    int merge[n];
    for (int i = 0; i < n; i++) 
        merge[i]=-1;
    
    merge[str]=0;

    
    while(!q.empty()){
        for (int i = 0; i < n; i++) {
            if(mas[q.front()][i]==1 and merge[i]==-1){
                q.push(i);
                merge[i]=merge[q.front()]+1;
                if(i==fin){
                    cout << merge[i];
                    return 0;
                }
            }
        }
        q.pop();
    }
    
    cout << -1;
    
    
    

    return 0;
}
