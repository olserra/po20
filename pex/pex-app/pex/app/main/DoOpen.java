/** @version $Id: DoOpen.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

//FIXME import used core classes
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * Open existing interpreter.
 */
public class DoOpen extends Command</*FIXME core class*/> {
  /**
   * @param receiver
   */
  public DoOpen(/*FIXME core class*/ receiver) {
    super(Label.OPEN, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    //FIXME implement
  }

}
