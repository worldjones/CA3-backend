package dtos;

public class CombinedDTO {
    private ChuckNorrisJokeDTO chuck;
    private DadJokeDto dad;
    private AnimeQuoteDTO anime;
    private TronaldDumpDTO tronald;
    private JeopardyDTO jeopardy;

    public CombinedDTO(ChuckNorrisJokeDTO chuck, DadJokeDto dad, AnimeQuoteDTO anime, TronaldDumpDTO tronald, JeopardyDTO jeopardy) {
        this.chuck = chuck;
        this.dad = dad;
        this.anime = anime;
        this.tronald = tronald;
        this.jeopardy = jeopardy;
    }

    public ChuckNorrisJokeDTO getChuck() {
        return chuck;
    }

    public void setChuck(ChuckNorrisJokeDTO chuck) {
        this.chuck = chuck;
    }

    public DadJokeDto getDad() {
        return dad;
    }

    public void setDad(DadJokeDto dad) {
        this.dad = dad;
    }

    public AnimeQuoteDTO getAnime() {
        return anime;
    }

    public void setAnime(AnimeQuoteDTO anime) {
        this.anime = anime;
    }

    public TronaldDumpDTO getTronald() {
        return tronald;
    }

    public void setTronald(TronaldDumpDTO tronald) {
        this.tronald = tronald;
    }

    public JeopardyDTO getJeopardy() {
        return jeopardy;
    }

    public void setJeopardy(JeopardyDTO jeopardy) {
        this.jeopardy = jeopardy;
    }
}
