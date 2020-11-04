package woo;

import java.io.Serializable;
import java.util.Comparator;

public class Client implements Serializable {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 202009192006L;

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
         * @return -1 if h1.name comes before c2.name; 0 if c1.name is tce same as
         *         c2.name; 1 if c1.name comes after c2.name.
         */
        @Override
        public int compare(Client c1, Client c2) {
            String n1 = c1.getName();
            String n2 = c2.getName();
            return n1.compareToIgnoreCase(n2);
        }

    }; // NAME_COMPARATOR

    /** The client's key. */
    private String _key;

    /** The client's name. */
    private String _name;

    /** The client's address. */
    private String _address;

    /**
     * Constructor (initializes id and name).
     * 
     * @param key      the client's key.
     * @param name    the client's name.
     * @param address the client's address.
     */
    public Client(String key, String name, String address) {
        _key = key;
        _name = name;
        _address = address;
    }

    /**
     * @return the client's key.
     */
    public final String getKey() {
        return _key;
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
        return client instanceof Client && ((Client) client).getKey() == _key;
    }

    /** @see java.lang.Object#toString() */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "<client name='" + getName() + "' key='" + getKey() + "'/>";
    }
}
