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

    BackGround backGround;

    int countStar = 0;
    int countBullet = 0;
    int countplayerBullet = 0;
    List<Star> stars;
    List<Bullet>bullets;
    List<Bullet>playerBullets;
    public Player player = new Player();
    public Enemy enemy = new Enemy();
    private Random random = new Random();


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
        this.stars = new ArrayList<>();
        this.setupPlayer();
        this.setupEnemy();
        this.bullets = new ArrayList<>();
        this.playerBullets = new ArrayList<>();
    }

    private void setupPlayer() {

        this.player.position.set(100, 200);
    }

    private void setupEnemy() {
        this.enemy.position.set(800, 400);
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
        this.stars.forEach(star -> star.render(graphics));
        this.bullets.forEach(bullet -> bullet.render(graphics));
        this.playerBullets.forEach(bullet -> bullet.render(graphics));
        this.repaint();// be tu gamewindow va this chinh la gamecavas

    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createBullet();
        this.bullets.forEach(bullet -> bullet.run());
        this.runEnemy();
        this.createplayerBullet();
        this.playerBullets.forEach(bullet ->bullet.run() );
        this.player.run();
    }

    public void createStar() {
        if (this.countStar == 10) {
            Star star = new Star(
                    this.loadImage("resources/images/star.png"),
                    new Vecto2D(1024,this.random.nextInt(300)),
                    new Vecto2D(-this.random.nextInt(3)+1, 0)
            );
                this.stars.add(star);
                this.countStar = 0;
            }else{
                this.countStar += 1 ;
            }
        }
        public void runEnemy (){
            Vecto2D velocity = this.player.position
                    .subtract(this.enemy.position)
                    .normalize()
                    .multiply(1.5f);
            this.enemy.velocity.set(velocity);
            this.enemy.run();
        }
        public void createBullet(){
        if (this.countBullet == 20){
            Bullet bullet = new Bullet();
                    bullet.image =this.loadImage("resources/images/powerup_shield.png");
                    bullet.position.set(600,this.random.nextInt(300));
                    bullet.velocity.set(-this.random.nextInt(5)+1, 0);

            this.bullets.add(bullet);
            this.countBullet = 0;
        }else {
            this.countBullet += 1;
        }
        }

        public void createplayerBullet(){
        if (this.countplayerBullet == 20) {
            Bullet bullet = new Bullet();
                    bullet.image =  this.loadImage("resources/images/circle.png");
                    bullet.position.set(450, this.random.nextInt(200));
                    bullet.velocity.set(-this.random.nextInt(4) + 1, 0);
            this.playerBullets.add(bullet);
            this.countplayerBullet = 0;
        }else{
            this.countplayerBullet += 1;
            }
        }

        private BufferedImage loadImage (String path){

            try {
                return ImageIO.read(new File(path));
            } catch (IOException e) {
                return null;
            }


        }
    }
