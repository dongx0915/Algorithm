# <img src="https://d2gd6pc034wcta.cloudfront.net/tier/12.svg" class="solvedac-tier" width=20> [Cow Contest](https://www.acmicpc.net/problem/6156)

## 문제
N (1 <= N <= 100) cows, conveniently numbered 1..N, are participating in a programming contest. As we all know, some cows code better than others. Each cow has a certain constant skill rating that is unique among the competitors.

The contest is conducted in several head-to-head rounds, each between two cows. If cow A has a greater skill level than cow B (1 <= A <= N; 1 <= B <= N; A != B), then cow A will always beat cow B.

Farmer John is trying to rank the cows by skill level. Given a list the results of M (1 <= M <= 4,500) two-cow rounds, determine the number of cows whose ranks can be precisely determined from the results. It is guaranteed that the results of the rounds will not be contradictory.

## 입력
- Line 1: Two space-separated integers: N and M
- Lines 2..M+1: Each line contains two space-separated integers that describe the competitors and results (the first integer, A, is the winner) of a single round of competition: A and B

## 출력
- Line 1: A single integer representing the number of cows whose ranks can be determined

## 풀이
 - 각 소마다 자신보다 쎈 소 + 자신보다 약한 소가 N - 1마리가 되면 순위를 결정할 수 있다.
 - 소의 관계를 그래프로 나타내어 플로이드 와샬을 수행한다.
 - [i][k] && [k][j] 이면 [i][j]도 true 로 셋팅해준다. (i가 k보다 쎄고, k가 j보다 쎄면 i는 j보다 쎄다)
 
