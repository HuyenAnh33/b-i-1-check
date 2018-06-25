import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {


    //BackBuffered lat hinh anh
    BufferedImage backBuffered;
    Graphics graphics;//co ve nay se ve het len buffered

    BackGround backGround;

    int countStart = 0;
   public Player player = new Player();
   public Enemy enemy = new Enemy();
    private Random random = new Random();
    public  Star star = new Star(this.random.nextInt(500), -this.random.nextInt(3) + 01);

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
        this.backGround = new BackGround();
        this.setupStar();
       this.setupPlayer();
       this.setupEnemy();
    }
    private  void setupStar(){
        this.star.position.set(500,300);
        this.star.image = this.loadImage("resources/images/star.png");
    }
    private void setupPlayer(){
        this.player.position.set(100,200);
    }
    private void setupEnemy(){
        this.enemy.position.set(800,400);
        this.enemy.image = this.loadImage("resources/images/circle.png");
    }

    //paintComponent chi la de ve va lat hinh anh
    @Override
    protected void paintComponent(Graphics g) { //ve tat ca mmoi thu o trong nay thoi (graphic la ve hien thi g)
        // Color = new Color();//chon bang mau


        g.drawImage(this.backBuffered, 0, 0, null);
    }



    public void renderAll() { // ve

        this.backGround.render(this.graphics);//tao nen
       this.player.render(this.graphics);
       this.enemy.render(this.graphics);
       this.star.render(this.graphics);
        this.repaint();// be tu gamewindow va this chinh la gamecavas

    }

    public void runAll() {
        this.runEnemy();
        this.player.run();
        this.runStar();
    }

    private void runStar(){
//        if(this.countStart == 10){
//            Star star = new Star(
//                    this.random.nextInt(500),
//                    -this.random.nextInt(3)+1 );
//            countStart =0;
//        }else {
//            countStart++;
//        }
        Vecto2D velocity = this.star.position
                .multiply(0.5f);
        this.star.velocity.set(velocity);
        this.star.run();

    }
    private void runEnemy(){
        Vecto2D velocity = this.player.position
                .subtract(this.enemy.position)
                .normalize()
                .multiply(1.5f);
        this.enemy.velocity.set(velocity);
        this.enemy.run();
    }



    private BufferedImage loadImage(String path) {

        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }


    }
}
