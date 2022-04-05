import java.util.*;
import java.io.*;

public class Main{ 
    static class Light{
        int position;
        int red;
        int green;
        public Light(int position, int red, int green)
        {
            this.position = position;
            this.red = red;
            this.green = green;
        }
    }
    
    public static void main(String[] args) throws IOException { 

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());

        // 길 배열
        Light[] lights = new Light[n+1];
        
        
        // 입력
        for(int i=0; i<n; i++)
        {
            stk = new StringTokenizer(bfr.readLine());
            int pos = Integer.parseInt(stk.nextToken());
            int red = Integer.parseInt(stk.nextToken());
            int green = Integer.parseInt(stk.nextToken());
            lights[i] = new Light(pos, red, green);
        }

        int time = 0;
        for(int i =0; i<n; i++)
        {
            // 다음 신호등으로 이동
            if(i==0)
            {
                time += lights[i].position;
            }
            else
            {     
                time += (lights[i].position - lights[i-1].position);
            }

            // ★★★
            // 현재 신호등 위치에서 신호등 색
            int state = time % (lights[i].red + lights[i].green);

            // 빨간불에 걸렸을 경우
            if(state <= lights[i].red)
            {
                time += (lights[i].red - state);
            }

            // 더이상 신호등 없을 때
            if(i == (n-1))
            {
                time += (l - lights[i].position);
            }
        }

        // 출력 
        bfw.write(String.valueOf(time));
        bfw.close();
    } 
}
