import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public List<String> listOfTasks (int id, String string) throws URISyntaxException, IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/users/"+id+"/todos?completed=";

        HttpRequest request = HttpRequest.newBuilder(new URI(url+string))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response = " + response.statusCode());
        return Collections.singletonList(response.body());
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Task3 task3 = new Task3();
        System.out.println(task3.listOfTasks(2,"false"));
    }
}
