import java.util.*;
import java.io.*;


public class Main{

    static class Light{
        int r;
        int g;
        public Light(int r, int g){
            this.r = r;
            this.g = g;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        // 신호등 확인 배열(길을 일일이 나눔)
        Light[] load = new Light[l+1];  

        // 입력
        for(int i=0; i<n; i++)
        {
            //한번에 받음
            String[] in_data = in.readLine().split(" ");

            // 나눠서 가져가
            int d = Integer.parseInt(in_data[0]);
            int r = Integer.parseInt(in_data[1]);
            int g = Integer.parseInt(in_data[2]);

            load[d] = new Light(r, g);
        }

        int time = 0;

        // 길 하나씩 확인
        for(int i=1;i<=l;i++)
        {
            time++; // 시간 증가

            // 다음 위치에 신호등 확인
            if(load[i] != null)
            {
                int state = time % (load[i].r + load[i].g);

                if(state <= load[i].r)
                {
                    time += (load[i].r - state);
                }
            }
        }


        System.out.printf("%d", time);
    }
}