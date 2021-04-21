package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.nimbusds.jose.shaded.json.JSONObject;
import dtos.*;
import utils.HttpUtils;

import java.io.IOException;

public class ExternalFetchFacade {
    String chuckNorrisUrl = "https://api.chucknorris.io/jokes/random";
    String dadJokeUrl = "https://icanhazdadjoke.com/";
    String animeQuoteUrl = "https://animechan.vercel.app/api/random";
    String tronaldDumpUrl = "https://api.tronalddump.io/random/quote";
    String jeopardyUrl = "https://jservice.io/api/random";

    Gson GSON = new Gson();

    public ChuckNorrisJokeDTO getChuckNorrisJoke() throws IOException {
        String chuckJoke = HttpUtils.fetchData(chuckNorrisUrl);
        ChuckNorrisJokeDTO chuckDTO = GSON.fromJson(chuckJoke, ChuckNorrisJokeDTO.class);
        return chuckDTO;
    }

    public DadJokeDto getDadJoke() throws IOException {
        String dadJoke = HttpUtils.fetchData(dadJokeUrl);
        DadJokeDto dadJokeDto = GSON.fromJson(dadJoke, DadJokeDto.class);
        return dadJokeDto;
    }

    public AnimeQuoteDTO getAnimeQuote() throws IOException {
        String animeQuote = HttpUtils.fetchData(animeQuoteUrl);
        AnimeQuoteDTO animeQuoteDTO = GSON.fromJson(animeQuote, AnimeQuoteDTO.class);
        return animeQuoteDTO;
    }

    public TronaldDumpDTO getTronaldDumpQuote() throws IOException {
        String tronaldDumpQuote = HttpUtils.fetchData(tronaldDumpUrl);
        TronaldDumpDTO tronaldDumpDTO = GSON.fromJson(tronaldDumpQuote, TronaldDumpDTO.class);
        tronaldDumpDTO.setHref();
        return tronaldDumpDTO;
    }

    public JeopardyDTO getJeopardyQuestion() throws IOException {
        String jeopardyQuestion = HttpUtils.fetchData(jeopardyUrl);
        JeopardyDTO jeopardyDTO = GSON.fromJson(jeopardyQuestion.replace("[", "").replace("]", ""), JeopardyDTO.class);
        return jeopardyDTO;
    }

    public CombinedDTO getCombinedDTO() throws IOException {
        CombinedDTO combinedDTO = new CombinedDTO(getChuckNorrisJoke(), getDadJoke(), getAnimeQuote(), getTronaldDumpQuote(), getJeopardyQuestion());
        return combinedDTO;
    }
}