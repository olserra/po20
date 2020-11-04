/* $Id: Identifier.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.atomic;

import pex.Expression;
import pex.Value;

/**
 * Class for describing syntactic tree leaves for holding identifier values.
 */
public class Identifier extends Expression {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201608281352L;

  /** Identifier name. */
  private String _name;

  /**
   * @param name
   */
  public Identifier(String name) {
    _name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return _name;
  }

  //FIXME (possibly) add other methods: e.g. accept, toString, etc.
}
