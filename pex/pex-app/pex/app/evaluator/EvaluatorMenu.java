/** @version $Id: EvaluatorMenu.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.evaluator;

//FIXME import used core classes
import pex.operators.Program;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

/**
 * Menu for program manipulation.
 */
public class EvaluatorMenu extends Menu {

  /**
   * @param interpreter 
   * @param receiver
   */
  public EvaluatorMenu(/*FIXME interpreter class*/, Program receiver) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoShowProgram(interpreter, receiver), //
            new DoRunProgram(interpreter, receiver), //
            new DoAddExpression(interpreter, receiver), //
            new DoReplaceExpression(interpreter, receiver), //
            new DoShowAllIdentifiers(interpreter, receiver), //
            new DoShowUninitializedIdentifiers(interpreter, receiver), //
        });
  }

}
