import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboarEvent extends GameObject {
    private GameCanvas gameCanvas;
    keyboarEvent addKeyListener = new keyboarEvent();

    public keyboarEvent() {
        this.gameCanvas = new GameCanvas();
        this.keyboarEvent();


    }

    public void keyboarEvent() {
        keyboarEvent.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.angle += 5.0;
                }


                if (e.getKeyCode() == KeyEvent.VK_RIGHT)

                {
                    gameCanvas.player.angle -= 5.0;
                }
                gameCanvas.player.velocity.set(
                        (new Vecto2D(3.5f, 0.0f).rotate(gameCanvas.player.angle))
                );

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private static void addKeyListener(KeyListener keyListener) {
    }

}
