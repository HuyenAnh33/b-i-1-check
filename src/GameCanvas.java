import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.stream.events.StartDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
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
    List<Star> stars;
    List<Enemy> enemys;
    List<Player> players;

    int countStart = 0;
    int countEnemy = 0;
    int countPlayer = 0;
    private Random random = new Random();

    //vi tri
    public int positionXEnemy = 100;
    public int positionYEnemy = 200;


    public int positionXPlayer = 150;
    public int positionYPlayer = 300;

    public int speedXEnemy = 8;
    public int speedYEnemy = 8;


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
        this.stars = new ArrayList<>();
        this.enemys = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    //paintComponent chi la de ve va lat hinh anh
    @Override
    protected void paintComponent(Graphics g) { //ve tat ca mmoi thu o trong nay thoi (graphic la ve hien thi g)
        // Color = new Color();//chon bang mau


        g.drawImage(this.backBuffered, 0, 0, null);
    }


    public void renderAll() { // ve

        this.graphics.setColor(Color.BLACK);//tao nen
        this.graphics.fillRect(0, 0, 1024, 600);// but ve hinh chu nhat

        this.stars.forEach(star -> star.render(graphics));// vong lap for noi xu ly code
        this.enemys.forEach(enemy -> enemy.render(graphics));
        this.players.forEach(player -> player.render(graphics));


        this.repaint();// be tu gamewindow va this chinh la gamecavas

    }

    public void runAll() {
        this.createrStart();
        this.stars.forEach(star -> star.run());
        this.runEnemy();
        this.createrEnemy();
        this.enemys.forEach(enemy -> enemy.run());
        this.createrPlayer();
        this.players.forEach(player -> player.run());
    }

    private void createrStart() {
        //if(this.countStart == 10){
        Star star = new Star(
                1024,
                this.random.nextInt(600),
                this.loadImage("resources/images/star.png"),
                -this.random.nextInt(3) + 1,
                0
        );

        this.stars.add(star);
//            countStart =0;
//        }else {
//            countStart++;
//        }
    }

    private void createrEnemy() {
        //if (this.countEnemy == 10) {
        Enemy enemy = new Enemy(
                this.random.nextInt(300),
                this.random.nextInt(450),
                this.loadImage("resources/images/circle.png"),
                -this.random.nextInt(3) + 1,
                -this.random.nextInt(3) + 1
        );
        this.enemys.add(enemy);
//            countEnemy = 0;
//        }else {
//            countEnemy++;
//        }
    }

    private void createrPlayer() {
        Player player = new Player(
                this.random.nextInt(400),
                this.random.nextInt(200),
                this.loadImage("resources/images/circle.png"),
                -this.random.nextInt(3) + 1,
                -this.random.nextInt(3) + 1
        );
        this.players.add(player);
    }


    private void runEnemy() {
        this.positionXEnemy += this.speedXEnemy;
        this.positionYEnemy += this.speedYEnemy;
        if (this.positionXEnemy < 0 || this.positionXEnemy > 1024 - 20)
            this.speedXEnemy = -this.speedXEnemy;
        if (this.positionYEnemy < 0 || this.positionYEnemy > 600 - 20)
            this.speedYEnemy = -this.speedYEnemy;
    }


    private BufferedImage loadImage(String path) {

        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }


    }
}
