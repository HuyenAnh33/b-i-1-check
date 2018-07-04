import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateStar {
    public Random random;
    int countStar = 0;
    List<Star> stars = new ArrayList<>();

    public CreateStar(){
        this.createStar();
    }

    public void createStar() {
        if (this.countStar == 10) {
            Star star = new Star();
            star.position.set(1024,this.random.nextInt(600));
            star.velocity.set(-this.random.nextInt(3)+1, 0);
            this.stars.add(star);
            this.countStar = 0;
        }else{
            this.countStar += 1 ;
        }


    }

}
