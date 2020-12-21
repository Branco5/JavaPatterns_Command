/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.patterns.command;

import com.pa.patterns.observer.Subject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * @author patricia.macedo
 * Receiver a Message contains the text of the message and a date of the input text
 */
public class Message extends Subject {

    private String txt;
    private Date date;

    public Message(String txt) {
        this.txt = txt;
        date = new Date();
    }

    public void setDate() {
        this.date = new Date();
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
        notifyObservers(this);
    }

    public Date getDate() {
        return date;
    }

    public void clear() {
        txt = " ";
    }


    @Override
    public String toString() {
        return "Message{" + "txt=" + txt + ", date=" + date + '}';
    }


    public void writeToFile(String filename) {

        FileWriter fw = null;
        try {
            fw = new FileWriter(filename, true);
            fw.write(toString()+"\n");
            fw.close();
        } catch (IOException ex) {
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {

            }
        }
    }
}
