package woo.exceptions;

public class DuplicateProductKeyException extends Exception  {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  /** Product key. */
  private final String _key;

  public String getKey() {
    return _key;
  }

  /** @param key the duplicated key */
  public DuplicateProductKeyException(String key) {
    _key = key;
  }
}
