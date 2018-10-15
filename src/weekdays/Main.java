/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekdays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        Application a = new Application();
//        int[][] graph = new int[10][14];
//        
//        for(int i = 0; i < 14; i++){
//            for(int j = 0; j < 10; j++){
//                graph[j][i] = randomNum(0,1);
//            }
//        }
        int[][] graph = {
            {0,1,0,1,0,0,0,1,0,0,0,1,0,0},
            {0,0,1,0,1,0,0,0,0,1,0,0,1,0},
            {0,1,0,1,0,0,0,0,0,1,0,0,0,1},
            {0,0,1,0,0,0,1,0,0,1,0,0,1,0},
            {0,0,1,1,0,0,0,1,0,0,1,0,0,0},
            {1,0,0,0,1,0,0,0,1,0,1,0,0,0},
            {0,0,1,0,0,1,0,0,0,1,0,0,1,0},
            {1,0,0,0,0,0,1,1,0,0,0,1,0,0},
            {0,0,1,0,1,0,0,0,0,1,0,1,0,0},
            {0,1,0,0,0,1,0,0,0,1,0,0,0,1}
        };
        
        
//        for(int i = 0; i < graph.length; i++){
//            System.out.println(Arrays.toString(graph[i]));          
//        }
        a.ColumnCheck(graph);
    }
    
//    static int randomNum(int min, int max){
//        int range = (max - min) + 1;     
//        return (int)(Math.random() * range) + min;
//    }
}
