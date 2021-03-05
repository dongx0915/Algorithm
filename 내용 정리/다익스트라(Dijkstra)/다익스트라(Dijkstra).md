
# 다익스트라(Dijkstra) 알고리즘 

- **다이나믹 프로그래밍(dp)** 을 활용한 대표적인 **최단 경로(Shortest Path) 탐색** 알고리즘
- **특정한 하나의 정점**에서 **다른 모든 정점**으로 가는 **최단 경로**를 구함 (**음의 간선**은 **포함할 수 없다.**)


### 다익스트라가 다이나믹 프로그래밍 문제인 이유 
- **최단 경로는 여러 개의 최단 거리로 이루어져있기 때문**
- 즉, **정점 i**에서 **정점 j**까지의 **최단 거리**는 **min(d(i,k)) + min(d(k,j))** 처럼 **최단 거리**를 이었을 때 **최단 경로**가 나온다.

<b>+</b> 다익스트라는 하나의 **최단 거리를 구할 때** 그 **이전에 구했던 최단 거리 정보**를 그대로 사용한다는 특징이 있다. 

### 다익스트라 과정
 1. **출발 노드** 설정
 2. **출발 노드**를 **기준**으로 각 노드의 **최소 비용**을 저장
 3. **방문하지 않은 노드** 중에서 **가장 비용이 적은 노드**를 선택
 4. **해당 노드**를 거쳐서 **특정한 노드**로 가는 경우를 고려하여 **최소 비용 갱신**
 5. 3 ~ 4번 반복


## 요약
 - **특정 노드(시작 노드)** 에서 **인접한 노드(중간 노드)** 까지의 거리를 모두 **배열에 저장**
 - **인접한 노드(중간 노드)** 중 **가장 거리가 가까운 노드**를 방문
 - **방문한 노드**의 **인접한 노드** 중 **가장 가까운 노드(목표 노드)** 를 방문
 - ***시작 노드 > 도착 노드***의 **거리**보다 ***시작 노드 > 중간 노드 > 도착 노드***의 **거리**가 작으면 ***시작 노드 > 도착 노드***의 **값을 갱신**
 - 
### 예시
<p align="center"><img src="https://user-images.githubusercontent.com/63500239/109421072-1e890780-7a19-11eb-9e5d-e0c997cc34dd.png" width="400px" height="400px"></p>

<div class="se_sectionArea se_align-left" align = "center">
            <div class="se_editArea">
                <div id="SEDOC-1526265814729--1936273098_table_0" data-attachment-id="" class="se_table_wrap">
                    <div class="se_table_innerWrap">
                        <table class="se_table_col" style="width:100%;">
                            <tbody>
                                <tr>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">0</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">2</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">5</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">1</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">2</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">0</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">3</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">2</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">5</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">3</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">0</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">3</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">1</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">5</span></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">1</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">2</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">3</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">0</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">1</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea">5<br></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">1</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">0</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">2</span></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span style="color: rgb(0, 0, 0);" class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span style="color: rgb(0, 0, 0);" class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">5</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.548042%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span style="color: rgb(0, 0, 0);" class="se_ff_nanumbarungothic">무한</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">2</span></div>
                                    </td>
                                    <td class="se_cell se_align-center" colspan="1" rowspan="1" style="width:16.725979%;height:43.0px;background-color:;">
                                        <div class="se_cellArea"><span class="se_ff_nanumbarungothic">0</span></div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
</div>


1.  **1번 노드**를 **선택**한 경우
<p align="center"><img src="https://user-images.githubusercontent.com/63500239/109421264-ee8e3400-7a19-11eb-8415-26b225ddb868.png" width="400px" height="400px"></p>

- **1번 노드**에서 **다른 정점**으로 가는 **최소 비용**을 **배열에 저장**(이 **배열**을 계속 **갱신**할 것)
- 현재 **방문하지 않은 노드** 중 **가장 적은 비용**이 드는 노드는 **4번**이므로 **4번**을 선택

2.  **1번 노드**와 **연결된 노드** 중 **가장 적은 비용**이 드는 **노드 선택**(**4번 노드**)
<p align="center"><img src="https://user-images.githubusercontent.com/63500239/109421528-1631cc00-7a1b-11eb-9e7a-1025e2a8079d.png" width="400px" height="400px"></p>

