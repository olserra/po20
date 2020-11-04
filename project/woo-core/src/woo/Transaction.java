package woo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;


public class Transaction implements Serializable {
    /** Serial number for serialization. */
    private static final long serialVersionUID = 202009192006L;

    /**
     * NUMBER_COMPARATOR is an instance of an inner class that implements a transaction
     * comparator defining a comparison method for suppliers based on their numbers.
     * 
     * It would probably be better to have a static method for accessing this
     * object.
     * 
     * @see java.util.Comparator
     */
    public static final Comparator<Transaction> NUMBER_COMPARATOR = new Comparator<Transaction>() {

        /*
         * Compare two transactions by number.
         * 
         * @param s1 transaction 1
         * 
         * @param s2 transaction 2
         * 
         * @return -1 if t1.key < t2.key; 0 if t1.key = t2.key; 1 if t1.key > t2.key.
         */
        @Override
        public int compare(Transaction t1, Transaction t2) {
            int i1 = t1.getId();
            int i2 = t2.getId();
            return (i1 < i2 ? -1 : (i1 == i2 ? 0 : 1));
        }

    }; // NUMBER_COMPARATOR

    /** The transaction's id. */
    private int _id;

    /** The transaction's name. */
    private LocalDate _date;

    /**
     * Constructor (initializes id and name).
     * 
     * @param id      the transaction's id.
     * @param name    the transaction's name.
     * @throws DuplicateTransactionException
     */
    public Transaction(int id, LocalDate date) {
        _id = id;
        _date = date;
    }

    /**
     * @return the transaction's id.
     */
    public final int getId() {
        return _id;
    }

    /**
     * @return the transaction's date.
     */
    public LocalDate getDate() {
        return _date;
    }


    /** @see java.lang.Object#equals(java.lang.Object) */
    @Override
    public boolean equals(Object transaction) {
        return transaction instanceof Transaction && ((Transaction) transaction).getId() == _id;
    }
}
