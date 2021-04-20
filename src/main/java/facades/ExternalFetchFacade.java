package facades;

import com.google.gson.Gson;
import dtos.AnimeQuoteDTO;
import dtos.DadJokeDto;
import dtos.TronaldDumpDTO;
import utils.HttpUtils;
import dtos.ChuckNorrisJokeDTO;

import java.io.IOException;

public class ExternalFetchFacade {
    String chuckNorrisUrl = "https://api.chucknorris.io/jokes/random";
    String dadJokeUrl = "https://icanhazdadjoke.com/";
    String animeQuoteUrl = "https://animechan.vercel.app/api/random";
    String tronaldDumpUrl = "https://api.tronalddump.io/random/quote";

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

    public AnimeQuoteDTO getAnimeQoute() throws IOException {
        String animeQuote = HttpUtils.fetchData(animeQuoteUrl);
        AnimeQuoteDTO animeQuoteDTO = GSON.fromJson(animeQuote, AnimeQuoteDTO.class);
        return animeQuoteDTO;
    }

    public TronaldDumpDTO getTronaldDumpQuote() throws IOException {
        String tronaldDumpQuote = HttpUtils.fetchData(tronaldDumpUrl);
        TronaldDumpDTO tronaldDumpDTO = GSON.fromJson(tronaldDumpQuote, TronaldDumpDTO.class);
        return tronaldDumpDTO;
    }

    public static void main(String[] args) throws IOException {
        ExternalFetchFacade f = new ExternalFetchFacade();
        /*System.out.println("Chuck Norris joke: " + f.getChuckNorrisJoke().getValue());
        System.out.println("Dad joke: " + f.getDadJoke().getJoke());
        System.out.println("Anime quote: " + f.getAnimeQoute().getQuote());*/
        System.out.println(f.getTronaldDumpQuote().get_links());
        }
}
