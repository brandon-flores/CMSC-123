package GneralsDaughter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by brandon on 12/14/2016.
 */
public class CommandPrompt {
    public static void main(String[] args) throws FileNotFoundException {
        Tree main = new Tree();
        boolean status = true, file = false;
        PrintStream ps = new PrintStream(new FileOutputStream(new File("mp4.out")));
        PrintStream ps_console = System.out;
        Scanner scan = null;
        Scanner sc = new Scanner(System.in);
        if(args.length > 0){
            file = true;
            scan = new Scanner(new File("D:\\School\\CMSC\\CMSC 123\\MP\\src\\GneralsDaughter\\" + args[0]));
        }
            while(status){
                String[] input;
                if(!file){
                    System.setOut(ps_console);
                    System.out.print("> ");
                    String s = sc.nextLine();
                    input = s.split(" ", 2);
                }else{
                    System.setOut(ps);
                    try{
                        String s = scan.nextLine();
                        input = s.split(" ", 2);
                    }catch (NoSuchElementException e){
                        break;
                    }
                }
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
                if(input[0].equals(">")){
                    if(input.length < 2) System.out.println("Use > <filename>");
                    else{
                        main.overwrite(input[1]);
                        Node temp = main.edit(input[1]);
                        String readString;
                        Scanner scans;
                        if(!file){
                            System.setOut(ps_console);
                            readString = sc.nextLine();
                            scans = sc;
                        }else{
                            System.setOut(ps);
                            readString = scan.nextLine();
                            scans = scan;
                        }
                        while(readString != null) {
                            temp.addString(readString);
                            if (readString.isEmpty()) {
                                readString = null;
                            }
                            else{
                                if (scans.hasNextLine()) {
                                    readString = scans.nextLine();
                                } else {
                                    readString = null;
                                }
                            }
                        }
                        temp.getDescriptor().setMod(new Date());
                    }
                }else
                if(input[0].equals(">>")){
                    if(input.length < 2) System.out.println("Use >> <filename>");
                    else{
                        main.edit(input[1]);
                        Node temp = main.edit(input[1]);
                        String readString;
                        Scanner scans;
                        if(!file){
                            System.setOut(ps_console);
                            readString = sc.nextLine();
                            scans = sc;
                        }else{
                            System.setOut(ps);
                            readString = scan.nextLine();
                            scans = scan;
                        }
                        while(readString != null) {
                            temp.addString(readString);
                            if (readString.isEmpty()) {
                                readString = null;
                            }
                            else{
                                if (scans.hasNextLine()) {
                                    readString = scans.nextLine();
                                } else {
                                    readString = null;
                                }
                            }
                        }
                        temp.getDescriptor().setMod(new Date());
                    }
                }else
                if(input[0].equals("edit")){
                    if(input.length < 2) System.out.println("Use edit <filename>");
                    else {
                        if(input[1].length() == 0)System.out.println("Use edit <filename>");
                        else {
                            Node temp = main.edit(input[1]);
                            String readString;
                            Scanner scans;
                            if(!file){
                                System.setOut(ps_console);
                                readString = sc.nextLine();
                                scans = sc;
                            }else{
                                System.setOut(ps);
                                readString = scan.nextLine();
                                scans = scan;
                            }
                            while(readString != null) {
                                temp.addString(readString);
                                if (readString.isEmpty()) {
                                    readString = null;
                                }
                                else{
                                    if (scans.hasNextLine()) {
                                        readString = scans.nextLine();
                                    } else {
                                        readString = null;
                                    }
                                }
                            }
                            temp.getDescriptor().setMod(new Date());
                        }
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
