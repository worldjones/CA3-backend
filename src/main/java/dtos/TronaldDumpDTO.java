package dtos;

import com.google.gson.Gson;

public class TronaldDumpDTO {
    private String quote_id;
    private String value;
    private Object _links;

    Gson GSON = new Gson();

    public String getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(String quote_id) {
        this.quote_id = quote_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = GSON.toJsonTree(_links);
    }

}
