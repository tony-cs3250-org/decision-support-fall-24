//Use hash map to make a searchable table with index and movie object
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.HashMap;


public class HashMapSearch {

    

    private static HashMap<String, Movie> movieMap;

    public static void MovieSearch(CopyOnWriteArrayList<Movie> movieList) {
        movieMap = new HashMap<>();
        for (Movie movie : movieList) {
            movieMap.put(movie.getTitle(), movie);
        }
    }

    public static void findMovieByTitle(String title){
        
        if (movieMap.containsKey(title)){
            System.out.println(movieMap.values());
        }
    }
}
