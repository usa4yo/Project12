import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JCheckBox;

/**
 * Class        : CipherGUI
 * Project 12   : A secret Language
 * @author      : ar25 (Yves Ouellet)
 * Email        : yves.ouellet@bcbssc.com
 * Creation     : 2017-04-23
 * Last Mod.    : 2017-04-27
 * Due Date     : 2017-04-27
 *
 * GUI class for the Secret Language Cipher
 */


public class CipherGUI extends JFrame implements ActionListener{

    // Declare constants
    private static final int HEIGHT_SIZE = 300;
    private static final int WIDTH_SIZE = 400;
    private static final String BUTTON_INPUT_ENCODE = "Encode";
    private static final String BUTTON_INPUT_DECODE = "Decode";
    private static final String LABEL_INPUT_MESSAGE = "Enter the message you wish to encode or decode below";
    private static final String LABEL_INPUT_SUBSTITUTION = "substitution shifts";
    private static final String LABEL_INPUT_TRANSPOSITION = "transposition cycles";
    private static final String LABEL_INPUT_NEW_MESSAGE = "New Message:";    
    private static final String CHECKBOX_SUBSTITUTION = "Use Substitution";
    private static final String CHECKBOX_TRANSPOSITION = "Use Transposition";
    private static final String CIPHER_TITLE = "Cipher";
    
    // Declare Object
	private Container contentPane;
	
	// Declare JButton
	private JButton btnEncode = new JButton(BUTTON_INPUT_ENCODE);
	private JButton btnDecode = new JButton(BUTTON_INPUT_DECODE);

	// Declare JLabel
	private JLabel lblInput = new JLabel(LABEL_INPUT_MESSAGE);
	private JLabel lblSub = new JLabel(LABEL_INPUT_SUBSTITUTION);
	private JLabel lblTrans = new JLabel(LABEL_INPUT_TRANSPOSITION);
	private JLabel resultsTitleLabel = new JLabel(LABEL_INPUT_NEW_MESSAGE);

	// Declare JTextField
	private JTextField txtShift = new JTextField();
	private JTextField txtShuffle = new JTextField();
	private JTextField txtInput = new JTextField();
	private JTextField txtOutput = new JTextField();
	
	// Declare JCheckBox
	private JCheckBox chckbxSubstitution = new JCheckBox(CHECKBOX_SUBSTITUTION);
	private JCheckBox chckbxTransposition = new JCheckBox(CHECKBOX_TRANSPOSITION);
	
