/** @version $Id: DoShowUninitializedIdentifiers.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.evaluator;

//FIXME import core classes
import pex.operators.Program;

/**
 * Show uninitialized identifiers.
 */
public class DoShowUninitializedIdentifiers extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowUninitializedIdentifiers(/*FIXME interpreter class*/, Program receiver) {
    super(Label.SHOW_UNINITIALIZED_IDENTIFIERS, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    //FIXME implement
  }

}
