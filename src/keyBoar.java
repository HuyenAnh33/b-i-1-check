import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyBoar implements KeyListener {
    private GameCanvas gameCanvas;
    public static keyBoar keyBoar = new keyBoar();


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

    public void run(){
        this.run();
    }
};
