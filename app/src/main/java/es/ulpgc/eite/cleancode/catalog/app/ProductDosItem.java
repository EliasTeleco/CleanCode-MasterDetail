package es.ulpgc.eite.cleancode.catalog.app;

public class ProductDosItem {
    public final int id;
    public final String content;
    public final String details;

    public ProductDosItem(int id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}

