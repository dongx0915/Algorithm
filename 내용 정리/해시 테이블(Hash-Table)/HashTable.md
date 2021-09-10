# 해시 테이블(Hash Table)
<hr>

- [자바 HashMap 사용법](https://coding-factory.tistory.com/556)

## 해시 테이블의 구조
 - ***Func(key) -> HashCode -> Index -> Value***
 - 검색하고자하는 **Key** 값을 입력 받음
 - 해시 함수에 **Key** 값을 전달하여 얻은 **HashCode**를 테이블의 **Index**로 이용함
 - 여기서 사용하는 **Key** 값은 문자열이 될 수도 있고, 숫자나 파일 데이터 등이 될 수도 있음

## 해시 테이블의 특징
 - 입력 받은 **Key** 값에 대해서 **Key** 값이 얼마나 큰 지에 상관없이 동일한 **HashCode**를 반환함
 - **Hash Code**가 동일한 경우 혹은 **Hash Code**는 다르지만 **환산 된 Index**가 같은 경우 ***충돌(Collision)***이 발생함
   - 해시 테이블의 검색 속도는 O(1)이지만 충돌이 발생할 경우 최악의 경우 O(n)까지 갈 수 있음 

## 해시 테이블의 핵심
 - 같은 **Index**에 들어간다고해서 **Key** 값 or **HashCode**가 같은 것은 아니다. (환산하는 과정에서 같은 값이 나온 것일 뿐임)
 - **Index**는 같지만 **Key** 값은 다른 경우 **List**에 추가되어 저장된다. (검색할 땐 **List**를 돌면서 **Key** 값으로 데이터를 찾는다.)
 - 같은 **Index**에 같은 **Key** 값이 있으면 값이 **대체(Update)** 된다.

## 충돌(Collision)
 - **해시 테이블**에서 **같은 공간에 여러 데이터**가 들어가게 되는 것을 ***충돌(Collision)***이라고 한다.
 - **충돌**이 일어나는 경우
   1. **Key** 값은 다르지만 **Hash Code**가 같은 경우
        - (**Key** 값은 **문자열** 등으로 **무한한 경우의 수**가 존재하는 반면에 **Index**는 **정수**로 제한되므로 **Key** 값이 달라도 같은 **Hash Code**가 나올 수 있음)
   2. **Hash Code**는 다르지만 **환산된 Index**가 같은 경우


 
## 해시 함수 예시
 - getHashCode(Key)
  ```java
  
      k      e      y       -> 문자열의 문자 각각을 아스키 코드로 변환함
    ASCII  ASCII  ASCII   = HashCode
    
  ex) key = sung
  s(115) + u(117) + n(110) + g(103) = 445(HashCode)
  ```
 - ConvertToIndex(HashCode)
 ```java
   List<Data>[] table = new List[N] //고정된 배열(테이블) 선언(배열의 각 칸은 리스트로 이루어짐)
   index = HashCode % size    //해시 코드를 배열의 size로 나눈 나머지를 인덱스로 이용
   //충돌이 발생하면 리스트에 추가함
   //인덱스에 접근해서 리스트를 돌면서 원하는 데이터를 찾는 방식
 ```
  
