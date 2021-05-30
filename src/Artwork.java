import java.util.ArrayList;
public class Artwork {

    private ArrayList<String> artworks;

    public Artwork(String[] w){
        artworks = new ArrayList<String>();
        for(int i = 0; i< w.length; i++){
            artworks.add(w[i]);
            //thanks patrick
        }

    }

    public String getArt(){
        int rand = (int) (Math.random() * (artworks.size()));
        String artReturn = artworks.get(rand);
        artworks.remove(rand);
        return artReturn;
    }
}