	// Cipher GUI method
	CipherGUI(){
		super();
		this.setTitle(CIPHER_TITLE);
		this.setSize(HEIGHT,WIDTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.contentPane = getContentPane();
		
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, txtOutput, 6, SpringLayout.SOUTH, resultsTitleLabel);
		springLayout.putConstraint(SpringLayout.WEST, txtOutput, 0, SpringLayout.WEST, lblInput);
		springLayout.putConstraint(SpringLayout.EAST, txtOutput, 0, SpringLayout.EAST, lblInput);
		springLayout.putConstraint(SpringLayout.NORTH, resultsTitleLabel, 27, SpringLayout.SOUTH, btnEncode);
		springLayout.putConstraint(SpringLayout.WEST, resultsTitleLabel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnDecode, 0, SpringLayout.NORTH, btnEncode);
		springLayout.putConstraint(SpringLayout.WEST, btnDecode, 6, SpringLayout.EAST, btnEncode);
		springLayout.putConstraint(SpringLayout.NORTH, btnEncode, 35, SpringLayout.SOUTH, chckbxSubstitution);
		springLayout.putConstraint(SpringLayout.WEST, btnEncode, 0, SpringLayout.WEST, lblInput);
		springLayout.putConstraint(SpringLayout.NORTH, lblTrans, 3, SpringLayout.NORTH, txtShuffle);
		springLayout.putConstraint(SpringLayout.WEST, lblTrans, 6, SpringLayout.EAST, txtShuffle);
		springLayout.putConstraint(SpringLayout.NORTH, lblSub, 3, SpringLayout.NORTH, txtShift);
		springLayout.putConstraint(SpringLayout.WEST, lblSub, 6, SpringLayout.EAST, txtShift);
		springLayout.putConstraint(SpringLayout.WEST, txtShuffle, 1, SpringLayout.EAST, chckbxTransposition);
		springLayout.putConstraint(SpringLayout.NORTH, txtShift, 1, SpringLayout.NORTH, chckbxSubstitution);
		springLayout.putConstraint(SpringLayout.WEST, txtShift, 0, SpringLayout.WEST, txtShuffle);
		springLayout.putConstraint(SpringLayout.NORTH, txtShuffle, 1, SpringLayout.NORTH, chckbxTransposition);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxSubstitution, 6, SpringLayout.SOUTH, chckbxTransposition);
		springLayout.putConstraint(SpringLayout.WEST, chckbxSubstitution, 0, SpringLayout.WEST, lblInput);
		springLayout.putConstraint(SpringLayout.NORTH, chckbxTransposition, 6, SpringLayout.SOUTH, txtInput);
		springLayout.putConstraint(SpringLayout.WEST, chckbxTransposition, 0, SpringLayout.WEST, lblInput);
		springLayout.putConstraint(SpringLayout.NORTH, txtInput, 12, SpringLayout.SOUTH, lblInput);
		springLayout.putConstraint(SpringLayout.WEST, txtInput, 0, SpringLayout.WEST, lblInput);
		springLayout.putConstraint(SpringLayout.EAST, txtInput, 0, SpringLayout.EAST, lblInput);
		springLayout.putConstraint(SpringLayout.NORTH, lblInput, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblInput, 10, SpringLayout.WEST, getContentPane());

		getContentPane().setLayout(springLayout);

		this.contentPane.add(this.lblInput);
		this.contentPane.add(this.txtOutput);
		this.contentPane.add(this.txtInput);
		this.contentPane.add(this.btnEncode);
		this.contentPane.add(this.btnDecode);
		this.contentPane.add(this.txtShift);
		this.txtShift.setColumns(3);
		this.txtShift.setText("1");
		this.contentPane.add(this.txtShuffle);
		this.txtShuffle.setColumns(3);
		this.txtShuffle.setText("1");
		this.contentPane.add(chckbxSubstitution);
		this.contentPane.add(chckbxTransposition);
		this.contentPane.add(lblSub);
		this.contentPane.add(lblTrans);
		this.contentPane.add(resultsTitleLabel);
		this.btnEncode.addActionListener(this);
		this.btnDecode.addActionListener(this);
		
	}//End bracket of constructor constructor
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = txtInput.getText();
		SubstitutionCipher sub = new SubstitutionCipher(Integer.parseInt(txtShift.getText()));
		TranspositionCipher trans = new TranspositionCipher(Integer.parseInt(txtShuffle.getText()));
		
		if(chckbxSubstitution.isSelected() && chckbxTransposition.isSelected()){
			txtOutput.setText("Come one man one at a time.");
		}else if(chckbxSubstitution.isSelected()){
			if(e.getSource() == this.btnEncode){
				txtOutput.setText(sub.encode(input));
			}else if(e.getSource() == this.btnDecode){
				txtOutput.setText(sub.decode(input));
			}  // End bracket of inner if statement 
		}else if(chckbxTransposition.isSelected()){
			if(e.getSource() == this.btnEncode){
				txtOutput.setText(trans.encode(input));
			} else if(e.getSource() == this.btnDecode){
				txtOutput.setText(trans.decode(input));
			}  // End bracket of inner if statement 
			
		}// End bracket of outer if statement
		
	} // End bracket of actionPerformed method
	
}   // End bracket of CipherGUI class
