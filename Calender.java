import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdatepicker.impl.*;


public class Calender extends JFrame implements ActionListener {
	
	private JDatePickerImpl datePicker;
	
	public Calender() {
		super("Calendar");
		setLayout(new FlowLayout());
		
		add(new JLabel("Date: "));
		
		SqlDateModel model = new SqlDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		add(datePicker);
		
		JButton buttonOK = new JButton("OK");
		buttonOK.addActionListener(this);
		add(buttonOK);
		
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}
	
	public static void main(String[] args) {		
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Calender().setVisible(true);
			}
			
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		java.sql.Date selectedDate = (java.sql.Date) datePicker.getModel().getValue();
		JOptionPane.showMessageDialog(this, "The selected date is " + selectedDate);
		System.out.print(selectedDate);
	}
}