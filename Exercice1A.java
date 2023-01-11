import java.awt.*;
import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercice1A extends Frame implements ActionListener {
    private TextField textF = null;
    private String bis ;
    private boolean bisbool;
    public Exercice1A() throws HeadlessException {
    }

    public Exercice1A(GraphicsConfiguration gc) {
        super(gc);
    }

    public Exercice1A(String title) throws HeadlessException {
        super(title);
        this.setLayout(new BorderLayout());
        this.textF = new TextField();
        this.add(this.textF,BorderLayout.NORTH);
        Panel panel = new Panel(new GridLayout(4,3));
        for (int i = 1; i < 10; i++) {
            Button button = new Button(Integer.toString(i));
            panel.add(button);
            button.addActionListener(this);
        }
        Button bis_btn = new Button("Bis");
        bis_btn.addActionListener(this);
        panel.add(bis_btn);
        Button zero_btn = new Button("0");
        zero_btn.addActionListener(this);
        panel.add(zero_btn);
        Button reset_btn = new Button("Reset");
        reset_btn.addActionListener(this);
        panel.add(reset_btn);
        this.add(panel,BorderLayout.CENTER);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public Exercice1A(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

    public static void main(String args[]){
         Exercice1A calcul = new Exercice1A("Untitled");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button btn_clicked = (Button)e.getSource();
        if(btn_clicked.getLabel().equals("Reset")) {
            try {
                this.bis = this.textF.getText();
                this.bisbool = true;
                this.textF.setText(null);
            } catch (Exception excp){
                System.out.println(excp);
            }
            return;
        }
        if(btn_clicked.getLabel().equals("Bis")) {
            try{
                System.out.println(this.bis);
                if(this.bisbool){
                    this.textF.setText(this.bis);
                    this.bisbool = false;
                }
            }catch(Exception excp){
                System.out.println(excp);
            }
            return;
        }
        this.textF.setText(this.textF.getText() + btn_clicked.getLabel());
    }
}
