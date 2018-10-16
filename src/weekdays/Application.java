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
    public int ColumnMax(int[][] matrix){
        int max = 0;
        int total = 0;
        int column = 0;
        
        for(int i = 0; i < 14; i++){
            total += ColumnSum(matrix,i);
            if(total > max){
                max = total;
                column = i;
            }
            total = 0;
        }
        
        System.out.println("max" + column);
        return column;
    }
    
    public int ColumnMin(int[][] matrix){
        List<Integer> list = new ArrayList();
        int total = 0;
        int column = 0;
        int min = matrix[0][0];
        
        for(int i = 0; i < 14; i++){
            total += ColumnSum(matrix,i);
            if(i == 5 || i == 6 ||i == 12 || i == 13){
                list.add(total - 5);
                if(list.get(i) <= min){
                    min = list.get(i);
                    column = i;
                }
            }else{
                list.add(total - 2);
                if(list.get(i) <= min){
                    min = list.get(i);
                    column = i;
                }
            }
            total = 0;
        }
        System.out.println("min" + column);
        return column;
    }
    
    public int ColumnSum(int[][] matrix, int column){
        int sum = 0;
        
        for(int i = 0; i < 10; i++){
            sum += IntStream.of(matrix[i][column]).sum();
        }
        
        System.out.print(sum);
        return sum;
    }
       
    public int[][] MoveV(int cMax, int cMin, int[][] matrix){
        
        for(int i = 0; i < 10; i++){
            if(matrix[i][cMax] == 1){
                matrix[i][cMax] = 0;
                if(matrix[i][cMin] == 0){
                    matrix[i][cMin] = 1;
                    break;
                }else{
                    
                }
                break;
            }
        }        
        return matrix;
    }
    
    public void Solve(int[][] matrix){
        int turn = 0;
        while(true){
            int cMax = ColumnMax(matrix);
            int cMin = ColumnMin(matrix);

            matrix = MoveV(cMax, cMin, matrix);
            turn += 1;
            if(turn == 10){
                break;
            }
        }
        for (int[] matrix1 : matrix) {
            System.out.println(Arrays.toString(matrix1));          
        }
    }
}
