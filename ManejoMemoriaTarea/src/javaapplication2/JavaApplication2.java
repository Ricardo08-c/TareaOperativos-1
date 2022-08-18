/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import java.util.Random;
import javaapplication2.contoller.CPUController;

/**
 *
 * @author ricardosoto
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CPUController cpu = new CPUController();
        String pa = "/Users/ricardosoto/Downloads/asm1/asm1.asm";
        cpu.setCPUMemory(pa, 100);
        int cantinstrucciones = 7; 
        for(int i = 0 ; i < cantinstrucciones; i ++){
         cpu.executeInstruction();   
        }
        
        
         

               
        
        
       
            
    }
    
}
