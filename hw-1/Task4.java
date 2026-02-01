import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Задание 4 - ввод текста и числа
public class Task4 {
    public static void main(String[] args) {
        // создаем окно
        JFrame frame = new JFrame();
        frame.setTitle("Задание 4");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // label и поле для текста
        JLabel labelText = new JLabel("Введите текст:");
        labelText.setBounds(30, 20, 120, 25);
        JTextField textField = new JTextField();
        textField.setBounds(150, 20, 150, 25);

        // label и поле для числа
        JLabel labelNumber = new JLabel("Введите число:");
        labelNumber.setBounds(30, 60, 120, 25);
        JTextField numberField = new JTextField();
        numberField.setBounds(150, 60, 150, 25);

        // кнопка
        JButton button = new JButton("Показать");
        button.setBounds(100, 100, 120, 30);

        // label для вывода результата
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(30, 140, 280, 60);

        // обработчик кнопки
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                String number = numberField.getText();

                // выводим результат
                resultLabel.setText("<html>Текст: " + text + "<br>Число: " + number + "</html>");
            }
        });

        // добавляем все в окно
        frame.add(labelText);
        frame.add(textField);
        frame.add(labelNumber);
        frame.add(numberField);
        frame.add(button);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
