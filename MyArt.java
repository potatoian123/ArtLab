
/**
 * Write a description of class MyArt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyArt
{
    /** you put your code here  **/
    private Picture image;
    
    public MyArt(){
        image = new Picture("kitten.jpg");
    }
    
    public MyArt(String filename){
        image = new Picture(filename);
    }
    
    public MyArt(int num){
        int width = num;
        int height = num * 2;
        int red = (int)(Math.random()*(256));
        int green = (int)(Math.random()*(256));
        int blue = (int)(Math.random()*(256));
        image = new Picture(width, height);
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                Pixel pixelObj = image.getPixel(x, y);              
                
                pixelObj.setRed(red);
                pixelObj.setGreen(green);
                pixelObj.setBlue(blue); 
            }
        }
    }
    
    public MyArt(int width, int height){
        image = new Picture(width, height);
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                Pixel pixelObj = image.getPixel(x, y);              
                
                pixelObj.setRed((int)(Math.random()*(256)));
                pixelObj.setGreen((int)(Math.random()*(256)));
                pixelObj.setBlue((int)(Math.random()*(256))); 
            }
        }
    }
    
    public void show()
    {
        image.show();
    }
    
    public Picture getImage(){
        return image;
    }
    
    public void reflect(){
        Picture copy = new Picture(image.getWidth(), image.getHeight());
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                Pixel pixelObj = image.getPixel(x,y);
                Pixel copyPixel = copy.getPixel(image.getWidth() - 1 - x,y);
                copyPixel.setRed(pixelObj.getRed());
                copyPixel.setGreen(pixelObj.getGreen());
                copyPixel.setBlue(pixelObj.getBlue());
            }
        }
        image = copy;
    }
    
    public void doubleHorizontal(){
        Picture copy = new Picture(image.getWidth() * 2, image.getHeight());
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                Pixel pixelObj = image.getPixel(x,y);
                Pixel copyPixel = copy.getPixel(x,y);
                copyPixel.setRed(pixelObj.getRed());
                copyPixel.setGreen(pixelObj.getGreen());
                copyPixel.setBlue(pixelObj.getBlue());
            }
        }
        for(int x = image.getWidth(); x < copy.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                Pixel pixelObj = image.getPixel(x - image.getWidth(),y);
                Pixel copyPixel = copy.getPixel(x,y);
                copyPixel.setRed(pixelObj.getRed());
                copyPixel.setGreen(pixelObj.getGreen());
                copyPixel.setBlue(pixelObj.getBlue());
            }
        }
        image = copy;
    }
    
    public void doubleVertical(){
        Picture copy = new Picture(image.getWidth(), image.getHeight() * 2);
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                Pixel pixelObj = image.getPixel(x,y);
                Pixel copyPixel = copy.getPixel(x,y);
                copyPixel.setRed(pixelObj.getRed());
                copyPixel.setGreen(pixelObj.getGreen());
                copyPixel.setBlue(pixelObj.getBlue());
            }
        }
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = image.getHeight(); y < copy.getHeight(); y++){
                Pixel pixelObj = image.getPixel(x,y - image.getHeight());
                Pixel copyPixel = copy.getPixel(x,y);
                copyPixel.setRed(pixelObj.getRed());
                copyPixel.setGreen(pixelObj.getGreen());
                copyPixel.setBlue(pixelObj.getBlue());
            }
        }
        image = copy;
    }
    
    public void border(){
        Picture newImage = new Picture(image.getWidth()/10 + image.getWidth(),image.getHeight()/10 + image.getHeight());
        int leftBorder = image.getWidth()/10/2;
        int rightBorder = image.getWidth()/10 - leftBorder;
        int topBorder = image.getHeight()/10/2;
        int bottomBorder = image.getHeight()/10 - topBorder;
        
        for(int x = 0; x < newImage.getWidth(); x++){
            for(int y = 0; y < newImage.getHeight(); y++){
                Pixel pixelObj = newImage.getPixel(x, y);              
                
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
                pixelObj.setBlue(0); 
            }
        }
        for(int x = leftBorder; x < newImage.getWidth()-rightBorder; x++){
            for(int y = topBorder; y < newImage.getHeight()-bottomBorder; y++){
                Pixel pixelObj = image.getPixel(x - leftBorder, y - topBorder);              
                Pixel copyPixel = newImage.getPixel(x, y);
                int red = pixelObj.getRed();
                int green = pixelObj.getGreen();
                int blue = pixelObj.getBlue(); 
                copyPixel.setRed(red);
                copyPixel.setGreen(green);
                copyPixel.setBlue(blue);
            }
        }
        image = newImage;
    }
    
    public void swapColors(){
        for(int x = 0; x < image.getWidth(); x++){
            for(int y = 0; y < image.getHeight(); y++){
                Pixel pixelObj = image.getPixel(x, y);              
                int red = pixelObj.getRed();
                int green = pixelObj.getGreen();
                int blue = pixelObj.getBlue();
                pixelObj.setRed(green);
                pixelObj.setGreen(blue);
                pixelObj.setBlue(red); 
            }
        }
    }
}
