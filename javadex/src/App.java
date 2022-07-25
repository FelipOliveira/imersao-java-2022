import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

import models.NamedAPIResourceList;
import utils.Constants;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(getNamedAPIResourceListByEndpoint(Constants.POKEMON));
    }

    public static NamedAPIResourceList getNamedAPIResourceListByEndpoint(String endpoint) throws IOException {
        return NamedAPIResourceList.getByEndpoint(endpoint);
    }

    public static void printList(ArrayList<Object> list) {
        for (Object item : list)
            System.out.println(item);
    }

    public static String RetrieveHttpResponseBody(String url) throws IOException, InterruptedException {
        URI uri = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    }
}
