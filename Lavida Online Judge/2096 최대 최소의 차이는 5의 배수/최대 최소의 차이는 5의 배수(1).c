Lavida
FAQ
Forum
Problems
Status
Contest
Tools
20183188
Settings
Logout
Run ID	Problem	Language	Result	Time	Memory
232179	1062	C	Accepted	0.03s	1MB
source code
1
#include <stdio.h>
2
#include <math.h>
3
#include <stdlib.h>
4
​
5
int IsPrime(int n) {
6
    int i, limit;
7
​
8
    if (n <= 1) return 0;
9
    if (n == 2) return 1;
10
    if (n % 2 == 0) return 0;
11
​
12
    limit = (int)sqrt((double)n);
13
​
14
    for (i = 3; i <= limit; i += 2) {
15
        if (n%i == 0) {
16
            return 0;
17
        }
18
    }
19
    return 1;
20
}
21
​
22
int main() {
23
    int test, a, b, prime, i, cnt = 0;
24
​
25
    scanf("%d", &test);
26
​
27
    while (test--) {
28
        cnt = 0;
29
        scanf("%d %d", &a, &b);
30
        for (i = a; i <= b; i++) {
31
            prime = IsPrime(i);
32
            if (prime == 1) cnt++;
33
        }
34
        printf("%d\n", cnt);
35
    }
36
    return 0;
37
}
