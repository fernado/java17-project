package pr.iceworld.fernando.java8.http;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientTest {

    public void doTest() throws IOException, InterruptedException {
        var client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(30))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                //.uri(URI.create("http://localhost:8080/api/users/3"))
                .uri(URI.create("http://localhost:8080/api/n/3"))
                .build();
        HttpResponse httpResponse = client.send(httpRequest,
                HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);
        System.out.println("---------");
        System.out.println(httpResponse.body());
    }
}
