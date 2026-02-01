import javax.swing.*;
import java.awt.*;

// Задание 1 - окно с текстом и иконкой
public class Task1 {
    public static void main(String[] args) {
        // создаем окно
        JFrame frame = new JFrame();
        frame.setTitle("Задание 1");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ставим окно по центру экрана
        frame.setLocationRelativeTo(null);

        // создаем иконку для окна
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());

        // создаем текст
        JLabel label = new JLabel("Группа ВТиПО 242(2)");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(JLabel.CENTER);

        // добавляем текст в окно
        frame.add(label);

        // показываем окно
        frame.setVisible(true);
    }
}
