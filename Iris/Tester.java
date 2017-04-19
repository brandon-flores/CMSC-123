import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) throws FileNotFoundException {
        GeneralTree gt = new GeneralTree();
    PrintStream ps = new PrintStream(new FileOutputStream(new File("mp3.out")));
    PrintStream ps_console = System.out;
        Scanner sc = new Scanner(new File("mp3.in"));
        Scanner scan = new Scanner(System.in);
        if(args.length < 1){
            while(sc.hasNextLine()){
            	System.setOut(ps);
                String s = sc.nextLine();
                String[] input = s.split(" ", 3);
                if(input[0].equals("mkdir") && input.length>1){
                	if(gt.search(input[1])){
                		System.out.println("mkdir: " + input[1] + ": Already exists");
                	}else{
                		 gt.insert(input[1],1);
                	} 
                }
                if(input[0].equals(">")){
                	if(gt.search(input[1])){
                		System.out.println(">: " + input[1] + ": Already exists");
                	}else{
                        System.setOut(ps_console);
                		 gt.insert(input[1],2);
                		 System.out.println("Enter file data: ");
                		 gt.edit(input[1],scan.nextLine());
                		 System.setOut(ps);
                	} 
                }
                if(input[0].equals("show")){
                	gt.show(input[1]);
                }
                if(input[0].equals("rn")&&input.length>2){
                	gt.rename(input[1],input[2]);
                }
                if(input[0].equals("cp")&&input.length>2){
                	gt.copy(input[1],input[2]);
                }
                if(input[0].equals("cd")){
                    gt.changeCurrent(input[1]);
                }
                if(input[0].equals("edit")){
                    System.setOut(ps_console);
                    gt.show(input[1]);
                    gt.edit(input[1],scan.nextLine());
                    System.setOut(ps);
                }

                if(input[0].equals("ls")){
                    gt.list();
                }
                if(input[0].equals("rm")){
                	gt.delete(input[1]);
                }
            }
        }
    }
}
