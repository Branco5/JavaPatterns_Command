/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.command;

import com.pa.patterns.observer.Observer;

import java.util.Scanner;


/**
 * @author PM
 */
public class UserInterface implements Observer {

    private static final String FILENAME_OUT = "msgoOut.txt";
    private boolean saving;
    private final Message msg;
    private CommandsManager cmdManager;

    private final static Scanner sc = new Scanner(System.in);


    public UserInterface() {
        cmdManager = new CommandsManager();
        msg = new Message(" Esta é a primeira frase a ser alterada depois");

    }

    private void writeMenu() {
        System.out.println("\n\tMENU ");
        System.out.println("------------------");
        System.out.println("1 - NEW");
        System.out.println("2 - FORMAT");
        System.out.println("3 - CODIFY");
        System.out.println("4 - EXPORT");
        System.out.println("------------------");
        System.out.println("5 - UNDO");
        System.out.println("------------------");
        System.out.println("6 - LIST COMMANDS");
        System.out.println("------------------");
        System.out.println("7 - NEW MACRO");
        System.out.println("8 - STOP MACRO");
        System.out.println("9 - PLAY MACRO");
        System.out.println("------------------");
        System.out.println("s -sair");
        System.out.println("------------------");
        System.out.print("Introduz a opção >> ");
    }

    public void executeMenu() {
        String op = "";
        writeMenu();
        op = sc.nextLine();
        Command c;
        while (!op.equals("s")) {
            switch (op) {
                case "1":
                    System.out.print("Insert text > ");
                    String str= sc.nextLine();
                    cmdManager.executeCmd(new CommandNew(msg,str));
                    break;
                case "2":
                    cmdManager.executeCmd(new CommandFormat(msg));
                    break;
                case "3":
                    //TODO

                    break;
                case "4":
                    System.out.println("Exporting....");
                    c = new CommandSave(FILENAME_OUT, msg);
                    cmdManager.executeCmd(c);

                    break;
                case "5":
                    cmdManager.undo();
                    System.out.println(msg);
                    break;
                case "6":
                    System.out.println(cmdManager.listAll());
                    break;
                case "7":
                    cmdManager.newMacro();
                    break;
                case "8":
                    cmdManager.stopMacro();
                    break;
                case "9":
                    cmdManager.playMacro();
                    break;
                default:
                    System.out.println("Command not exist");
            }

            writeMenu();
            op = sc.next();
            sc.nextLine();
        }
    }


    @Override
    public void update(Object obj) {
        System.out.println(msg);

    }
}
