## 문제
One of the most time-saving operations when drawing on a computer (for example using Photoshop) is the “bucket fill”  operation. 
<p align="center"><img src = "https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15240/1.gif"><img src = "https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15240/2.png"> <img src = "https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15240/3.png"></p>


When you select this tool and click on a (target) pixel of the image it will fill all the pixels that have the same color than the target pixel and are connected to it. Two pixels are connected if they share a side or if they are connected through a path of connected pixels.

Let’s see an example: In the following image, if we select the “fill” operation in an image editor program and click on the center of the image (orange pixel). The whole region will be painted orange. Notice that the pixels are not connected diagonally so two corners of the image remain white.

 

Your task is: Given a matrix of digits representing the pixels, simulated what would be the result of a “fill” operation on given pixels. Thus, the colors will be represented with a number from 0 to 9.

Let’s see another example, now using digits instead of pixels. We have the following image:
```java 
0000000
0111000
0111010
0000000
```
If we “fill” at position Y = 0, X = 0 with color 3, all the 0s get painted of color 3. Because all of them are recursively connected.

The result will be:

```java
3333333
3111333
3111313
3333333
```

## 입력
The first line will contain two integers R and C representing the number of rows and columns of the image.

The next R lines will contain C digits each representing the initial colors of the pixels.

The last line will contain 3 integers Y, X and K representing the row and column where we want to apply the “fill” operation and the color to use.

The images will be smaller than 1000 x 1000 pixels.

The colors are limited to a single digit from 0 to 9.

## 출력
Print the resulting image after applying the operation in the same format as the input.

## 풀이 
 - 일반적인 완전탐색 문제
 - dfs로 풀면 시간 초과가 난다.(dfs가 bfs보다 느리긴하지만 다른 사람들은 dfs로 풀어도 초과가 나지 않음..)
   - dfs로도 시간 초과가 나지 않는 풀이가 있었다. 오히려 시간이 더 빨랐음
   - 아마 기존의 내 방식에선 Pair next = new Pair(..)로 객체를 계속 생성하는 방식에서 시간 초과가 난 듯하다.
     - 시간이 더 걸리긴 했지만(2배 차이) 시간 초과가 나지는 않았다.
 - System.out.println() 과 bw.write()의 속도차이가 있을 줄 알았는데 오히려 System.out.println()이 더 빠르게 나왔다
 - 자바로는 시간 초과가 났던 풀이가 c로는 통과가 된다.
 - for 구문 용 변수 i에 메모리 할당이 진행되고 이로 인해 gc 타임에 영향을 주기는 한다. (하지만 시간 복잡도에는 영향이 없으므로 이러한 경우 때문에 시간 초과가 나면 문제나 플랫폼 결함이라고 함)

