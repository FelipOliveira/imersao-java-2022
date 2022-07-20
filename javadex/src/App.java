import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

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
        List<Map<String, String>> pokeList = JsonParser.parse(body);

        // exibir e manipular os dados
        for (Map<String, String> pokemon : pokeList) {
            System.out.print("nome: " + pokemon.get("name"));
            space();
            System.out.println("url: " + pokemon.get("url"));
        }
    }

    public static void space() {
        System.out.print(" - ");
    }
}
