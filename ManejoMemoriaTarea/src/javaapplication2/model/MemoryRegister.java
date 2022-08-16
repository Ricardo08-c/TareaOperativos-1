/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2.model;

import java.util.Optional;

/**
 *
 * @author ricardosoto
 */
public class MemoryRegister implements Register{
    private Integer operator;
    private Integer value;
    private Integer address;
    public MemoryRegister(Integer operator,Integer value, Integer address){
        this.address = address;
        this.operator = operator;
        this.value = value;
    }
    
    

    public Integer getOperator() {
        return operator;
    }
    public Integer getAdress() {
        return this.address;
    }
    @Override
    public Integer getValue() {
        return this.value;
    }
    
    @Override
    public void setValue(Integer value){
        this.value = value;
        
    }
    
    @Override
    public String toString(){
        String ms = "";
        ms = ms + this.operator.toString() + "\n";
        ms = ms + this.address.toString() + "\n";
        ms = ms + this.value.toString() + "\n";
        
        return ms;
    }
  
    
}
