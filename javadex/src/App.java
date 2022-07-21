import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer a conexão http para buscar os pokémon
        String url = "https://pokeapi.co/api/v2/pokemon/?limit=5";
        URI uri = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        var body = response.body();

        // extrair apenas as informações necessárias(nome, id, tipo, icone)
        // List<Map<String, String>> pokeList = JsonParser.parse(body);

        PokeTest pokeList = JsonParser.simpleParse(body);

        // exibir e manipular os dados

        for (int i = 0; i < pokeList.getResults().size(); i++)
            System.out.println(pokeList.getResults().get(i).getName());
    }
}
