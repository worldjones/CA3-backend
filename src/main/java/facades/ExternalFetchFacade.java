package facades;

import com.google.gson.Gson;
import org.graalvm.compiler.hotspot.replacements.ClassGetHubNode;
import utils.HttpUtils;
import dtos.ChuckDTO;

import java.io.IOException;

public class ExternalFetchFacade {


    public static void main(String[] args) throws IOException {
        String chuckNorrisUrl = "https://api.chucknorris.io/jokes/random";

            Gson GSON = new Gson();
        String chuck = HttpUtils.fetchData(chuckNorrisUrl);
        ChuckDTO chuckDTO = GSON.fromJson(chuck, ChuckDTO.class);
        System.out.println(chuckDTO);
    }
}
