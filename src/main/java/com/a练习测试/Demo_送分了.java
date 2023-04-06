package com.a练习测试;

import java.io.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/4 19:19
 */
public class Demo_送分了 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s;

        while (!(s = br.readLine()).equals("0 0")) {   int count = 0;
            String[] split = s.split(" ");
            int s1 = Integer.parseInt(split[0]);
            int s2 = Integer.parseInt(split[1]);
            for (int i = s1; i <=s2 ; i++) {
                int c=i;
                while (c!=0){
                    if (c%100==38||c%10==4){
                        count++;
                        break;
                    }
                    c=c/10;
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }
}
