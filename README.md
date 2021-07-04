### Algorithm
<hr>

# Baekjoon Online Judge
<hr>

## 다시 풀어봐야 할 문제들

### DFS
- [ ] 1240 : 노드사이의 거리
- [ ] 1987 : 알파벳
- [ ] 19542 : 전단지 돌리기
- [ ] 19621 : 회의실 배정 2

### BFS
- [ ] 14395 : 4연산

### Greedy
- [ ] 2347 : 저울 
- [ ] 12904 : A와 B

### DP
- [ ] 2133 : 타일 채우기
- [ ] 14852 : 타일 채우기 3

## 문제 풀면서 알게된 사실
 # ConcurrentModificationException
 
```java
  for (Integer next : beads[root].lightbeads_) {
      beads[next].heavybeads_.addAll(beads[root].lightbeads_);
      dfs(next);
      beads[root].lightbeads_.addAll(beads[next].heavybeads_);   <- 반복문의 기준인 beads[root].lightbeads_의 원소가 바뀌게 된다.
                                                                     따라서, Enhanced for 문의 반복 횟수가 계속 바뀌게 되므로 ConcurrentModificationException이 발생한다.
  }                                                                     
```
