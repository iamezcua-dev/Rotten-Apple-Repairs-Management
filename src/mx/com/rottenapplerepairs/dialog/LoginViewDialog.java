package mx.com.rottenapplerepairs.dialog;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class LoginViewDialog extends JDialog {

	private static final long serialVersionUID = 2606034708362816870L;
	
	/**
	 * 
	 */
	public LoginViewDialog( Frame owner, Boolean modal ) {
		super( owner, modal );
		this.setUndecorated( true );
		this.setDefaultCloseOperation( JDialog.HIDE_ON_CLOSE );
		
		SwingUtilities.invokeLater( () -> {
			BorderLayout frameLayout = new BorderLayout( 10, 10 );
			this.setLayout( frameLayout );
			this.setSize( 700, 400);
			this.setLocationRelativeTo( null );
			
			LoginViewPanel loginViewPanel = new LoginViewPanel();
			this.add( loginViewPanel, BorderLayout.CENTER );
		});		
	}
}
