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
