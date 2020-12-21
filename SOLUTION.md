1.

```java
public class MessageCommandCodify extends MessageCommand {

    public MessageCommandCodify(Message msg) {
        super(msg);
    }

    @Override
    public void execute() {
        char[] oldC={'a','i','e'};
        char[] newC={'?','$','£'};
        msg.codify(oldC,newC);
    }

   
    @Override
    public String toString() {
        return "MessageCommandCodify{}";    }
}


``` 
Na classe Message, acrescentar
```java
   public void codify(char[] oldC, char[] newC) {
        for(int i=0; i< oldC.length;i++)
        {
            txt=txt.replace(oldC[i],newC[i]);
        }

        notifyObservers(this);

    }    
```           
 
3.  Acrescente na classe Command o método void unExecute().
      
ComammandCodify
```java

 @Override
     public void unExecute() {
         char[] newC={'a','i','e'};
         char[] oldC={'?','$','£'};
         msg.codify(oldC,newC);
     }
``` 
CommandFormmat
```java

    @Override
      public void unExecute() {
          int size= msg.getTxt().length();
          msg.setTxt(msg.getTxt().substring(5,5+size-10));
      }
``` 

CommandsManager
```java
   
       public void undo() {
           Command cmd= commandsDone.pop();
           cmd.unExecute();
   
       }
``` 






 
 
4. 

classe CommandsManager - //adicionar e inicializar
```java
   
       private final ArrayList<Command> commandsSaved; 
  ```      
        
  classe CommandsManager 
  
  ```java
 
       public void stopMacro() {
           saving = false;
       }
       public void playMacro() {
           stopMacro();
           for (Command cmd : commandsSaved) {
               cmd.execute();
   
           }
       }
   
       public void newMacro() {
           System.out.println("NEW MACRO");
           commandsSaved.clear();
           saving = true;
       }
   
        public void executeSaveCmd(Command cmd) {
             if(saving)
              commandsSaved.add(cmd);
       }
  
``` 
Na classe UserInterface adicionar nas opções Codify,Format,Export a invocaçação do comando.
 ```java
                case "2":
                    cmdManager.executeCmd(new CommandFormat(msg));
                    System.out.println(msg);
                    break;
                case "3":
                    c = new CommandCodify(msg);
                    cmdManager.executeCmd(c);
                    cmdManager.executeSaveCmd(c);
                    break;
                case "4":
                    System.out.println("Exporting....");
                    c = new CommandSave(FILENAME_OUT, msg);
                    cmdManager.executeCmd(c);
                    cmdManager.executeSaveCmd(c);
                    System.out.println(msg);
                    break;

``` 

5.  Implemente a operação de Undo também para o comando CommandNew

```java

public class CommandNew extends Command {

    public String text;
    public String oldtext;

    public CommandNew(Message msg,String text)
    {
        super(msg);
        this.oldtext="";
        this.text=text;
    }


    @Override
    public void execute() {
        this.oldtext=msg.getTxt();
        msg.setTxt(text);
        msg.setDate();

    }

    @Override
    public void unExecute() {
        msg.setTxt(oldtext);
    }

    @Override
    public String toString() {
        return "CommandNew{}" + msg;
    }
}
``` 
 
     