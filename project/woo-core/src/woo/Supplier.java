package woo;

import java.io.Serializable;
import java.util.Comparator;

public class Supplier implements Serializable {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 202009192006L;

    /**
     * NAME_COMPARATOR is an instance of an inner class that implements a supplier
     * comparator defining a comparison method for suppliers based on their names.
     * 
     * It would probably be better to have a static method for accessing this
     * object.
     * 
     * @see java.util.Comparator
     */
    public static final Comparator<Supplier> NAME_COMPARATOR = new Comparator<Supplier>() {

        /**
         * Compare two suppliers by name (lexicographically and ignoring case).
         * 
         * @param s1 supplier 1
         * @param s2 supplier 2
         * @return -1 if h1.name comes before h2.name; 0 if h1.name is the same as
         *         h2.name; 1 if h1.name comes after h2.name.
         */
        @Override
        public int compare(Supplier s1, Supplier s2) {
            String n1 = s1.getName();
            String n2 = s2.getName();
            return n1.compareToIgnoreCase(n2);
        }

    }; // NAME_COMPARATOR

    /** The supplier's key. */
    private String _key;

    /** The supplier's name. */
    private String _name;

    /** The supplier's name. */
    private String _address;

    /**
     * Constructor (initializes id and name).
     * 
     * @param key     the supplier's key.
     * @param name    the supplier's name.
     * @param address the supplier's address.
     * @throws DuplicateSupplierException
     */
    public Supplier(String key, String name, String address) {
        _key = key;
        _name = name;
        _address = address;
    }

    /**
     * @return the supplier's key.
     */
    public final String getKey() {
        return _key;
    }

    /**
     * @return the supplier's name.
     */
    public String getName() {
        return _name;
    }

    /**
     * Set the supplier's name.
     * 
     * @param name the supplier's new name.
     */
    public final void setName(String name) {
        _name = name;
    }

    /** @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public boolean equals(Object supplier) {
        return supplier instanceof Supplier && ((Supplier) supplier).getKey() == _key;
    }

    /** @see java.lang.Object#toString() */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "<supplier name='" + getName() + "' key='" + getKey() + "'/>";
    }
}
