import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;



public class ImageLoader {

    public enum ImageList
    {
        DIRT("dirt.png"),
        GRASS("grass.png"),
        ROCK("rock.png"),
        SAND("sand.png"),
        COIN("coin.png"),
        TREE("tree.png");

        private final String path;

        ImageList(String path) {
            this.path = path;

        }
    }

    private ImageLoader(){}

    private static ImageLoader instance;

    public static ImageLoader getInstance()
    {

        if(instance == null)
        {
            instance = new ImageLoader();
        }

        return instance;
    }

    private Map<String,Image> imageCache = new HashMap<>();


    public Image getImage(ImageList image)
    {
        return loadFromPath(image.path);
    }


    private Image loadFromPath(String path)
    {

        Image image = imageCache.get(path);

        if(image != null){
            return image;
        }

        try {
            image = ImageIO.read(new File(path));
            imageCache.put(path,image);
        }
        catch (java.io.IOException e)
        {
            System.err.println("Path: " + path + " not found");
        }
        return image;
    }

}
