/** @version $Id: MainMenu.java,v 1.1 2016/10/14 18:13:48 david Exp $ */
package pex.app.main;

//FIXME import used core classes
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Menu;

/**
 * Menu builder.
 */
public class MainMenu extends Menu {

  /**
   * @param receiver
   */
  public MainMenu(/*FIXME core class*/ receiver) {
    super(Label.TITLE,
        new Command<?>[] { //
            new DoNew(receiver), //
            new DoOpen(receiver), //
            new DoSave(receiver), //
            new DoNewProgram(receiver), //
            new DoReadProgram(receiver), //
            new DoWriteProgram(receiver), //
            new DoManageProgram(receiver), //
        });
  }

}
