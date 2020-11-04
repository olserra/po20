/** @version $Id: ProgramCommand.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.evaluator;

//FIXME import used core classes
import pex.operators.Program;
import pt.tecnico.po.ui.Command;

/**
 * Commands for programs.
 */
public abstract class ProgramCommand extends Command<Program> {
  /** The context of the program. */
  protected /*FIXME interpreter class*/ _interpreter;
  
  /**
   * @param label 
   * @param interpreter
   * @param receiver
   */
  public ProgramCommand(String label, /*FIXME interpreter class*/, Program receiver) {
    super(label, receiver);
    _interpreter = interpreter;
  }

}
