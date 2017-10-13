import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;



public class ImageLoader {

    private static Map<String,Image> cache = new HashMap<>();

    public enum ImageList
    {
        DIRT("dirt.png"),
        GRASS("grass.png"),
        ROCK("rock.png"),
        STONE("stone.png");

        private final String path;

        ImageList(String path) {
            this.path = path;

        }
    }


    private ImageLoader(){}

    public static Image getImage(ImageList image)
    {
        return loadFromPath(image.path);
    }

    private static Image loadFromPath(String path)
    {

        Image image = cache.get(path);

        if(image != null){
            return image;
        }

        try {
            image = ImageIO.read(new File(path));
            cache.put(path,image);
        }
        catch (java.io.IOException e)
        {
            System.err.println("Path: " + path + " not found");
        }
        return image;
    }

}
