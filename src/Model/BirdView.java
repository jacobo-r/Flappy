package Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class BirdView {
    /**Attributs */
    private ArrayList<Bird> birds;

    public BirdView(){
        this.birds= new ArrayList<>();
        this.birds.add(new Bird());
    }
    public void updateBirds(){
        ListIterator<Bird> iter = this.birds.listIterator();
        while(iter.hasNext()){
            if(!iter.next().isVisible()){
                iter.remove();
            }
        }



    }

    public void drawBirds(Graphics g) {
        updateBirds();
        if(!this.birds.isEmpty()) {
        for(Bird b: this.birds){
                try {
                    Image bird = ImageIO.read(new File("./resources/frame_" + b.getEtat() + ".jpg"));
                    Image newBird = bird.getScaledInstance(200, 156, Image.SCALE_DEFAULT);
                    g.drawImage(newBird, b.getPosition(), b.getHauteur(), null);
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
        }

        }
    }
}
