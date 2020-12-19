/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.command;

/**
 *
 * @author patricia.macedo
 */

/**
 * Concrete Command
 * Create a new information for the message
 */
public class CommandNew extends Command {

    public String text;


    public CommandNew(Message msg,String text)  {
        super(msg);
        this.text=text;
    }


    @Override
    public void execute() {
        msg.setTxt(text);
        msg.setDate();
    }

    @Override
    public String toString() {
        return "CommandNew{}" + msg;
    }
}
