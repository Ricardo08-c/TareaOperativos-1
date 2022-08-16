/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 *
 * @author ricardosoto
 */
public class Memory {
    int size;    
    ArrayList<Optional<MemoryRegister>> registers;
    final int START_INDEX = 10;
    
    
    public Memory(int size){
        registers = new ArrayList<>();
        for(int i = 0 ; i <size ; i ++){
            registers.add(Optional.empty());                 
        }
        this.size = size;
    }
    
    public ArrayList<Optional<MemoryRegister>> getInstructions(){
        return this.registers;
    }
    private boolean spaceFull(int startingIndex, int space){
        
        if(startingIndex + space > this.size){
            return true;   
        }
        if(this.registers.get(startingIndex).isEmpty()){
            for(int i = startingIndex ; i < space; i ++){
                if(this.registers.get(i).isPresent()){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public void clean(){
       this.registers.clear();       
    }
    
    public void allocate(ArrayList<MemoryRegister> instructions){
        //Inicia a partir del índice START_INDEX
        Random rand = new Random();
        int startAllocate = rand.nextInt(this.size);
        if(startAllocate <=this.START_INDEX) startAllocate+=this.START_INDEX;
        while(this.spaceFull(startAllocate,instructions.size())){
            startAllocate = rand.nextInt(this.size);
            if(startAllocate <=this.START_INDEX) startAllocate+=this.START_INDEX;
            
        }
        int j = 0;
                       
        for(int i = startAllocate ; i <instructions.size()+startAllocate; i ++){
            this.registers.add(i, Optional.of(instructions.get(j)));
            j++;
         }        
        
        
    }
    
    
}
