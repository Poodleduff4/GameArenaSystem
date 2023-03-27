import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutWindow extends JFrame {
//    JFrame cartFrame;
    JPanel cartPanel;
    JPanel ticketPanel;
    JLabel cartHeader;
    JPanel paymentPanel;
    JLabel nameLabel;
    JTextField nameTextField;
    JPanel namePanel;
    JLabel emailLabel;
    JTextField emailTextField;
    JPanel emailPanel;
    JLabel paymentLabel;
    JTextField paymentTextField;
    JPanel payPanel;
    JLabel securityLabel;
    JTextField securityTextField;
    JPanel securityPanel;
    JLabel monthLabel;
    JTextField monthTextField;
    JPanel monthPanel;
    JLabel yearLabel;
    JTextField yearTextField;
    JPanel yearPanel;
    JButton finishPurchaseButton;
    JLabel subtotal;
    JLabel tax;
    JLabel total;
    double seatSubtotal = 0.0;
    double seatTax;
    double seatTotal;


    CheckoutWindow() {
//        cartFrame = new JFrame("Cart");
        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        ticketPanel = new JPanel(new GridLayout(GameArenaSystem.cart.tickets.size() + 1, 1));


        for (Ticket seat : GameArenaSystem.cart.getCartItems()) {
            JLabel seatLabel = new JLabel("Section #: " + seat.sectionID + "\n" + " Seat #: " + seat.seatID + "\n" + " Row Number: " + seat.rowNum + " Price: $" + seat.seatPrice + "0");
            ticketPanel.add(seatLabel);
            seatSubtotal += seat.seatPrice;
        }
        seatTax = seatSubtotal * 0.13;
        seatTotal = seatSubtotal + seatTax;
        String subtotalText = String.format("Subtotal: $%.2f", seatSubtotal);
        String taxText = String.format("Tax: $%.2f", seatTax);
        String totalText = String.format("Total: $%.2f", seatTotal);
        subtotal = new JLabel(subtotalText);
        tax = new JLabel(taxText);
        total = new JLabel(totalText);

        cartPanel.add(ticketPanel, BorderLayout.SOUTH);
        cartPanel.add(subtotal);
        cartPanel.add(tax);
        cartPanel.add(total);

        paymentPanel = new JPanel();
        paymentPanel.setLayout(new BoxLayout(paymentPanel, BoxLayout.Y_AXIS));

        ticketPanel.add(cartHeader);

        nameLabel = new JLabel("Full Name:");
        nameTextField = new JTextField();
        nameTextField.setMaximumSize(new Dimension(200, 20));
        namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        namePanel.add(nameLabel);
        namePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        namePanel.add(nameTextField);
        paymentPanel.add(namePanel);

        paymentPanel.add(Box.createVerticalStrut(10));

        emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();
        emailTextField.setMaximumSize(new Dimension(200, 20));
        emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        emailPanel.add(emailLabel);
        emailPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        emailPanel.add(emailTextField);
        paymentPanel.add(emailPanel);

        paymentPanel.add(Box.createVerticalStrut(10));

        paymentLabel = new JLabel("Credit Card Number:");
        paymentTextField = new JTextField();
        paymentTextField.setMaximumSize(new Dimension(200, 20));
        payPanel = new JPanel();
        payPanel.setLayout(new BoxLayout(payPanel, BoxLayout.X_AXIS));
        payPanel.add(paymentLabel);
        payPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        payPanel.add(paymentTextField);
        paymentPanel.add(payPanel);

        paymentPanel.add(Box.createVerticalStrut(10));

        securityLabel = new JLabel("CVV:");
        securityTextField = new JTextField();
        securityTextField.setMaximumSize(new Dimension(200, 20));
        securityPanel = new JPanel();
        securityPanel.setLayout(new BoxLayout(securityPanel, BoxLayout.X_AXIS));
        securityPanel.add(securityLabel);
        securityPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        securityPanel.add(securityTextField);
        paymentPanel.add(securityPanel);

        paymentPanel.add(Box.createVerticalStrut(10));

        monthLabel = new JLabel("Month (MM):");
        monthTextField = new JTextField();
        monthTextField.setMaximumSize(new Dimension(200, 20));
        monthPanel = new JPanel();
        monthPanel.setLayout(new BoxLayout(monthPanel, BoxLayout.X_AXIS));
        monthPanel.add(monthLabel);
        monthPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        monthPanel.add(monthTextField);
        paymentPanel.add(monthPanel);

        paymentPanel.add(Box.createVerticalStrut(10));

        yearLabel = new JLabel("Year (YYYY):");
        yearTextField = new JTextField();
        yearTextField.setMaximumSize(new Dimension(200, 20));
        yearPanel = new JPanel();
        yearPanel.setLayout(new BoxLayout(yearPanel, BoxLayout.X_AXIS));
        yearPanel.add(yearLabel);
        yearPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        yearPanel.add(yearTextField);
        paymentPanel.add(yearPanel);

        cartPanel.add(paymentPanel);




        finishPurchaseButton = new JButton("Finish Purchase");

        finishPurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if all text fields are not empty
                Checkout checkout = new Checkout();
                if (emailTextField.getText().isEmpty() || paymentTextField.getText().isEmpty() ||
                        securityTextField.getText().isEmpty() || nameTextField.getText().isEmpty() || monthTextField.getText().isEmpty() ||
                        yearTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Please fill in all the fields.");
                } else if (!checkout.verifyEmail(emailTextField.getText())) {
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Please enter a valid email address.");
                } else if (!checkout.verifyPayment((paymentTextField.getText()))) {
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Please enter a valid 16-digit card number.");
                } else if (!checkout.verifyCVV((securityTextField.getText()))) {
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Please enter a valid 3-digit security code.");
                } else if (!checkout.verifyMonth((monthTextField.getText()))) {
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Please enter a valid expiration month (MM).");
                } else if (!checkout.verifyYear(Integer.parseInt(yearTextField.getText()))) {
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Please enter a valid expiration year (YYYY).");
                } else if (!checkout.verifyName(nameTextField.getText())) {
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Please enter a valid name (First Last)");
                } else {
                    // complete the purchase
                    JOptionPane.showMessageDialog(CheckoutWindow.this, "Thank you for your purchase!");
                    try {
                        TicketGenerator.generateTickets();
                    }
                    catch (Exception exc){
                        System.out.println("Cannot Generate Tickets");
                    }


                    CheckoutWindow.this.dispose();
                    GameArenaSystem.cart.clearCart();
                }

                // generate tickets

            }
        });


        cartPanel.add(finishPurchaseButton);

        this.add(cartPanel);
        this.setSize(400, 400);
        this.setVisible(true);

    }


}
