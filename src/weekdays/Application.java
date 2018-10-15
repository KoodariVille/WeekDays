/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekdays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Collections;

/**
 *
 * @author User
 */
public class Application {
    
    public void ColumnCheck(int[][] matrix){
        int max = 0;
        ArrayList<Integer> check = new ArrayList<Integer>();
        int total = 0;
        String tulos = "";
        int column;
        //boolean checkpoint = false;
        
        //while(checkpoint == false){
            for(int i = 0; i < 14; i++){
                for(int j = 0; j < 10; j++){
                    total += IntStream.of(matrix[j][i]).sum();
                }
                check.add(total);
//                if(total > 4){
//                    matrix = RowCheck(i, matrix);
//                    checkpoint = false;
//                }else{
//                    checkpoint = true;
//                }
                total = 0;
            }
        //}
        max = Collections.max(check);
        if(max > 2){
           matrix = Solve(max, matrix); 
        }      
//        System.out.println(check);
//        for(int k = 0; k < check.size(); k++){
//            System.out.print(" " + (check.get(k)-2));
//        }
//        System.out.println();
//        System.out.println(max);
//        System.out.println(min);
        for(int pr = 0; pr < matrix.length; pr ++){
            System.out.println(Arrays.toString(matrix[pr]));
        }
    }
    
//    public int[][] RowCheck(int column, int[][] matrix){
//        int total = 0;
//        for(int i = 0; i < 10; i++){
//            for(int j = 0; j < 14; j++){
//                total += IntStream.of(matrix[i][j]).sum();
//            }
//            if(total > 4){
//                matrix[i][column] = 0;               
//            }
//        }
//        return matrix;
//    }
    
    public int[][] Solve(int max, int[][] matrix){
        int total = 0;
        for(int i = 0; i < 14; i++){
                for(int j = 0; j < 10; j++){
                    total += IntStream.of(matrix[j][i]).sum();
                }
                if(total == max){
                    total = 0;
                    for(int k = 0; k < 10; k++){
                        for(int l = 0; l < 14; l++){
                            total += IntStream.of(matrix[k][l]).sum();
                        }
                        if(total > 4){
                            matrix[k][i] = 0;
                            break;
                        }
                    }
                    break;
                }
                total = 0;
            }
        
        return matrix;
    }
}
