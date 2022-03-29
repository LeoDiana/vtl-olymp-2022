#include <bits/stdc++.h>

using namespace std;

vector <int> side;
vector <vector<int>> mas;

bool is_b=true;

void dbs(int j){//position in side[]
    
    for (int i = 0; i < mas[j].size(); ++i){
        
        int k = mas[j][i];

        if (side[k] == 0){
            
            if(side[j]==1) side[k]=2;
            else side[k]=1;
            
            dbs(k);
            
        }
        
        else if (side[j] == side[k])
            is_b=false;
    }
}

int main(){
    
    int n, m;
    cin >> n >> m;

    side.resize(n, 0);
    mas.resize(n);

    for (int i = 0; i < m; ++i){
        int x, y;
        cin >> x >> y;

        mas[x-1].push_back(y-1);
        mas[y-1].push_back(x-1);
    }

    for (int i = 0; i < n; ++i){
        
        if ( side[i] == 0 ){
            
            side[i] = 1;
            dbs(i);
            
        }
    }

    if(is_b==false) cout<< "NO";
    else cout << "YES";
    return 0;
}
