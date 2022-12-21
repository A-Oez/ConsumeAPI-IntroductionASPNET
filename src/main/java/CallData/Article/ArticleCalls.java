package CallData.Article;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ArticleCalls {

    private static final HttpClient client = HttpClient.newHttpClient();

    public String Get() throws IOException, InterruptedException{
        HttpResponse<String> response = client.send(HttpRequest.newBuilder(URI.create("https://localhost:7059/api/Article"))
                                        .GET().build()
                                        ,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String GetByID(String ID) throws IOException, InterruptedException{
        HttpResponse<String> response = client.send(HttpRequest.newBuilder(URI.create("https://localhost:7059/api/Article/" + ID))
                                        .GET().build()
                                        ,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String Post(String value) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .header("content-type", "application/json")
                .uri(URI.create("https://localhost:7059/api/Article"))
                .POST(HttpRequest.BodyPublishers.ofString(value))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String Update(String value) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .header("content-type", "application/json")
                .uri(URI.create("https://localhost:7059/api/Article"))
                .PUT(HttpRequest.BodyPublishers.ofString(value))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String Delete(int ID) throws IOException, InterruptedException{
        HttpResponse<String> response = client.send(
                                         HttpRequest.newBuilder(URI.create("https://localhost:7059/api/Article/" + ID))
                                        .DELETE().build()
                                        ,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


}