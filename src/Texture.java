import java.awt.*;

public class Texture {


    Image image;
    int xSize, ySize;


    public Texture(int size, Image image) {
        this.image = image;
        this.xSize = size;
        this.ySize = size;
    }

    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, xSize, ySize, null);
    }

}
