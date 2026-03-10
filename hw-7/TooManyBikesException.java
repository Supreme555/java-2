public class TooManyBikesException extends Exception {

    // Конструктор с сообщением по умолчанию
    TooManyBikesException() {
        super("Мы не сможем доставить столько велосипедов за один раз.");
    }

    // Конструктор с пользовательским сообщением
    TooManyBikesException(String message) {
        super(message);
    }
}