- 기존에 **1번 노드**에서 **5번 노드**로 가는 경우는 **무한(길 x)** 이었다.
- 하지만, **4번 노드**를 거쳐서 **5번 노드**로 가는 경우 **비용이 2**이므로 **최소 비용 배열을 갱신**해준다.
- 또한, **4번 노드**를 거쳐서 **3번 노드**를 가는 경우도 **비용이 4**로 기존보다 작으니 **배열을 갱신**해준다.
- 모든 갱신이 끝났으면 **1번 노드**와 **연결된 노드** 중 **비용이 가장 작은 노드**(**2번 노드**)를 **선택**한다.(**방문하지 않았어야함**)

3.  **1번 노드**와 **연결**되어있고 **방문하지 않은 노드** 중 **가장 적은 비용**이 드는 **노드 선택**(**2번 노드**)
<p align="center"><img src="https://user-images.githubusercontent.com/63500239/109421687-ad971f00-7a1b-11eb-94cf-65cff92150c1.png" width="400px" height="400px"></p>

- **1번 노드**에서 **2번 노드**를 거쳐서 다른 노드로 가도 **기존 비용보다 작아지는 경우가 없으므로 갱신 X**
- 다시 **1번 노드**와 **연결된 노드** 중 **가장 비용이 적은 노드**를 **선택**(**5번 노드**)
- **중요한 점** **1번 노드**와 **간접적으로 연결**되어있는 경우도 **포함**해야함

4.  **1번 노드**와 **연결된 노드** 중 **가장 적은 비용**이 드는 **노드 선택**(**5번 노드**)
<p align="center"><img src="https://user-images.githubusercontent.com/63500239/109421828-4fb70700-7a1c-11eb-99d4-a028fd08367c.png" width="400px" height="400px"></p>

 - **5번 노드**를 거쳐 **3번 노드**를 가는 경우 (***1 > 4 > 5 > 3***) **비용이 3**으로 기존보다 **작다**.
 - 또한, **5번 노드**를 거쳐 **6번 노드**로 가는 경우(***1 > 4 > 5> 6***)도 **비용이 4**로 기존보다 **작다**.
 - 최소 비용 배열을 갱신한다.

**위와 같은 방식**으로 **3번 노드**, **6번 노드**에 대해서도 **반복**하면 **최소 비용 배열**이 **모두 갱신**된다.



## 다익스트라를 힙(우선순위 큐)을 이용하여 구현하는 방법
 - **vortex(정점 인덱스)**, **value(특정 노드에서 현재 노드까지의 가중치)** 두 값을 저장하는 클래스를 만든다.
 - **거리를 저장할 배열 dis**와 **그래프를 표현할 인접 행렬 adj**를 만든다. **dis는 무한대로 초기화**,**adj는 주어진 그래프 정보로 초기화** 해준다.
 - **dis**는 ***시작 노드***에서 ***특정 노드***까지 가는 **거리**를 저장하는 배열(**최소 거리**를 **저장**한다.)
 - **dis[start]** 를 **0으로 셋팅**(시작 노드에서 시작 노드까지의 거리는 0)하고 **큐에 삽입**한다. ***(start, dis[start])*** 
 - 큐가 빌때까지 하나씩 노드를 꺼내어 **현재 노드의 value 값이 dis[curIndex]**(시작 노드에서 현재 노드까지의 거리)보다 **크면 패스**한다. (**이미 갱신이 된 경우**이므로)(값이 같다면 갱신이 안된 경우일 수도 있으므로 continue해선 안된다.)
 - ***현재 노드***에서 ***인접한 노드***들을 차례대로 **방문**한다.
 - ***시작 노드***에서 ***도착 노드***까지 **바로가는 거리**와 ***인접한 노드***를 **거쳐서 가는 거리**를 **비교**하여 **작은 값**으로 **갱신**한다. **(dis에 해당 거리를 넣어주고 q에 갱신된 값으로 삽입해준다.)**
 - **선형 탐색**으로 **다익스트라를 구현**할 때에는 **가장 가까운 거리의 노드부터 방문**하도록 구현했는데, **힙**을 이용하여 **구현할 때**에는 그냥 **차례대로 인접 노드를 방문** 하게 되어있다.
 - 그 이유는 이미 **힙 안에서 거리 순으로 정렬**이 되어있기 때문이다. (***현재 노드***에서 ***인접한 노드***들 까지의 **거리**를 구하고 **큐에 넣으면 가까운 순으로 정렬**이 됨)



## 참고할만한 링크
 - http://www.secmem.org/blog/2019/01/09/wrong-dijkstra/
