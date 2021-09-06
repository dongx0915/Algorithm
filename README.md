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

 # 배열 역순 정렬(Arrays.sort())
 
 ```java
   배열을 내림차순으로 정렬할 때는 Collections 클래스의 reverseOrder() 함수를 사용하면 됨. 
   만약 기본 타입 배열을 내림차순으로 정렬하고 싶다면 기본 타입의 배열을 래퍼클래스로 만들어 Comparator를 두번째 인자에 넣어주어야 역순으로 정렬할 수 있음.
   ※ String은 기본 타입이 아님
   
   Integer arr[] = {4,23,33,15,17,19};
   Arrays.sort(arr,Collections.reverseOrder());
 ```
