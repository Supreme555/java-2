import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OrderWindow implements ActionListener {

    JFrame frame;
    JComboBox<String> comboModel;
    JTextField txtQuantity;
    JButton btnOrder;
    JTextField txtConfirmation;

    OrderWindow() {
        JPanel windowContent = new JPanel();
        windowContent.setLayout(new GridLayout(4, 2, 5, 5));

        // Модель велосипеда — выпадающий список
        JLabel lblModel = new JLabel("Модель велосипеда:");
        String[] models = {"FireBird", "Thunderbolt", "SpeedRacer"};
        comboModel = new JComboBox<>(models);

        // Количество
        JLabel lblQuantity = new JLabel("Количество:");
        txtQuantity = new JTextField(10);

        // Кнопка
        btnOrder = new JButton("Разместить заказ");
        btnOrder.addActionListener(this);

        // Поле подтверждения
        JLabel lblStatus = new JLabel("Статус:");
        txtConfirmation = new JTextField(20);
        txtConfirmation.setEditable(false);

        // Добавляем компоненты на панель
        windowContent.add(lblModel);
        windowContent.add(comboModel);
        windowContent.add(lblQuantity);
        windowContent.add(txtQuantity);
        windowContent.add(new JLabel()); // пустая ячейка
        windowContent.add(btnOrder);
        windowContent.add(lblStatus);
        windowContent.add(txtConfirmation);

        // Создаём фрейм
        frame = new JFrame("Заказ велосипедов");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Обработка нажатия кнопки
    public void actionPerformed(ActionEvent e) {
        String selectedModel = (String) comboModel.getSelectedItem();
        String selectedQuantity = txtQuantity.getText();

        int quantity;

        // Обработка NumberFormatException
        try {
            quantity = Integer.parseInt(selectedQuantity);
        } catch (NumberFormatException ex) {
            JOptionPane.showConfirmDialog(null,
                "Пожалуйста, введите число",
                "Неправильный ввод",
                JOptionPane.PLAIN_MESSAGE);
            return;
        }

        // Обработка TooManyBikesException
        try {
            checkOrder(selectedModel, quantity);
            txtConfirmation.setText("Заказ размещён успешно");
        } catch (TooManyBikesException ex) {
            txtConfirmation.setText(ex.getMessage());
        }
    }

    // Проверка заказа — лимиты по моделям
    void checkOrder(String bikeModel, int quantity)
            throws TooManyBikesException {

        int maxQuantity;

        switch (bikeModel) {
            case "FireBird":
                maxQuantity = 3;
                break;
            case "Thunderbolt":
                maxQuantity = 5;
                break;
            case "SpeedRacer":
                maxQuantity = 2;
                break;
            default:
                maxQuantity = 1;
        }

        if (quantity > maxQuantity) {
            throw new TooManyBikesException(
                "Невозможно доставить " + quantity +
                " велосипедов модели " + bikeModel +
                " за одну доставку (макс: " + maxQuantity + ")");
        }
    }

    public static void main(String[] args) {
        new OrderWindow();
    }
}
