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

## 문제 풀면서 알게된 것들
 ### ConcurrentModificationException
 
```java
  for (Integer next : beads[root].lightbeads_) {
      beads[next].heavybeads_.addAll(beads[root].lightbeads_);
      dfs(next);
      beads[root].lightbeads_.addAll(beads[next].heavybeads_);   <- 반복문의 기준인 beads[root].lightbeads_의 원소가 바뀌게 된다.
                                                                     따라서, Enhanced for 문의 반복 횟수가 계속 바뀌게 되므로 ConcurrentModificationException이 발생한다.
  }                                                                     
```

 ### 배열 역순 정렬(Arrays.sort())
  - 배열을 내림차순으로 정렬할 때는 Collections 클래스의 reverseOrder() 함수를 사용하면 됨. 
  - 만약 기본 타입 배열을 내림차순으로 정렬하고 싶다면 기본 타입의 배열을 래퍼클래스로 만들어 Comparator를 두번째 인자에 넣어주어야 역순으로 정렬할 수 있음.
    
    ***String은 기본 타입이 아님***
   
```java
   Integer arr[] = {4,23,33,15,17,19};
   Arrays.sort(arr,Collections.reverseOrder());
 ```

 ### 자바 EOF 처리
  - Scanner의 경우는 hasNext(), hashNextLine() 메소드를 이용한다.
  ```java
    Scanner sc = new Scanner(System.in); 
    
    while(sc.hasNextLine()) { sc.nextLine(); } 
    while(sc.hasNext()) { sc.next(); }
  ```
  
  - BufferedReader의 경우에는 EOF를 처리할 수 있는 내장 메소드가 없다.
  ```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    String input = ""; 
    
    // 1 
    while((input = br.readLine()) != null) { ... } 
    
    // 2
    while((input = br.readLine()) != null && !input.isEmpty()) { ... } 
    
    // 3 
    while(!(input = br.readLine()).equals("")) { ... }
  ```
  
  - 1번 코드는 백준 사이트처럼 입력 자체가 파일로 들어온다면 EOF를 정상적으로 처리가능하다. 하지만 IDE에서는 입력의 끝을 알 수 없다. (EOF를 찾지 못해 프로그램이 끝나지 않는다.)
  - 2번 코드는 1번 코드의 문제를 보완할 수 있다. 입력의 끝에 Enter를 한 번 더 입력하면 그 입력을 EOF로 판별하여 처리한다.
  - 3번 코드는 역으로 IDE에서는 Enter로 EOF를 찾을 수 있지만, 백준 사이트처럼 입력 자체가 파일이라면 RuntimeError가 뜬다. (읽을 라인이 없는데 읽은 후, equals()를 수행하기 때문이다.)

  **백준에서는 1, 2번 방법 둘 다 사용가능하다. Netbeans에서는 2번 방법을 이용하면 된다.**

--
