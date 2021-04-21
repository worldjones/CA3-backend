package dtos;

public class TronaldDumpDTO {
    private String value;
    private Object _links;
    private String href;

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
        this._links = _links;
    }

    public String getHref() {
        return href;
    }

    public void setHref() {
        String links = get_links().toString();
        this.href = links.substring(links.lastIndexOf("=") + 1, links.indexOf("}"));
        this._links = null;
    }
}