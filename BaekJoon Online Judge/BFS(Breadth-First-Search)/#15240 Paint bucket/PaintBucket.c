#include <stdio.h>

typedef struct Pair{
    int x_;
    int y_;
} Pair;

int R,C;
int dx[] = {-1, 0, 1, 0};
int dy[] = { 0,-1, 0, 1};
char image[1000][1000];

void dfs(Pair point, char origin_color, char color){
    image[point.x_][point.y_] = color;

    for (int i = 0; i < 4; i++) {
        Pair next;
        next.x_ = point.x_ + dx[i];
        next.y_ = point.y_ + dy[i];
        
        if(next.x_ < 0 || next.y_ < 0 || next.x_ >= R || next.y_ >= C || image[next.x_][next.y_] != origin_color) continue;
            
        dfs(next, origin_color, color);
    }
}

int main()
{
    scanf("%d %d", &R, &C);
    
    char buffer;
    scanf("%c", &buffer);
    
    for(int i = 0; i < R; i++) scanf("%s", image[i]);
    
    Pair point;
    char color;
    scanf("%d %d %c", &point.x_, &point.y_, &color);
    
    dfs(point, image[point.x_][point.y_], color);
    
    for(int i = 0; i < R; i++) printf("%s\n", image[i]);
    
    return 0;
}
