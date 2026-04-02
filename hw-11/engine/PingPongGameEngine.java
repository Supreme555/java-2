package engine;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import screens.*;

public class PingPongGameEngine implements Runnable,
        MouseMotionListener, KeyListener, GameConstants {

    private PingPongGreenTable table;
    private int kidRacket_Y = KID_RACKET_Y_START;
    private int computerRacket_Y = COMPUTER_RACKET_Y_START;
    private int kidScore;
    private int computerScore;
    private int ballX;
    private int ballY;
    private boolean movingLeft = true;
    private boolean ballServed = false;

    // Значение вертикального передвижения мяча в пикселях
    private int verticalSlide;

    // Конструктор
    public PingPongGameEngine(PingPongGreenTable greenTable) {
        table = greenTable;
        Thread worker = new Thread(this);
        worker.start();
    }

    // Обязательные методы из интерфейса MouseMotionListener
    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        int mouse_Y = e.getY();

        if (mouse_Y < kidRacket_Y && kidRacket_Y > TABLE_TOP) {
            kidRacket_Y -= RACKET_INCREMENT;
        } else if (kidRacket_Y < TABLE_BOTTOM) {
            kidRacket_Y += RACKET_INCREMENT;
        }

        table.setKidRacket_Y(kidRacket_Y);
    }

    // Обязательные методы из интерфейса KeyListener
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        if ('n' == key || 'N' == key) {
            startNewGame();
        } else if ('q' == key || 'Q' == key) {
            endGame();
        } else if ('s' == key || 'S' == key) {
            kidServe();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void startNewGame() {
        computerScore = 0;
        kidScore = 0;
        table.setMessageText("Score Computer: 0 Kid: 0");
        kidServe();
    }

    public void endGame() {
        System.exit(0);
    }

    // Обязательный метод run() из интерфейса Runnable
    public void run() {
        boolean canBounce = false;
        while (true) {
            if (ballServed) {

                // Шаг 1. Мяч движется влево?
                if (movingLeft && ballX > BALL_MIN_X) {
                    canBounce = (ballY >= computerRacket_Y &&
                            ballY < (computerRacket_Y + RACKET_LENGTH))
                            ? true : false;
                    ballX -= BALL_INCREMENT;
                    ballY -= verticalSlide;
                    table.setBallPosition(ballX, ballY);

                    if (ballX <= COMPUTER_RACKET_X && canBounce) {
                        movingLeft = false;
                    }
                }

                // Шаг 2. Мяч движется вправо?
                if (!movingLeft && ballX <= BALL_MAX_X) {
                    canBounce = (ballY >= kidRacket_Y &&
                            ballY < (kidRacket_Y + RACKET_LENGTH))
                            ? true : false;

                    ballX += BALL_INCREMENT;
                    table.setBallPosition(ballX, ballY);

                    if (ballX >= KID_RACKET_X && canBounce) {
                        movingLeft = true;
                    }
                }

                // Шаг 3. Перемещать ракетку компьютера
                if (computerRacket_Y < ballY
                        && computerRacket_Y < TABLE_BOTTOM) {
                    computerRacket_Y += RACKET_INCREMENT;
                } else if (computerRacket_Y > TABLE_TOP) {
                    computerRacket_Y -= RACKET_INCREMENT;
                }
                table.setComputerRacket_Y(computerRacket_Y);

                // Шаг 4. Приостановить
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Шаг 5. Обновить счет
                if (isBallOnTheTable()) {
                    if (ballX > BALL_MAX_X) {
                        computerScore++;
                        displayScore();
                    } else if (ballX < BALL_MIN_X) {
                        kidScore++;
                        displayScore();
                    }
                }

            } // Конец if ballServed
        } // Конец while
    } // Конец run()

    private void kidServe() {
        ballServed = true;
        ballX = KID_RACKET_X - 1;
        ballY = kidRacket_Y;
        if (ballY > TABLE_HEIGHT / 2) {
            verticalSlide = -1;
        } else {
            verticalSlide = 1;
        }
        table.setBallPosition(ballX, ballY);
        table.setKidRacket_Y(kidRacket_Y);
    }

    private void displayScore() {
        ballServed = false;
        if (computerScore == WINNING_SCORE) {
            table.setMessageText("Computer won! " +
                    computerScore + ":" + kidScore);
        } else if (kidScore == WINNING_SCORE) {
            table.setMessageText("You won! " +
                    kidScore + ":" + computerScore);
        } else {
            table.setMessageText("Computer: " +
                    computerScore + " Kid: " + kidScore);
        }
    }

    private boolean isBallOnTheTable() {
        if (ballY >= BALL_MIN_Y && ballY <= BALL_MAX_Y) {
            return true;
        } else {
            return false;
        }
    }
}
