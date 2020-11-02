package woo;

import java.io.Serializable;
import java.util.Comparator;

public class Supplier implements Serializable {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 202009192006L;

    /**
     * NUMBER_COMPARATOR is an instance of an inner class that implements a supplier
     * comparator defining a comparison method for suppliers based on their numbers.
     * 
     * It would probably be better to have a static method for accessing this
     * object.
     * 
     * @see java.util.Comparator
     */
    public static final Comparator<Supplier> NUMBER_COMPARATOR = new Comparator<Supplier>() {

        /*
         * Compare two suppliers by number.
         * 
         * @param s1 supplier 1
         * 
         * @param s2 supplier 2
         * 
         * @return -1 if h1.key < h2.key; 0 if h1.key = h2.key; 1 if h1.key > h2.key.
         */
        @Override
        public int compare(Supplier s1, Supplier s2) {
            int i1 = s1.getId();
            int i2 = s2.getId();
            return (i1 < i2 ? -1 : (i1 == i2 ? 0 : 1));
        }

    }; // NUMBER_COMPARATOR

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
        public int compare(Supplier h1, Supplier h2) {
            String n1 = s1.getName();
            String n2 = s2.getName();
            return n1.compareToIgnoreCase(n2);
        }

    }; // NAME_COMPARATOR

    /** The supplier's id. */
    private int _key;

    /** The supplier's name. */
    private String _name;

  /**
   * Constructor (initializes id and name).
   * 
   * @param id
   *          the supplier's id.
   * @param name
   *          the supplier's name.
   * @throws DuplicateSupplierException
   */
  public Supplier(int id, String name) throws DuplicateSupplierException {
    _key = key;
    _name = name;
  }

  /**
   * Constructor (initializes from array of String).
   * 
   * @param init
   *          the supplier's parameters.
   * @throws DuplicateSupplierException 
   */
  public Supplier(String[] init) throws DuplicateSupplierException {
    this(Integer.parseInt(init[1]), init[2]);
  }

    /**
     * @return the supplier's id.
     */
    public final int getId() {
        return _id;
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
        return supplier instanceof Supplier && ((Supplier) supplier).getId() == _id;
    }

    /** @see java.lang.Object#toString() */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "<supplier name='" + getName() + "' id='" + getId() + "'/>";
    }
}
