package mx.com.rottenapplerepairs.dialog;

import java.awt.Color;	
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import info.clearthought.layout.TableLayout;

/**
 *
 * @author iamezcua.dev
 */
public class LoginViewPanel extends JPanel {
	/***
	 *      ______ _      _     _   _____        __ _       _ _   _             
	 *     |  ____(_)    | |   | | |  __ \      / _(_)     (_) | (_)            
	 *     | |__   _  ___| | __| | | |  | | ___| |_ _ _ __  _| |_ _  ___  _ __  
	 *     |  __| | |/ _ \ |/ _` | | |  | |/ _ \  _| | '_ \| | __| |/ _ \| '_ \ 
	 *     | |    | |  __/ | (_| | | |__| |  __/ | | | | | | | |_| | (_) | | | |
	 *     |_|    |_|\___|_|\__,_| |_____/ \___|_| |_|_| |_|_|\__|_|\___/|_| |_|
	 *                                                                          
	 *                                                                          
	 */
	
	private static final long serialVersionUID = -4333855590146257045L;
	private TableLayout loginViewLayout;
    private JLabel labelEnterpriseLogo;
    private Icon enterpriseLogoIcon;
    private JTextField userNameField;
    private JLabel userNameLabel;
    private JPasswordField userPasswordField;
    private JLabel passwordLabel;
    private JButton actionButton;
    
    /***
     *       _____                _                   _                 
     *      / ____|              | |                 | |                
     *     | |     ___  _ __  ___| |_ _ __ _   _  ___| |_ ___  _ __ ___ 
     *     | |    / _ \| '_ \/ __| __| '__| | | |/ __| __/ _ \| '__/ __|
     *     | |___| (_) | | | \__ \ |_| |  | |_| | (__| || (_) | |  \__ \
     *      \_____\___/|_| |_|___/\__|_|   \__,_|\___|\__\___/|_|  |___/
     *                                                                  
     *                                                                  
     */
    
    /**
     * 
     */
    public LoginViewPanel() {
    	
    	//	Configuration helper variables
    	Double p = TableLayout.PREFERRED;
    	Double f = TableLayout.FILL;
    	
    	// Column and row specification
    	double[] colSpec = new double[] { 10, f, 10, f, 10 };
    	double[] rowSpec = new double[] { 10, f, 5, p, 5, p, 5, p, 10 };
    	loginViewLayout = new TableLayout( colSpec, rowSpec );
    	
    	//	LoginViewPanel layout settings
        setLayout( loginViewLayout );
        setBorder( BorderFactory.createEtchedBorder( EtchedBorder.RAISED ) );
        setBackground( Color.WHITE );
        
        /*
         * Component configuration
         */
        Dimension fieldsSize = new Dimension( 150, 40 );        
        Font componentsFont = new Font( "Century Gothic", Font.PLAIN, 16 );
        Font componentsFont2 = new Font( "Century Gothic", Font.BOLD, 16 );
        
        // Enterprise logo (JLabel) ( row: 1, column: 1 )
        URL enterpriseImageURL = getClass().getResource("/mx/com/rottenapplerepairs/RottenAppleRepairsLogo_200x200.png");
        enterpriseLogoIcon = new ImageIcon( enterpriseImageURL );
        labelEnterpriseLogo = new JLabel( enterpriseLogoIcon );
        
        // Username label
        userNameLabel = new JLabel( "Usuario" );
        userNameLabel.setHorizontalAlignment( SwingUtilities.CENTER);
        userNameLabel.setFont( componentsFont );
        
        // Password label
        passwordLabel = new JLabel( "Contraseña" );
        passwordLabel.setHorizontalAlignment( SwingUtilities.CENTER);
        passwordLabel.setFont( componentsFont );
        
        // Username input field
        userNameField = new JTextField( "" );
        userNameField.setAlignmentY( SwingConstants.CENTER 	);
        userNameField.setHorizontalAlignment( SwingUtilities.CENTER );
        userNameField.setCaretColor( Color.WHITE );
        userNameField.setPreferredSize( fieldsSize );
        userNameField.setFont( componentsFont2 );
        userNameField.addKeyListener( fieldsKeyAdapter() );
        
        // Password input field
        userPasswordField = new JPasswordField( "" );
        userPasswordField.setAlignmentY( SwingConstants.CENTER );
        userPasswordField.setHorizontalAlignment( SwingUtilities.CENTER );
        userPasswordField.setCaretColor( Color.WHITE );
        userPasswordField.setPreferredSize( fieldsSize );
        userPasswordField.setFont( componentsFont2 );
        userPasswordField.addKeyListener( fieldsKeyAdapter() );
        
        // Command button
        Dimension commandButtonSize = new Dimension( 200, 40 );
        actionButton = new JButton( "Iniciar Sesión" );
        actionButton.addKeyListener( fieldsKeyAdapter() );
        actionButton.addMouseListener( actionButtonMouseAdapter() );
        actionButton.setPreferredSize( commandButtonSize );
        actionButton.setFont( componentsFont2 );
        Color foregroundColor = new Color( 255, 239, 213 );
        Color backgroundColor = new Color( 100, 149, 237 );
        actionButton.setForeground( foregroundColor );
        actionButton.setBackground( backgroundColor );
        
        // Putting components into LoginViewPanel
        add( labelEnterpriseLogo, "1, 1, 3, 1" );
        add( userNameField		, "1, 3" );
        add( userPasswordField	, "3, 3" );
        add( userNameLabel		, "1, 5" );
        add( passwordLabel		, "3, 5" );
        add( actionButton 		, "1, 7, 3, 7" );
    }

