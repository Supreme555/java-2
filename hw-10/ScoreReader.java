import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ScoreReader {
    public static void main(String[] args) {

        FileReader myFile = null;
        BufferedReader buff = null;

        try {
            myFile = new FileReader("scores.txt");
            buff = new BufferedReader(myFile);

            while (true) {
                String line = buff.readLine();
                if (line == null) break;
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                buff.close();
                myFile.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
