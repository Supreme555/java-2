import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {
    // Объявление всех компонентов калькулятора
    JPanel windowContent;
    JTextField displayField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonMultiply;
    JPanel p1;
    JPanel p2;

    // В конструкторе создаются все компоненты
    // и добавляются на фрейм с помощью комбинации
    // BorderLayout и GridLayout
    Calculator() {
        windowContent = new JPanel();

        // Задаём схему для этой панели
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

        // Создаём и отображаем поле
        // Добавляем его в Северную область окна
        displayField = new JTextField(30);
        windowContent.add("North", displayField);

        // Создаём кнопки с цифрами
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");

        // Создаём кнопки операций
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivide = new JButton("/");
        buttonMultiply = new JButton("*");

        // Создаём панель p1 с GridLayout для цифровых кнопок
        p1 = new JPanel();
        GridLayout gl = new GridLayout(4, 3);
        p1.setLayout(gl);

        // Добавляем кнопки на панель p1
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);

        // Помещаем панель p1 в центральную область окна
        windowContent.add("Center", p1);

        // Создаём панель p2 с GridLayout для кнопок операций
        p2 = new JPanel();
        GridLayout gl2 = new GridLayout(4, 1);
        p2.setLayout(gl2);

        // Добавляем кнопки операций на панель p2
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonMultiply);
        p2.add(buttonDivide);

        // Помещаем панель p2 в восточную область окна
        windowContent.add("East", p2);

        // Создаём фрейм и задаём его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);

        // Делаем размер окна достаточным для всех компонентов
        frame.pack();

        // Отображаем окно
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}
