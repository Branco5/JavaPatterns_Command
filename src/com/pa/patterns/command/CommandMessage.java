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
 * Command Pattern - Command
 */
public abstract class CommandMessage implements Command{

    protected Message msg;

    public CommandMessage(Message msg) {
        this.msg = msg;
    }



}
