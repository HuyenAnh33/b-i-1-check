import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;// dung de ve tat ca moi thu len
    long lastTime = 0;
    Random random = new Random();

    public GameWindow() {

        this.setSize(1024, 600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);//truyen game nay vao windown
        this.event();
        this.setVisible(true);
    }
    public void event(){
        this.keyboarEvent();
        this.windowEvent();
    }

    private void keyboarEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.angle += 5.0;
                }

//                if (gameCanvas.positionXPlayer <= 0) {
//                    gameCanvas.positionXPlayer = 1024;
//                    gameCanvas.positionYPlayer = random.nextInt(601);
//                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT)

                {
                    gameCanvas.player.angle -= 5.0;
                }
                gameCanvas.player.velocity.set(
                        (new  Vecto2D(3.5f,0.0f).rotate(gameCanvas.player.angle))
                );
//                if (gameCanvas.positionXPlayer >= 600) {
//                    gameCanvas.positionXPlayer = 0;
//                    gameCanvas.positionYPlayer = random.nextInt(1025);
//                }

            }


            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(1);
            }
        });

    }

    public void gameLoop() {

        while (true) {
            long currentTime = System.nanoTime();//tinh tu 0 gio 0 phut 0 giay ngay 1 thang 1 nam 1970 den thoi diem hien tai
            if (currentTime - this.lastTime >= 17_000_000) {
                //this.gameCanvas.positionXStar -= 3;//toc do chay cua ngoi sao la 3

                //cho enemy di chuyen cheo
//                this.gameCanvas.positionXEnemy -= 8;
//                this.gameCanvas.positionYEnemy -= 8;
//                this.gameCanvas.positionXEnemy += this.gameCanvas.speedXEnemy;
//                this.gameCanvas.positionYEnemy += this.gameCanvas.speedYEnemy;
//
//                if (this.gameCanvas.positionXEnemy >= 1024 || this.gameCanvas.positionXEnemy <= 0) {
//                    this.gameCanvas.speedXEnemy = -this.gameCanvas.speedXEnemy;
//                }
//                if (this.gameCanvas.positionYEnemy >= 600 || this.gameCanvas.positionYEnemy <= 0) {
//                    this.gameCanvas.speedYEnemy = -this.gameCanvas.speedYEnemy;
//                }
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                //this.gameCanvas.positionXPlayer -= 1; tu dong di chuyen =1
                this.lastTime = currentTime;
            }

        }

        //Thread.sleep(20);// dung de nghi
    }
}























