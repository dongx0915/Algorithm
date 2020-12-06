#include <stdio.h>
#include <math.h>

int IsPrime(int n) {
   int i, limit;

   if (n <= 1) return 0;
   if (n == 2) return 1;
   if (n % 2 == 0) return 0;

   limit = (int)sqrt((double)n);

   for (i = 3; i <= limit; i += 2) {
      if (n%i == 0) {
         return 0;
      }
   }
   return 1;
}

int main() {
   long long test, n, m, i, prime, a[100000] = { 0 }, j = 0, k, cnt = 0, s = 0, temp = 0;
   scanf("%lld", &test);

   
   while (test--) {
      scanf("%lld %lld", &n, &m);
      if (m < n) {
         temp = n;
         n = m;
         m = temp;
      }
      for (j = 0, cnt = 0, i = n; i <= m; i++) {
         if ((i + 12) <= m) {
            if (IsPrime(i) == 1) {
               if (IsPrime(i + 6) == 1 && IsPrime(i + 12) == 1) {
                  a[j] = i;
                  j++;
                  cnt++;
               }
            }
         }
      }

      if (cnt == 0)
         printf("No Sexy Prime Triplets!\n");

      for (s = 0, k = 1; k <= cnt; k++, s++) {
         printf("%lld: %lld-%lld-%lld\n", k, a[s], a[s] + 6, a[s] + 12);
      }

   }
   return 0;
}