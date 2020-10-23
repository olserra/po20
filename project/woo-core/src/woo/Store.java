package woo;

import java.io.IOException;
import java.io.FileNotFoundException;
import woo.exceptions.BadEntryException;
import java.io.Serializable;


/**
 * Class Store implements a store.
 */
public class Store implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202009192006L;

  // FIXME define attributes
  // FIXME define contructor(s)
  // FIXME define methods

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  void importFile(String txtfile) throws IOException, BadEntryException, FileNotFoundException {
    //FIXME implement method
  }

}
