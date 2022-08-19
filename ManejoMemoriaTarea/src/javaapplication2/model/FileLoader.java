/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author ricardosoto
 */
public class FileLoader {
    String fileDirectory;
    ArrayList<MemoryRegister> instructionSet = new ArrayList<>();
    HashMap<String,Integer> instructionMapper;
    ArrayList<String> instructions;
    HashMap<String,Integer> registerMapper;
    public FileLoader(String path){       
  
        this.loadMapper();
        this.loadInstructionSet(path);
        
    }  
    
    
    // Retorna un array con las instrucciones en string: {"MOV AX, 10", "ADD BX", "MOV BX, 10"}
    // El IRController se encarga de descomponer cada instruccion
    public ArrayList<MemoryRegister> getInstrucionSet(){
        return this.instructionSet;
    }
    
    private void loadInstructionSet(String path){        
        BufferedReader reader;        
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null) {          
                if(!this.validGrammar(line)){
                    System.out.println("Error en el formato del archivo");
                    return;
                } 
                    this.instructionSet.add(processInstruction(line));
                line = reader.readLine();
            }
            
        } catch (IOException e) {
            //tirar un error en la interfaz
            e.printStackTrace();
        }
    }
    
    private void loadMapper(){
        this.instructionMapper = new HashMap<>();
        this.registerMapper = new HashMap<>();
        this.instructionMapper.put("mov", 3);
        this.instructionMapper.put("load", 1);
        this.instructionMapper.put("store", 2);
        this.instructionMapper.put("sub", 4);
        this.instructionMapper.put("add", 5);
        this.registerMapper.put("ax", 1);
        this.registerMapper.put("bx", 2);
        this.registerMapper.put("cx", 3);
        this.registerMapper.put("dx", 4);
        
    }
    private boolean validGrammar(String line){
        String[] comaSplit = line.split(",");        
        if(comaSplit.length == 2){
            
            return this.validAsignation(comaSplit);
                
        } else if(comaSplit.length == 1){
             return this.validOperation(comaSplit);
        } else {                                
            return false;
        }
        
        
    }
    
    private boolean validAsignation(String[] splitedLine){
        
        String[] asignation = splitedLine[0].split(" ");
        Integer opr = instructionMapper.get(asignation[0].toLowerCase());
        if(asignation.length <= 1){
            return false;
        }
        Integer reg = registerMapper.get(asignation[1].toLowerCase());
        try{             
            Integer.parseInt(splitedLine[1].trim());
        } catch(NumberFormatException e){            
            return false;
        }
        
        return opr !=null && reg!=null;
              
    }
    private boolean validOperation(String[] splitedLine){
         String[] asignation = splitedLine[0].split(" ");
          if(asignation.length <= 1){
            return false;
        }
        Integer opr = instructionMapper.get(asignation[0].toLowerCase());
        Integer reg = registerMapper.get(asignation[1].toLowerCase());
        
        return opr!=null && reg!=null;
        
    }
    private MemoryRegister processInstruction(String line){
        
        String[] comaSplit = line.split(",");        
        // Se asigna un valor
        
            String[] splitSpace = comaSplit[0].split(" ");
            int instruction = this.instructionMapper.get(splitSpace[0].toLowerCase());
            
            int address = this.registerMapper.get(splitSpace[1].toLowerCase());
            Integer value = 0;
            
            
            if(comaSplit.length == 2){
                value = Integer.parseInt(comaSplit[1].trim());
            }
            MemoryRegister register = new MemoryRegister(instruction, value,address);            
            
            
            return register;
            
      
        
        
               
        
    }

    public String getFileDirectory() {
        return fileDirectory;
    }
        
    
    
    
    
}

