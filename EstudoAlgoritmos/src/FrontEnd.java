import javax.swing.*;

public class FrontEnd {
    private JFrame frame;
    private JTextField inputFieldBaseInicial, inputFieldNumeroInicial, inputFieldBaseFinal;
    private JTextArea resultBox, errorBox;
    private final int screenWidth = 600;
    private final int screenHeight = 800;
    private final int IWidth = 200;
    private final int IHeight = 30;
    private final int I1YPos = 100;
    private final int I2YPos = 200;
    private final int I3YPos = 300;
    private final int buttonWidth = 200;
    private final int resultWidth = 400;
    private final int resultYPos = 450;
    private final int resultHeight = 50;
    private final int errorBoxYPos = 500;
    private final int errorBoxHeight = 200;
    private final int errorBoxWidth = 400;

    public FrontEnd() {
        // Create a frame with a title
        frame = new JFrame("My First JFrame");

        // Create a panel to hold components
        JPanel panel = new JPanel(null); // Use null layout for explicit positioning

        // Create a JTextField for input
        inputFieldBaseInicial = new JTextField(20);
        inputFieldBaseInicial.setBounds((screenWidth - IWidth)/2, I1YPos, IWidth, IHeight);
        JLabel label1 = new JLabel("Base inicial:");
        label1.setBounds((screenWidth - IWidth)/2 - 100, I1YPos, 200, IHeight); // x, y, width, height

        inputFieldNumeroInicial = new JTextField(20);
        inputFieldNumeroInicial.setBounds((screenWidth - IWidth)/2, I2YPos, IWidth, IHeight);
        JLabel label2 = new JLabel("Número inicial:");
        label2.setBounds((screenWidth - IWidth)/2 - 100, I2YPos, 200, IHeight); // x, y, width, height

        inputFieldBaseFinal = new JTextField(20);
        inputFieldBaseFinal.setBounds((screenWidth - IWidth)/2, I3YPos, IWidth, IHeight);
        JLabel label3 = new JLabel("Base final:");
        label3.setBounds((screenWidth - IWidth)/2 - 100, I3YPos, 200, IHeight); // x, y, width, height


        resultBox = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultBox);
        scrollPane.setBounds((screenWidth - resultWidth)/2, resultYPos, resultWidth, resultHeight);

        errorBox = new JTextArea();
        JScrollPane scrollPane2 = new JScrollPane(errorBox);
        scrollPane2.setBounds((screenWidth - errorBoxWidth)/2, errorBoxYPos, errorBoxWidth, errorBoxHeight);

        // Create a JButton for calculation
        JButton calculateButton = new JButton("Calcular");
        calculateButton.addActionListener(e -> calculator());

        // Set the position of the button using setBounds
        calculateButton.setBounds((screenWidth - buttonWidth)/2, 400, buttonWidth, 30); // x, y, width, height

        // Add components to the panel
        panel.add(inputFieldBaseInicial);
        panel.add(label1);
        panel.add(inputFieldNumeroInicial);
        panel.add(label2);
        panel.add(inputFieldBaseFinal);
        panel.add(label3);
        panel.add(scrollPane);
        panel.add(scrollPane2);
        panel.add(calculateButton);

        // Set size, close operation, and visibility
        frame.setSize(screenWidth, screenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
    private void calculator() {
        // Retrieve the text from the input field
        String baseInicial = inputFieldBaseInicial.getText();
        String numeroInicial = inputFieldNumeroInicial.getText();
        String baseFinal = inputFieldBaseFinal.getText();

        resultBox.setText("o resultado é ");
        resultBox.append(baseInicial + "\n" +
                "base inicial = " + baseInicial + "\n" +
                "base final = " + baseFinal + "\n" +
                "numero inicial = " + numeroInicial);
    }
}
