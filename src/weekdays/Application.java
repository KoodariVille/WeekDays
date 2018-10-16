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
        System.out.println(column);
        return column;
    }
    
    public int ColumnMin(int[][] matrix){
        List<Integer> list = new ArrayList();
        min = 5;
        int total = 0;
        int column = 0;
        
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 10; j++){
                total += IntStream.of(matrix[j][i]).sum();
            }
            if(i == 5 || i == 6 || i == 12 || i == 13){
                list.add(total - 5);
            }
            else{
                list.add(total - 2);
            }
            if(list.get(i) <= min){
                min = list.get(i);
                column = i;
            }
            total = 0;
        }
        System.out.println(column);
        return column;
    }
    
    public int ColumnSum(int[][] matrix, int column){
        int sum = 0;
        
        for(int i = 0; i < 10; i++){
            sum += IntStream.of(matrix[i][column]).sum();
        }
        System.out.println(sum);
        return sum;
    }
       
    public int[][] MoveV(int cMax, int cMin, int[][] matrix){
        int sum = ColumnSum(matrix, cMin);
        
        for(int i = 0; i < 10; i++){
            if(matrix[i][cMax] == 1){
                matrix[i][cMax] = 0;
                if((cMin == 5 || cMin ==6 || cMin == 12 || cMin == 13) && sum - 5 != 0){
                    matrix[i][cMin] = 1;
                } else if (ColumnSum(matrix, cMin) - 2 != 0 && (cMin == 0||cMin ==1||cMin ==2||cMin ==3||cMin ==4||cMin ==7||cMin ==8||cMin ==9||cMin ==10||cMin ==11)){
                    matrix[i][cMin] = 1;
                }
                break;
            }
        }
        
        return matrix;
    }
    
    public void Solve(int[][] matrix){
        int turn = 0;
        
        while(turn < 30){
            int cMax = ColumnMax(matrix);
            int cMin = ColumnMin(matrix);
        
            matrix = MoveV(cMax, cMin, matrix);
            turn += 1;
        }
        
        for (int[] matrix1 : matrix) {
            System.out.println(Arrays.toString(matrix1));          
        }
    }
}
