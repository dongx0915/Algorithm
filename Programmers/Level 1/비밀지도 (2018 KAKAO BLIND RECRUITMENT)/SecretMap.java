    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(((long) (arr1[i]) | (long) arr2[i]))));
            answer[i] = answer[i].replace('1', '#').replace('0', ' ');

        }
        return answer;
    }
