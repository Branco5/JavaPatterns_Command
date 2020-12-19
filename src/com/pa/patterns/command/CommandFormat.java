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
 * Format the message
 */

public class CommandFormat extends Command {

    public CommandFormat(Message msg) {
        super(msg);
    }

    @Override
    public void execute() {
        msg.setTxt("-----" + msg.getTxt() + "-----");
        msg.setDate();
    }

     @Override
    public String toString() {
        return "CommandFormat{}" + msg;
    }
}
