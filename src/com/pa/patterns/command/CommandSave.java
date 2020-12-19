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
public class CommandSave extends Command {

    private String filename;
    

    public CommandSave(String filename, Message msg) {
        super(msg);
        this.filename =filename;
      
    }

    @Override
    public void execute() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filename, true);
            fw.write(msg.toString()+"\n");
            fw.close();
        } catch (IOException ex) {
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {

            }
        }
   
    }


    @Override
    public String toString() {
        return "CommandSave{" +
                "filename='" + filename + '\'' +
                '}' + msg;
    }
}
