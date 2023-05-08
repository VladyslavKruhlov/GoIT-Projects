package Task1;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GetUserByNameForTask1 {

    public String getUserByName (String username) throws URISyntaxException, IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users?username=";

        HttpRequest request = HttpRequest.newBuilder(new URI(url+username))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code = " + response.statusCode());

//        Type type = TypeToken.getParameterized(List.class, List<UserForTask1>.class).getType();
//        UserForTask1 result = new Gson().fromJson(response.body(), type);
        return response.body();
    }
}
