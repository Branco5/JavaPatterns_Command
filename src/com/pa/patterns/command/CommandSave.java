/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.command;

import java.io.FileWriter;
import java.io.IOException;
//nivel 3

/**
 *
 * @author patricia.macedo
 */

/**
 * Concrete Command
 * Save the contens of the message in a file
 */
public class CommandSave extends CommandMessage {

    private String filename;
    

    public CommandSave(String filename, Message msg) {
        super(msg);
        this.filename =filename;
      
    }

    @Override
    public void execute() {
       msg.writeToFile(filename);
   
    }


    @Override
    public String toString() {
        return "CommandSave{" +
                "filename='" + filename + '\'' +
                '}';
    }
}
