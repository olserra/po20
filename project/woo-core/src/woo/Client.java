package woo;

import java.io.Serializable;
import java.util.Comparator;

public class Client implements Serializable {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 202009192006L;

    /**
     * NUMBER_COMPARATOR is an instance of an inner class that implements a client
     * comparator defining a comparison method for clients based on their numbers.
     * 
     * It would probably be better to have a static method for accessing this
     * object.
     * 
     * @see java.util.Comparator
     */
    public static final Comparator<Client> NUMBER_COMPARATOR = new Comparator<Client>() {

        /*
         * Compare two clients by number.
         * 
         * @param h1 client 1
         * 
         * @param h2 client 2
         * 
         * @return -1 if h1.id < h2.id; 0 if h1.id = h2.id; 1 if h1.id > h2.id.
         */
        @Override
        public int compare(Client h1, Client h2) {
            int i1 = h1.getId();
            int i2 = h2.getId();
            return (i1 < i2 ? -1 : (i1 == i2 ? 0 : 1));
        }

    }; // NUMBER_COMPARATOR

    /**
     * NAME_COMPARATOR is an instance of an inner class that implements a client
     * comparator defining a comparison method for clients based on their names.
     * 
     * It would probably be better to have a static method for accessing this
     * object.
     * 
     * @see java.util.Comparator
     */
    public static final Comparator<Client> NAME_COMPARATOR = new Comparator<Client>() {

        /**
         * Compare two clients by name (lexicographically and ignoring case).
         * 
         * @param h1 client 1
         * @param h2 client 2
         * @return -1 if h1.name comes before h2.name; 0 if h1.name is the same as
         *         h2.name; 1 if h1.name comes after h2.name.
         */
        @Override
        public int compare(Client h1, Client h2) {
            String n1 = h1.getName();
            String n2 = h2.getName();
            return n1.compareToIgnoreCase(n2);
        }

    }; // NAME_COMPARATOR

    /** The client's id. */
    private int _id;

    /** The client's name. */
    private String _name;

  /**
   * Constructor (initializes id and name).
   * 
   * @param id
   *          the client's id.
   * @param name
   *          the client's name.
   * @throws DuplicateClientException
   */
  public Client(int id, String name) throws DuplicateClientException {
    _id = id;
    _name = name;
  }

  /**
   * Constructor (initializes from array of String).
   * 
   * @param init
   *          the client's parameters.
   * @throws DuplicateClientException 
   */
  public Client(String[] init) throws DuplicateClientException {
    this(Integer.parseInt(init[1]), init[2]);
  }

    /**
     * @return the client's id.
     */
    public final int getId() {
        return _id;
    }

    /**
     * @return the client's name.
     */
    public String getName() {
        return _name;
    }

    /**
     * Set the client's name.
     * 
     * @param name the client's new name.
     */
    public final void setName(String name) {
        _name = name;
    }

    /** @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public boolean equals(Object client) {
        return client instanceof Client && ((Client) client).getId() == _id;
    }

    /** @see java.lang.Object#toString() */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "<client name='" + getName() + "' id='" + getId() + "'/>";
    }
}
