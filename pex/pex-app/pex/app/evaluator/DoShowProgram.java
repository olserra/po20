/** @version $Id: DoShowProgram.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.evaluator;

//FIXME import core classes
import pex.operators.Program;

/**
 * Show program (present code).
 */
public class DoShowProgram extends ProgramCommand {

  /**
   * @param interpreter
   * @param receiver
   */
  public DoShowProgram(/*FIXME interpreter class*/, Program receiver) {
    super(Label.SHOW_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    //FIXME implement
  }

}
