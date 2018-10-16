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
    private int max = 0;
    private int min = 0;
    
    public int ColumnMax(int[][] matrix){
        int total = 0;
        int column = 0;
        
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 10; j++){
                total += IntStream.of(matrix[j][i]).sum();
            }
            if(total >= max){
                max = total;
                column = i;
            }
            total = 0;
        }
        return column;
    }
    
    public int ColumnMin(int[][] matrix){
        min = 5;
        int total = 0;
        int column = 0;
        
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 10; j++){
                total += IntStream.of(matrix[j][i]).sum();
            }
            if(total <= min){
                min = total;
                column = i;
            }
            total = 0;
        }
        return column;
    }
    
    public int[][] ColumnMove(int[][] matrix, int column1, int column2){
        for(int i = 0; i < 10; i++){
            //int i = randomNum(0, 9);
            if(matrix[i][column1] == 1){
                matrix[i][column1] = 0;
                matrix[i][column2] = 1;
                break;
            }
        }
        return matrix;
    }
    
    public void Solve(int[][] matrix){
        int maxColumn = 0;
        int minColumn = 0;
        int turns = 0;
        int check = ColumnCheck(matrix);
        
        while(check > 2){
            maxColumn = ColumnMax(matrix);
            minColumn = ColumnMin(matrix);
        
            matrix = ColumnMove(matrix, maxColumn, minColumn);
            check = ColumnCheck(matrix);
            turns += 1;
            System.out.println(turns);
            if(turns > 100){
                break;
            }
        }
            
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));          
        }
    }
    
    public int ColumnCheck(int[][] matrix){
        int total = 0;
        List list = new ArrayList();
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 10; j++){
                total += IntStream.of(matrix[j][i]).sum();
            }
            list.add(total);
        }
        return (int) Collections.max(list);
    }
//    public int[][] RowDays(int [][] matrix){
//        int total = 0;
//        for(int i = 0; i < 10; i++){
//                for(int j = 0; j < 14; j++){
//                    total += IntStream.of(matrix[i][j]).sum();
//                }
//                if(total < 4){
//                    
//                    break;
//                }
//                
//        return matrix;
//    }
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
    
//    public int[][] Solve(int max, int[][] matrix){
//        int total = 0;
//        for(int i = 0; i < 14; i++){
//                for(int j = 0; j < 10; j++){
//                    total += IntStream.of(matrix[j][i]).sum();
//                }
//                if(total == max){
//                    total = 0;
//                    for(int k = 0; k < 10; k++){
//                        for(int l = 0; l < 14; l++){
//                            total += IntStream.of(matrix[k][l]).sum();
//                        }
//                        if(total > 4){
//                            matrix[k][i] = 0;
//                            break;
//                        }
//                    }
//                    break;
//                }
//                total = 0;
//            }
//        
//        return matrix;
//    }
}
