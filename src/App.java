import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;



public class App {
    public static void main(String[] args) throws Exception {

        // Connect to HTTP Url and GET data
        String url = "https://imdb-api.com/en/API/Top250Movies/k_o1s5vy3i";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        

        // Extract Data/filter (titulo, poster, rate)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());
        System.out.println(listaDeFilmes.get(0));
        
        // Show data 
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
            
        }
    }
}
