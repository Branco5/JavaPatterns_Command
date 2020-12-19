/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.command;

import java.util.Stack;


/**
 * @author PM
 */

/**
 * Invoker
 * Manage the commands, invoke the execution of commands.
 */
public class CommandsManager {

    private static final String FILENAME_OUT = "msgoOut.txt";

    private final Stack<Command> commandsDone;

   public CommandsManager() {
        commandsDone = new Stack();
    }

    public void stopMacro() {

    }

    public void playMacro() {
    }

    public void newMacro() {

    }

    public void undo() {

    }

    public void executeCmd(Command cmd) {
            cmd.execute();
            commandsDone.push(cmd);
    }


    public String listAll() {
        String str="";
        int count=1;
        for (Command cmd : commandsDone)
        {
            str= str + (count++) + "-> " + cmd.toString() + "\n";

        }
        return str;

    }
}
