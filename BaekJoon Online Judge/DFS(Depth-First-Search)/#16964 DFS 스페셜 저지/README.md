# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/13.svg" class="solvedac-tier"> [DFS 스페셜 저지](https://www.acmicpc.net/problem/16964) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|55253367|dongdong99|맞았습니다!! |102600KB|852ms|Java 11|2249B|

## 문제
<p>BOJ에서 정답이 여러가지인 경우에는 스페셜 저지를 사용한다. 스페셜 저지는 유저가 출력한 답을 검증하는 코드를 통해서 정답 유무를 결정하는 방식이다. 오늘은 스페셜 저지 코드를 하나 만들어보려고 한다.</p>

<p>정점의 개수가 N이고, 정점에 1부터 N까지 번호가 매겨져있는 양방향 그래프가 있을 때, DFS 알고리즘은 다음과 같은 형태로 이루어져 있다.</p>

<pre class="brush:c++; toolbar:false;">void dfs(int x) {
    if (check[x] == true) {
        return;
    }
    check[x] = true;
    // x를 방문
    for (int y : x와 인접한 정점) {
        if (check[y] == false) {
            dfs(y);
        }
    }
}
</pre>

<p>이 문제에서 시작 정점은 1이기 때문에 가장 처음에 호출하는 함수는 <code>dfs(1)</code>이다. DFS 방문 순서는 <code>dfs</code>함수에서 <code>// x를 방문</code> 이라고 적힌 곳에 도착한 정점 번호를 순서대로 나열한 것이다.</p>

<p>트리가 주어졌을 때, 올바른 DFS 방문 순서인지 구해보자.</p>

## 입력
<p>첫째 줄에 정점의 수 N(2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에는 트리의 간선 정보가 주어진다. 마지막 줄에는 DFS 방문 순서가 주어진다. DFS 방문 순서는 항상 N개의 정수로 이루어져 있으며, 1부터 N까지 자연수가 한 번씩 등장한다.</p>

## 출력
<p>입력으로 주어진 DFS 방문 순서가 올바른 순서면 1, 아니면 0을 출력한다.</p>

