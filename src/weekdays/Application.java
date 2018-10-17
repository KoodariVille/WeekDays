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
        List<Integer> list = new ArrayList();
        int max = 0;
        int total = 0;
        int column = 0;
        
        for(int i = 0; i < 14; i++){
            total += ColumnSum(matrix,i);
            if(i == 5 || i == 6 ||i == 12 || i == 13){
                list.add(total - 5);
                if(list.get(i) >= max){
                    max = list.get(i);
                    column = i;
                }
            }else{
                list.add(total - 2);
                if(list.get(i) >= max){
                    max = list.get(i);
                    column = i;
                }
            }
            total = 0;
        }
        
//        System.out.println("max " + column);
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
//        System.out.println("min " + column);
        return column;
    }
    
    public int ColumnMin(int[][] matrix, int iMin){
        List<Integer> list = new ArrayList();
        List<Integer> list2 = new ArrayList();
        int total = 0;
        int min = matrix[0][0];
        
        for(int i = 0; i < 14; i++){
            total += ColumnSum(matrix,i);
            if(i == 5 || i == 6 ||i == 12 || i == 13){
                list.add(total - 5);
                if(list.get(i) <= min){
                    min = list.get(i);
                    list2.add(i);
                }
            }else{
                list.add(total - 2);
                if(list.get(i) <= min){
                    min = list.get(i);
                    list2.add(i);
                }
            }
            total = 0;
        }
        int e = list2.get(list2.size() - iMin);
//        System.out.println("min2 " + 3);
        return e;
    }
    
    public int ColumnSum(int[][] matrix, int column){
        int sum = 0;
        
        for(int i = 0; i < 10; i++){
            sum += IntStream.of(matrix[i][column]).sum();
        }

        return sum;
    }
       
    public int[][] MoveV(int cMax, int cMin, int[][] matrix){
        for(int i = 0; i < 10; i++){
            if(matrix[i][cMax] == 1){
                matrix[i][cMax] = 0;
                if(matrix[i][cMin] == 0){
                    matrix[i][cMin] = 1;
                }else{
                    for(int j = 2; j <= 4; j++){
                        cMin = ColumnMin(matrix,j);
                        if(matrix[i][cMin] == 0){
                            matrix[i][cMin] = 1;
                            break;
                        }
                    }
                }
                break;
            }
        }
           
        return matrix;
    }
    
    public void Solve(int[][] matrix){
        int vSum = VacSum(matrix);
        int MaxColumn, MinColumn;
                       
        while(vSum != 0){
            MaxColumn = ColumnMax(matrix);
            MinColumn= ColumnMin(matrix);
            matrix = MoveV(MaxColumn, MinColumn, matrix);
            vSum = VacSum(matrix);

        }
        System.out.println();
        for (int[] matrix1 : matrix) {
            System.out.println(Arrays.toString(matrix1));          
        }
    }
     
    public int VacSum(int[][] matrix){
        List<Integer> list = new ArrayList();
        int total = 0;
        int min = matrix[0][0];
        
        for(int i = 0; i < 14; i++){
            total += ColumnSum(matrix,i);
            if(i == 5 || i == 6 ||i == 12 || i == 13){
                list.add(total - 5);
                if(list.get(i) <= min){
                    min = list.get(i);
                }
            }else{
                list.add(total - 2);
                if(list.get(i) <= min){
                    min = list.get(i);
                }
            }
            total = 0;
        }
        return min;
    }
}
