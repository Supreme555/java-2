import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Лабораторная работа №2 - Простой калькулятор
public class SimpleCalculator {
    public static void main(String[] args) {
        // создаем окно
        JFrame frame = new JFrame();
        frame.setTitle("My First Calculator");
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        // создаем метки
        JLabel label1 = new JLabel("Number 1:");
        JLabel label2 = new JLabel("Number 2:");
        JLabel label3 = new JLabel("Sum:");

        // создаем текстовые поля
        JTextField field1 = new JTextField(5);
        JTextField field2 = new JTextField(5);
        JTextField resultField = new JTextField(5);

        // создаем кнопку
        JButton addButton = new JButton("Add");

        // обработчик нажатия кнопки
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // получаем числа из полей
                int num1 = Integer.parseInt(field1.getText());
                int num2 = Integer.parseInt(field2.getText());

                // считаем сумму
                int sum = num1 + num2;

                // выводим результат
                resultField.setText(String.valueOf(sum));
            }
        });

        // добавляем все компоненты в окно
        frame.add(label1);
        frame.add(field1);
        frame.add(label2);
        frame.add(field2);
        frame.add(addButton);
        frame.add(label3);
        frame.add(resultField);

        // показываем окно
        frame.setVisible(true);
    }
}
