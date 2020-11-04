package woo;

public class Container extends Product {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Container Constructor.
     * 
     * @param serviceType   the container's serviceType.
     * @param serviceLevel  the container's serviceLevel.
     * @param supplierKey   the container's supplierKey.
     * @param price         the container's price.
     * @param criticalValue the container's criticalValue.
     * @param units           the container's units.
     */
    public Container(String serviceType, String serviceLevel, String key, String supplierKey, int price,
            int criticalValue, int units) {
        super(key, supplierKey, price, criticalValue, units);
    }
}
