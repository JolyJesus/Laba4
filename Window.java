import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.math.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Window extends JFrame {
	  private JLabel countLabel;
	  private JLabel itterlab, txt, txt2, txt3;
   	private JButton btn1;
	  private JButton removeCrow;
	  public int result;
	 public int iter;
	 public int value4;
	    JTextField smallField, bigField;

	    
		public Window() {
			super ("Лабораторна робота №5, Виконав: Сулимка Роман");
			setBounds (100, 100, 600, 600);//size window
			countLabel = new JLabel("Формула: 1 + 2 + 3 + 4 + 5 + 6 ...                                                   ");
			itterlab = new JLabel ("Кількість іттерацій: ");
			txt = new JLabel ("Кількість потоків: ");
			txt2 = new JLabel ("Виконувані дії: ");
			txt3 = new JLabel ("Прогрес виконання: ");
			//Подготавливаем временные компоненты
		    JPanel buttonsPanel = new JPanel(new FlowLayout()); 
		    JPanel buttonsPanel2 = new JPanel(new FlowLayout());
		    JPanel buttonsPanel3 = new JPanel(new FlowLayout());
		    JPanel buttonsPanel4 = new JPanel(new FlowLayout());
		    //Расставляем компоненты по местам
		    buttonsPanel.add(countLabel, BorderLayout.EAST); //О размещении компонент поговорим позже

		    //buttonsPanel.add(addCrow);
		    //buttonsPanel.add(removeCrow);

		    add(buttonsPanel, BorderLayout.NORTH);
			add(buttonsPanel2, BorderLayout.CENTER);
			add(buttonsPanel3, BorderLayout.SOUTH);
			add(buttonsPanel4, BorderLayout.WEST);
			 
	            //spinner.setBounds(50,50,50,50);    
	           
	            //spinner.add(countLabel, BorderLayout.CENTER);
	            //setSize(300,300);    
	            //setLayout(null);    
	            //setVisible(true);   
			//btn1 = new JButton("");
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Вирубаємо прогу	
			
			buttonsPanel.add(itterlab, BorderLayout.EAST); //кількість ітерацій
			SpinnerModel iter = 
					new SpinnerNumberModel(10000, 
					100,
					100000,
					1);  
			JSpinner spinner = new JSpinner(iter);   
			 //spinner.setPreferredSize(new Dimension(50,100));
			 buttonsPanel.add(spinner, BorderLayout.EAST);
			 
			 try {
		            spinner.commitEdit();
		        } catch ( java.text.ParseException e ) {}
		         value4 = (Integer) spinner.getValue();
		        
			 buttonsPanel2.add(txt, BorderLayout.WEST); //кількість потоків
			 SpinnerModel potk = 
						new SpinnerNumberModel(1, 
						1,
						100,
						1);  
			 
			 
				JSpinner spinner2 = new JSpinner(potk);   
		        buttonsPanel2.add(spinner2, BorderLayout.WEST);
		        
		        
		        try {
		            spinner2.commitEdit();
		        } catch ( java.text.ParseException e ) {}
		         value4 = (Integer) spinner2.getValue();
		        
		        
		        
		        
		        JButton button = new JButton("Запустити паралельні обчислення"); //батон д
		      // button.addActionListener(null);
 		        button.setBounds(50, 100, 95, 30);
		        buttonsPanel2.add(button, BorderLayout.CENTER);
		        button.addActionListener(new ActionListener() {
		        	 public void actionPerformed(ActionEvent ae) {
		        		 for (int i = 1; i < value4; i++) result+=i;
		        		 
		        	            new Thread(() -> {
		        	                for (int j = 1; j <=value4; j++) {
		        	                	
		        	                }
		        	                
		        	            }).start(); // <-- .start() makes the thread start running   
		        	        }

		        	 }
		        
		        		);
		        //button.addActionListener((ActionListener) this);
		        
		        
		        JButton button2 = new JButton ("stop");
		        button2.setBounds(50, 100, 95, 30);
		        buttonsPanel3.add(button2, BorderLayout.CENTER);
		        
		        
		        JButton button3 = new JButton ("pause");
		        button3.setBounds(50, 100, 95, 30);
		        buttonsPanel3.add(button3, BorderLayout.CENTER);
		        
		        
		        buttonsPanel3.add(txt2, BorderLayout.NORTH);
		        JTextArea txt1 = new JTextArea(8, 40);
		       
		        
		        txt1.setText(" "+result);
		        txt1.setEditable(false); //блокую ввід в текстбокс

		        txt1.setFont(new Font("Dialog", Font.PLAIN, 14));
		        txt1.setTabSize(10);
		        buttonsPanel3.add(txt1, BorderLayout.CENTER);
		        button.addActionListener(new ActionListener() {
		        	 public void actionPerformed(ActionEvent ae) {
		        	 txt1.setText("Програма почала своє виконання, автор Сулимка Роман");
		        	 }

		        	 }
		        
		        		);
		        
		        JProgressBar progressBar = new JProgressBar();
		        progressBar.setIndeterminate(true);
		        progressBar.setForeground(Color.BLUE);
		        
		        buttonsPanel4.add(txt3, BorderLayout.NORTH);
		        buttonsPanel4.add(progressBar, BorderLayout.WEST);
		}
		
		
        public void run() {
        	//button.this;
        	for (int i = 0; i < iter; i++) {
            new Thread(() -> {
                for (int j = 1; j <=value4; j++) result+=j;{
                	
                }
                
            }).start(); // <-- .start() makes the thread start running   
        }
        
        }
		
		
	public static void main(String[] args) {
		Window app = new Window();
		
		app.setVisible(true);//тіпа запускаємо
		app.pack();//оптимальний розмір
	}
		}
