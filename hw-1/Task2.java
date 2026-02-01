import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Задание 2 - кнопка с сообщением
public class Task2 {
    public static void main(String[] args) {
        // создаем окно
        JFrame frame = new JFrame();
        frame.setTitle("Задание 2");
        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        // создаем кнопку
        JButton button = new JButton("Нажми меня");

        // создаем label для вывода текста
        JLabel label = new JLabel("");

        // добавляем обработчик нажатия на кнопку
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // выводим сообщение через диалоговое окно
                JOptionPane.showMessageDialog(frame, "Привет! Ты нажал на кнопку!");

                // также выводим в label
                label.setText("Кнопка была нажата!");
            }
        });

        // добавляем кнопку и label в окно
        frame.add(button);
        frame.add(label);

        frame.setVisible(true);
    }
}
