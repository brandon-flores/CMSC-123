import java.io.*;
import java.util.*;

/**
 * Created by brandon on 9/10/2016.
 */
public class Complexity {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\testing.txt")))
        {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
