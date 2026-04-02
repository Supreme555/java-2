import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println(
                "Пожалуйста, передайте параметры, например:");
            System.out.println(
                "java FileCopy source.txt destination.txt");
            System.exit(0);
        }

        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        try {
            fileIn = new FileInputStream(args[0]);
            fileOut = new FileOutputStream(args[1]);

            while (true) {
                int byteValue = fileIn.read();
                if (byteValue == -1) {
                    break;
                }
                fileOut.write(byteValue);
            }

            System.out.println("Файл " + args[0] +
                " скопирован в " + args[1]);

        } catch (IOException e) {
            System.out.println(
                "Ошибка при копировании файла: " + e.toString());
        } finally {
            try {
                fileIn.close();
                fileOut.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
