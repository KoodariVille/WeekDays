/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekdays;

import java.util.List;

/**
 *
 * @author User
 */
public class Cell {
    private int x,y;
    private int value;
    List<Cell> graph;
    
    public Cell(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
    
    public Cell(){}
    
    public int GetValue(){
        return value;
    }
    
    public void SetValue(int value){
        this.value = value;
    }
    
    
    public String toString(){
        return ""+value;
    }
}
