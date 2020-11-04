/** @version $Id: DoRunProgram.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.evaluator;

//FIXME import used core classes
import pex.operators.Program;

/**
 * Run program.
 */
public class DoRunProgram extends ProgramCommand {
  
  /**
   * @param interpreter 
   * @param receiver
   */
  public DoRunProgram(/*FIXME interpreter class*/, Program receiver) {
    super(Label.RUN_PROGRAM, interpreter, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    //FIXME implement
  }
  
}
