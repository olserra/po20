package woo.exceptions;

public class DuplicateClientKeyException extends Exception {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  /** Client key. */
  private final String _key;

  public String getKey() {
    return _key;
  }

  /** @param key the duplicated key */
  public DuplicateClientKeyException(String key) {
    _key = key;
  }
}
