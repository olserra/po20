package woo;

import java.io.Serializable;
import java.util.Comparator;

public abstract class Product implements Serializable {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 202009192006L;

    /**
     * NAME_COMPARATOR is an instance of an inner class that implements a product
     * comparator defining a comparison method for products based on their names.
     * 
     * It would probably be better to have a static method for accessing this
     * object.
     * 
     * @see java.util.Comparator
     */
    public static final Comparator<Product> NAME_COMPARATOR = new Comparator<Product>() {

        /**
         * Compare two products by name (lexicographically and ignoring case).
         * 
         * @param p1 product 1
         * @param p2 product 2
         * @return -1 if p1.name comes before p2.name; 0 if p1.name is tpe same as
         *         p2.name; 1 if p1.name pomes after p2.name.
         */
        @Override
        public int compare(Product p1, Product p2) {
            String n1 = p1.getKey();
            String n2 = p2.getKey();
            return n1.compareToIgnoreCase(n2);
        }

    }; // NAME_COMPARATOR

    /** The product's key. */
    private String _key;

    /** The product's supplierKey. */
    private String _supplierKey;

    /** The product's price. */
    private int _price;

    /** The product's criticalValue. */
    private int _criticalValue;

    /** The product's egs. */
    private int _egs;

    /**
     * Constructor (initializes id and name).
     * 
     * @param key           the product's key.
     * @param supplierKey   the product's supplierKey.
     * @param price         the product's price.
     * @param criticalValue the product's criticalValue.
     * @param egs           the product's egs.
     */
    protected Product(String key, String supplierKey, int price, int criticalValue, int egs) {
        _key = key;
        _supplierKey = supplierKey;
        _price = price;
        _criticalValue = criticalValue;
        _egs = egs;
    }

    /**
     * @return the product's key.
     */
    public final String getKey() {
        return _key;
    }

    /** @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public boolean equals(Object product) {
        return product instanceof Product && ((Product) product).getKey() == _key;
    }

    /** @see java.lang.Object#toString() */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "<product key='" + getKey() + "'/>";
    }
}
