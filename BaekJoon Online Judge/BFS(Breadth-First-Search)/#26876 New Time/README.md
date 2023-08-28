# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/7.svg" class="solvedac-tier"> [New Time](https://www.acmicpc.net/problem/26876) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|65752798|dongdong99|맞았습니다!! |21424KB|144ms|Kotlin (JVM)|880B|

## 문제
<p>Nikolay has a digital clock that displays time in 24-hour format, showing two integers: hours (from $00$ to $23$) and minutes (from $00$ to $59$). For example, the clock can show <code>00:00</code>, <code>18:42</code>, or <code>23:59</code>.</p>

<p>The clock has two buttons that can be used for manual adjustment:</p>

<ul>
	<li>Button A sets the clock forward by $1$ minute. For example, <code>05:33</code> becomes <code>05:34</code>, <code>16:59</code> becomes <code>17:00</code>, and <code>23:59</code> becomes <code>00:00</code>.</li>
	<li>Button B sets the clock forward by $1$ hour. For example, <code>01:42</code> becomes <code>02:42</code>, and <code>23:14</code> becomes <code>00:14</code>.</li>
</ul>

<p>Nikolay has noticed that the time on his clock does not look right. He wants to adjust the clock to the correct time by pressing the buttons as few times as possible.</p>

<p>Find the smallest number of button presses needed to adjust the clock.</p>

## 입력
<p>The first line contains the time shown on the clock in the <code>hh:mm</code> format ($00 \le \mathtt{hh} \le 23$; $00 \le \mathtt{mm} \le 59$).</p>

<p>The second line contains the correct time in the same format.</p>

## 출력
<p>Print a single integer --- the smallest number of button presses Nikolay needs to adjust the time on his clock.</p>

