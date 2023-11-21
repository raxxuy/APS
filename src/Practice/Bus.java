package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        int min = M >= N ? M * 100 : N * 100;
        int max = (M == 0 || N == 0) ? min : (M + N - 1) * 100;

        System.out.println(min);
        System.out.println(max);
    }
}