    /***
     *      ______               _     _    _                 _ _               
     *     |  ____|             | |   | |  | |               | | |              
     *     | |____   _____ _ __ | |_  | |__| | __ _ _ __   __| | | ___ _ __ ___ 
     *     |  __\ \ / / _ \ '_ \| __| |  __  |/ _` | '_ \ / _` | |/ _ \ '__/ __|
     *     | |___\ V /  __/ | | | |_  | |  | | (_| | | | | (_| | |  __/ |  \__ \
     *     |______\_/ \___|_| |_|\__| |_|  |_|\__,_|_| |_|\__,_|_|\___|_|  |___/
     *                                                                          
     *                                                                          
     */
    
    /**
     * 
     * @return
     */
	private MouseListener actionButtonMouseAdapter() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( e.getClickCount() == 1 ) {
					showInformationMessage( formValidator() );
				}
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private KeyListener fieldsKeyAdapter() {
		return new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if( e.getKeyCode() == KeyEvent.VK_ENTER ) {
        			showInformationMessage( formValidator() );
        		}
        	}
		};
	}
	
	/***
	 *      __  __      _   _               _     
	 *     |  \/  |    | | | |             | |    
	 *     | \  / | ___| |_| |__   ___   __| |___ 
	 *     | |\/| |/ _ \ __| '_ \ / _ \ / _` / __|
	 *     | |  | |  __/ |_| | | | (_) | (_| \__ \
	 *     |_|  |_|\___|\__|_| |_|\___/ \__,_|___/
	 *                                            
	 *                                            
	 */
	
	/**
	 * 
	 * @return
	 */
	private boolean formValidator() {
		String user = "eddie";
		String pass = "jobs";
		
		String providedPassword = new String( getPasswordField().getPassword() );
		getPasswordField().setText("");
		
		return getusernameField().getText().equals( user ) && providedPassword.equals( pass );
	}
    
	/**
	 * 
	 * @param result
	 */
	private void showInformationMessage( boolean result ) {
		if( result ) {
			JOptionPane.showMessageDialog( null, "Iniciando sesión ..." );
		} else {
			JOptionPane.showMessageDialog( null, "Usuario y/o contraseña inválidos ...");
		}	
	}
	
    /**
     *      _____      _   _                                  _    _____      _   _                
     *     / ____|    | | | |                                | |  / ____|    | | | |               
     *    | |  __  ___| |_| |_ ___ _ __ ___    __ _ _ __   __| | | (___   ___| |_| |_ ___ _ __ ___ 
     *    | | |_ |/ _ \ __| __/ _ \ '__/ __|  / _` | '_ \ / _` |  \___ \ / _ \ __| __/ _ \ '__/ __|
     *    | |__| |  __/ |_| ||  __/ |  \__ \ | (_| | | | | (_| |  ____) |  __/ |_| ||  __/ |  \__ \
     *     \_____|\___|\__|\__\___|_|  |___/  \__,_|_| |_|\__,_| |_____/ \___|\__|\__\___|_|  |___/
     *                                                                                            
     */
	
	/**
	 * 
	 * @return
	 */
	public JTextField getusernameField() {
    	return this.userNameField;
    }
	
	/**
	 * 
	 * @return
	 */
    public JPasswordField getPasswordField() {
    	return this.userPasswordField;
    }
	
}
