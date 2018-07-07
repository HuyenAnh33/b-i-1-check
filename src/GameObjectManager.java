import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();//static la goi k thong qua object ma thong qua class

    private List<GameObject> list;// luon goi private
    private ArrayList<GameObject>templist = new ArrayList<>();// add vao list chinh roi xoa bo het list phu roi giai phong
    private GameObjectManager(){
        this.list = new ArrayList<>();
    }
    public void add(GameObject gameObject){
        this.list.add(gameObject);
    }
    public void runAll(){
        this.list
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.templist);
        this.templist.clear();
    }
    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

    public Player findPlayer(){
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player )// ham filter duyet qua het cac phan tu cua mang, ins.. lay thi ve true k la fal
                .findFirst()
                .orElse(null);


    }
}
