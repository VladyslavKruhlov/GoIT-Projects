import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Task2 {

    public static String url = "https://jsonplaceholder.typicode.com";

    public void sendCommentsToFile(int userId) throws IOException, URISyntaxException, InterruptedException {
        int idForLastPost = idLastPost(userId);

        FileWriter fw = new FileWriter("user-"+userId+"-post-"+idForLastPost+"-comments.json");
        fw.write(getAllCommentsForSelectedUser(userId));
        fw.close();
    }

    public String getAllCommentsForSelectedUser(int userId) throws IOException, URISyntaxException, InterruptedException {
        int idForLastPost = idLastPost(userId);

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url + "/posts/"+idForLastPost+"/comments"))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse <String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
//        Type type = TypeToken.getParameterized(List.class, Post.class).getType();
//        List<Post> result = new Gson().fromJson(httpResponse.body(), type);
//        return result; List<Post>
    }

    public int idLastPost(int userId) throws IOException, URISyntaxException, InterruptedException {
        List<Post> posts = getAllPosts(userId);
        return posts.stream()
                .mapToInt(Post::getId)
                .max()
                .getAsInt();
    }

    public List<Post> getAllPosts(int userId) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url + "/users/" + userId + "/posts"))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Type type = TypeToken.getParameterized(List.class, Post.class).getType();
        List<Post> result = new Gson().fromJson(httpResponse.body(), type);
        return result;
    }


        public static void main (String[]args) throws IOException, URISyntaxException, InterruptedException {
            Task2 task2 = new Task2();
            //System.out.println(task2.getAllPosts(1));
            //System.out.println(task2.idLastPost(1));
            System.out.println(task2.getAllCommentsForSelectedUser(1));
            task2.sendCommentsToFile(1);
        }
}
