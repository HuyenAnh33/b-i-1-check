import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {


    //BackBuffered lat hinh anh
    BufferedImage backBuffered;
    Graphics graphics;//co ve nay se ve het len buffered



    public Player player = new Player();




    //vi tri
    public GameCanvas() {

        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();//gan vao backbuffered

    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new BackGround());
        GameObjectManager.instance.add(new CreateStar());

        this.setupPlayer();

    }

    private void setupPlayer() {

        //this.player.position.set(100, 200);
        Player player = new Player();
        player.position.set(100,200);
        GameObjectManager.instance.add(player);
    }



    //paintComponent chi la de ve va lat hinh anh
    @Override
    protected void paintComponent(Graphics g) { //ve tat ca mmoi thu o trong nay thoi (graphic la ve hien thi g)

        // Color = new Color();//chon bang mau

        g.drawImage(this.backBuffered, 0, 0, null);
    }


    public void renderAll() { // ve
    GameObjectManager.instance.renderAll(this.graphics);
    this.repaint();

    }

    public void runAll() {
        //tap trung dua ra list duy nhat quan ly tt ca cac nhan vat
        GameObjectManager.instance.runAll();

    }


    public void runEnemy() {

    }

    private BufferedImage loadImage(String path) {

        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }


    }
}
