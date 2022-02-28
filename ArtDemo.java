import java.awt.Color;
/**
 * RandomArt Demo - has examples of things your might use for your MyArt class
 * 
 */
public class ArtDemo
{
    private Picture image;

    public ArtDemo()
    {
        final int WIDTH = 300;
        final int HEIGHT = 400;

        image = new Picture(WIDTH, HEIGHT);

        /** Colors are red, green and blue values are between 0 and 255)  **/
        int red = 200;
        int green = 100;
        int blue = 255;
        
        /** Create a stripe **/        
        for(int x = WIDTH/3; x < image.getWidth()*2/3; x++)
        {
            for(int y = 0; y < image.getHeight(); y++)
            {
                Pixel pixelObj = image.getPixel(x, y);              
                
                pixelObj.setRed(255);
                pixelObj.setGreen(150);
                pixelObj.setBlue(100); 
            }
        }

    }   
    
    public ArtDemo(String filename)
    {
        if(filename.equals(""))
        {
            image = new Picture("kitten.jpg");            
        }
        else
        {
            image = new Picture(filename);
        }
    }
        
    /**
     * Show the Art object
     */
    public void show()
    {
        image.show();
    }
    
    
}
