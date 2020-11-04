/** @version $Id: DoReadProgram.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.main;

//FIXME import used core classes
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Read existing program.
 */
public class DoReadProgram extends Command</*FIXME core class*/> {
  /** Input field. */
  Input<String> _filename;

  /**
   * @param receiver
   */
  public DoReadProgram(/*FIXME core class*/ receiver) {
    super(Label.READ_PROGRAM, receiver);
    _filename = _form.addStringInput(Message.programFileName());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    //FIXME implement
  }

}
