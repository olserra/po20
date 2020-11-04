package woo;

public class Box extends Product {

    /**
     * Box Constructor.
     * 
     * @param serviceType   the box's serviceType.
     * @param key           the box's key.
     * @param supplierKey   the box's supplierKey.
     * @param price         the box's price.
     * @param criticalValue the box's criticalValue.
     * @param units         the box's units.
     */
    public Box(String serviceType, String key, String supplierKey, int price, int criticalValue, int units) {
        super(key, supplierKey, price, criticalValue, units);
    }
}
