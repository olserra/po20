package woo;

public class Book extends Product {

    private static final long serialVersionUID = 4265220693890113900L;

    /** The book's key. */
    private String _title;

    /** The book's key. */
    private String _author;

    /** The book's key. */
    private String _isbn;

    /**
     * Book Constructor.
     * 
     * @param title         the book's title.
     * @param author        the book's author.
     * @param isbn          the book's isbn.
     * @param supplierKey   the book's supplierKey.
     * @param price         the book's price.
     * @param criticalValue the book's criticalValue.
     * @param units         the book's units.
     */
    protected Book(String title, String author, String isbn, String key, String supplierKey, int price,
            int criticalValue, int units) {
        super(key, supplierKey, price, criticalValue, units);
        _title = title;
        _author = author;
        _isbn = isbn;
    }
}
