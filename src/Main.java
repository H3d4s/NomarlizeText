import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main
{
    public static void main(String[] args)
    {
        BufferedReader br = null;
        try
        {
            Manager manager = new Manager(); // Tạo một instance của lớp Manager
            int countLine = manager.countLine(); // Gọi phương thức từ thể hiện của Manager
            int count = 1;
            br = new BufferedReader(new FileReader(new File("input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
            String line;
            //write until end file
            while ((line = br.readLine()) != null)
            {
                //check line empty
                if (manager.isLineEmpty(line))
                {
                    continue;
                }
                line = manager.formatOneSpace(line);
                line = manager.formatSpecialCharacters(line);
                line = manager.afterDotUpperCase(line);
                line = manager.noSpaceQuotes(line);
                line = manager.firstUpercase(line);
                line = manager.lastAddDot(line);
                pw.print(line);
                if (count < countLine)
                {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
