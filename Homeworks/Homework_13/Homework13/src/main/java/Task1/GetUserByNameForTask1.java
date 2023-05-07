package Task1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class GetUserByNameForTask1 {

    public List<UserForTask1> getUserByName (String string) throws URISyntaxException, IOException, InterruptedException {


        String url = "https://jsonplaceholder.typicode.com/users?name=";

        HttpRequest request = HttpRequest.newBuilder(new URI(url+string))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code = " + response.statusCode());

        Type type = TypeToken.getParameterized(List.class, UserForTask1.class).getType();
        List<UserForTask1> result = new Gson().fromJson(response.body(), type);
        return result; // Не можу вивести інфу про юзера по імені, завжди виводить "[]"
    }
}
