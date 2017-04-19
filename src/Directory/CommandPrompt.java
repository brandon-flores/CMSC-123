package Directory;

import java.util.Scanner;

/**
 * Created by brandon on 12/9/2016.
 */
public class CommandPrompt {
    public static void main(String[] args) {
        Tree main = new Tree();
        boolean status = true;
        Scanner sc = new Scanner(System.in);
        if(args.length < 1){
            while(status){
                //main.printLoc();
                System.out.print("> ");
                String s = sc.nextLine();
                String[] input = s.split(" ", 2);
                //if(s.contains(" ")){ input[0] = s.substring(0, s.indexOf(" "));}
                if(input[0].equals("mkdir")){
                    if(input.length < 2) System.out.println("Use mkdir <directory name>");
                    else{
                        if(input[1].length() == 0) System.out.println("Use mkdir <directory name>");
                        else main.insert(input[1],1);
                    }
                }else
                if(input[0].equals("rmdir")){
                    if(input.length < 2) System.out.println("Use mkdir <directory name>");
                    else {
                        if(input[1].length() == 0) System.out.println("Use mkdir <directory name>");
                        else main.remove(input[1], false);
                    }
                }else
                if(input[0].equals("cd")){
                    if(input.length < 2) System.out.println("Use cd <directory name> or cd .. to move one directory higher");
                    else {
                        if(input[1].length() == 0) System.out.println("Use cd <directory name> or cd .. to move one directory higher");
                        else main.changeCurrent(input[1]);
                    }
                }else
                if(input[0].equals("edit")){
                    if(input.length < 2) System.out.println("Use edit <filename>");
                    else {
                        if(input[1].length() == 0)System.out.println("Use edit <filename>");
                        else main.edit(input[1]);
                    }
                }else
                if(input[0].equals("mv")){
                    if(input.length < 2) System.out.println("Use mv <filename> <location>");
                    else{
                        if(input[1].length() == 0) System.out.println("Use rn <filename> <new filename>");
                        else{
                            String[] str = input[1].split(" ", 2);
                            main.move(str[0], str[1]);
                        }
                    }
                }else
                if(input[0].equals("rm")){
                    if(input.length < 2) System.out.println("Use rm <filename> or ls + '*' and file extension");
                    else{
                        if(input[1].length() == 0) System.out.println("Use rm <filename> or ls + '*' and file extension");
                        else{
                            if(input[1].charAt(0) == '*')
                                main.remove(input[1].substring(1));
                            else{
                                main.remove(input[1], true);
                            }
                        }
                    }
                }else
                if(input[0].equals("rn")){
                    if(input.length < 2) System.out.println("Use rn <filename> <new filename>");
                    else{
                        if(input[1].length() == 0) System.out.println("Use rn <filename> <new filename>");
                        else{
                            String[] str = input[1].split(" ", 2);
                            main.rename(str[0], str[1]);
                        }
                    }
                }else
                if(input[0].equals("cp")){
                    if(input.length < 2) System.out.println("Use cp <filename> <new filename>");
                    else{
                        if(input[1].length() == 0) System.out.println("Use cp <filename> <new filename>");
                        else{
                            String[] str = input[1].split(" ", 2);
                            main.copy(str[0], str[1]);
                        }
                    }
                }else
                if(input[0].equals("ls")){
                    if(input.length < 2) main.list();
                    else{
                        if(input[1].length() == 0) System.out.println("Use ls or ls + '*' and file extension ");
                        else{
                            if(input[1].charAt(0) == '*')
                                main.list(input[1].substring(1));
                            else{
                                System.out.println("Use ls or ls + '*' and file extension ");
                            }
                        }
                    }
                }else
                if(input[0].equals("show")){
                    if(input.length < 2) System.out.println("Use show <filename> ");
                    else{
                        if(input[1].length() == 0) System.out.println("Use show <filename> ");
                        else main.show(input[1]);
                    }
                }else
                if(input[0].equals("whereis")){
                    if(input.length < 2) System.out.println("Use whereis <filename> ");
                    else{
                        if(input[1].length() == 0) System.out.println("Use whereis <filename> ");
                        else main.whereis(input[1]);
                    }
                }
                else{
                    System.out.println("Invalid command!");
                }
            }
        }
    }
}
