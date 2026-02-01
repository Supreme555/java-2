import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Задание 3 - перемещение окна кнопками
public class Task3 {
    public static void main(String[] args) {
        // создаем окно
        JFrame frame = new JFrame();
        frame.setTitle("Задание 3");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); // используем абсолютное позиционирование

        // на сколько пикселей двигать окно
        int step = 50;

        // создаем кнопки
        JButton btnUp = new JButton("Вверх");
        JButton btnDown = new JButton("Вниз");
        JButton btnLeft = new JButton("Влево");
        JButton btnRight = new JButton("Вправо");

        // устанавливаем позиции кнопок (x, y, ширина, высота)
        btnUp.setBounds(100, 20, 100, 30);
        btnDown.setBounds(100, 120, 100, 30);
        btnLeft.setBounds(10, 70, 100, 30);
        btnRight.setBounds(190, 70, 100, 30);

        // обработчик для кнопки Вверх
        btnUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = frame.getX();
                int y = frame.getY();
                frame.setLocation(x, y - step);
            }
        });

        // обработчик для кнопки Вниз
        btnDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = frame.getX();
                int y = frame.getY();
                frame.setLocation(x, y + step);
            }
        });

        // обработчик для кнопки Влево
        btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = frame.getX();
                int y = frame.getY();
                frame.setLocation(x - step, y);
            }
        });

        // обработчик для кнопки Вправо
        btnRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = frame.getX();
                int y = frame.getY();
                frame.setLocation(x + step, y);
            }
        });

        // добавляем кнопки в окно
        frame.add(btnUp);
        frame.add(btnDown);
        frame.add(btnLeft);
        frame.add(btnRight);

        frame.setVisible(true);
    }
}
