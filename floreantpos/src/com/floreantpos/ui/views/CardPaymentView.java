/*
 * CardView.java
 *
 * Created on August 25, 2006, 1:39 PM
 */

package com.floreantpos.ui.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.floreantpos.main.Application;
import com.floreantpos.model.CreditCardTransaction;
import com.floreantpos.model.DebitCardTransaction;
import com.floreantpos.swing.DoubleDocument;
import com.floreantpos.ui.dialog.POSMessageDialog;
import com.floreantpos.ui.views.order.RootView;

/**
 *
 * @author  MShahriar
 */
public class CardPaymentView extends PaymentView {
	public final static int CARD_TYPE_CREDIT = 0;
	public final static int CARD_TYPE_DEBIT = 1;

	public final static String MASTER_CARD = "MASTER_CARD";
	public final static String VISA_CARD = "VISA_CARD";
	public final static String EMEX_CARD = "EMEX_CARD";
	public final static String DISCOVER_CARD = "DISCOVER_CARD";

	private int cardType = CARD_TYPE_CREDIT;
	private String whichCard = MASTER_CARD;

	private double gratuityAmount;

	/** Creates new form CardView */
	public CardPaymentView() {
		initComponents();

		DoubleDocument gratuityDocument = new DoubleDocument();
		gratuityDocument.addDocumentListener(new DocumentListener() {
			void updatePayAmount() {
				double cardAmount = 0;
				double gratuity = 0;

				try {
					gratuity = Double.parseDouble(tfGratuityAmount.getText());
				} catch (Exception x) {
				}
				cardAmount = getDueAmount();
				tfCardAmount.setText(Application.formatNumber(cardAmount + gratuity));
			}

			public void insertUpdate(DocumentEvent e) {
				updatePayAmount();
			}

			public void removeUpdate(DocumentEvent e) {
				updatePayAmount();
			}

			public void changedUpdate(DocumentEvent e) {
				updatePayAmount();
			}

		});
		tfGratuityAmount.setDocument(gratuityDocument);
		tfCardAmount.setDocument(new DoubleDocument());
	}

	Dimension preferredSize = new Dimension(380, 100);

	public Dimension getPreferredSize() {
		return preferredSize;
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		buttonGroup1 = new javax.swing.ButtonGroup();
		transparentPanel3 = new com.floreantpos.swing.TransparentPanel();
		transparentPanel5 = new com.floreantpos.swing.TransparentPanel();
		btnChangePMethod = new com.floreantpos.swing.PosButton();
		btnCancel = new com.floreantpos.swing.PosButton();
		btnSettle = new com.floreantpos.swing.PosButton();
		transparentPanel8 = new com.floreantpos.swing.TransparentPanel();
		transparentPanel9 = new com.floreantpos.swing.TransparentPanel();
		posButton1 = new com.floreantpos.swing.PosButton();
		posButton2 = new com.floreantpos.swing.PosButton();
		posButton3 = new com.floreantpos.swing.PosButton();
		posButton4 = new com.floreantpos.swing.PosButton();
		posButton5 = new com.floreantpos.swing.PosButton();
		posButton6 = new com.floreantpos.swing.PosButton();
		posButton9 = new com.floreantpos.swing.PosButton();
		posButton8 = new com.floreantpos.swing.PosButton();
		posButton7 = new com.floreantpos.swing.PosButton();
		posButton10 = new com.floreantpos.swing.PosButton();
		posButton11 = new com.floreantpos.swing.PosButton();
		posButton12 = new com.floreantpos.swing.PosButton();
		transparentPanel10 = new com.floreantpos.swing.TransparentPanel();
		btnMasterCard = new com.floreantpos.swing.POSToggleButton();
		btnVisa = new com.floreantpos.swing.POSToggleButton();
		btnEmEx = new com.floreantpos.swing.POSToggleButton();
		btnDiscover = new com.floreantpos.swing.POSToggleButton();
		transparentPanel7 = new com.floreantpos.swing.TransparentPanel();
		transparentPanel1 = new com.floreantpos.swing.TransparentPanel();
		jLabel1 = new javax.swing.JLabel();
		tfGratuityAmount = new javax.swing.JTextField();
		lblCSymbol1 = new javax.swing.JLabel();
		transparentPanel4 = new com.floreantpos.swing.TransparentPanel();
		jLabel3 = new javax.swing.JLabel();
		tfAuthorizationCode = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		transparentPanel2 = new com.floreantpos.swing.TransparentPanel();
		jLabel2 = new javax.swing.JLabel();
		tfCardAmount = new javax.swing.JTextField();
		lblCSymbol2 = new javax.swing.JLabel();

		setLayout(new java.awt.BorderLayout(0, 5));

		setBorder(javax.swing.BorderFactory.createTitledBorder(null, com.floreantpos.POSConstants.TITLE, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		transparentPanel3.setLayout(new java.awt.BorderLayout());

		add(transparentPanel3, java.awt.BorderLayout.WEST);

		transparentPanel5.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

		transparentPanel5.setPreferredSize(new java.awt.Dimension(100, 60));
		btnChangePMethod.setText("<html><body><p align='center'>CHANGE PAYMENT METHOD</p></body></html>");
		btnChangePMethod.setFocusable(false);
		btnChangePMethod.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChangePMethodActionPerformed(evt);
			}
		});

		transparentPanel5.add(btnChangePMethod);

		btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_32.png")));
		btnCancel.setText(com.floreantpos.POSConstants.CANCEL);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelActionPerformed(evt);
			}
		});

		transparentPanel5.add(btnCancel);

		btnSettle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settle_ticket_32.png")));
		btnSettle.setText(com.floreantpos.POSConstants.SETTLE);
		btnSettle.setFocusable(false);
		btnSettle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSettleActionPerformed(evt);
			}
		});

		transparentPanel5.add(btnSettle);

		add(transparentPanel5, java.awt.BorderLayout.SOUTH);

		transparentPanel8.setLayout(new java.awt.GridBagLayout());

		transparentPanel9.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

		posButton1.setAction(calAction);
		posButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7_32.png")));
		posButton1.setActionCommand("7");
		posButton1.setFocusable(false);
		transparentPanel9.add(posButton1);

		posButton2.setAction(calAction);
		posButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8_32.png")));
		posButton2.setActionCommand("8");
		posButton2.setFocusable(false);
		transparentPanel9.add(posButton2);

		posButton3.setAction(calAction);
		posButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/9_32.png")));
		posButton3.setActionCommand("9");
		posButton3.setFocusable(false);
		transparentPanel9.add(posButton3);

		posButton4.setAction(calAction);
		posButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4_32.png")));
		posButton4.setActionCommand("4");
		posButton4.setFocusable(false);
		transparentPanel9.add(posButton4);

		posButton5.setAction(calAction);
		posButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5_32.png")));
		posButton5.setActionCommand("5");
		posButton5.setFocusable(false);
		transparentPanel9.add(posButton5);

		posButton6.setAction(calAction);
		posButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6_32.png")));
		posButton6.setActionCommand("6");
		posButton6.setFocusable(false);
		transparentPanel9.add(posButton6);

		posButton9.setAction(calAction);
		posButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1_32.png")));
		posButton9.setActionCommand("1");
		posButton9.setFocusable(false);
		transparentPanel9.add(posButton9);

		posButton8.setAction(calAction);
		posButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2_32.png")));
		posButton8.setActionCommand("2");
		posButton8.setFocusable(false);
		transparentPanel9.add(posButton8);

		posButton7.setAction(calAction);
		posButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3_32.png")));
		posButton7.setActionCommand("3");
		posButton7.setFocusable(false);
		transparentPanel9.add(posButton7);

		posButton10.setAction(calAction);
		posButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dot_32.png")));
		posButton10.setActionCommand(".");
		posButton10.setFocusable(false);
		transparentPanel9.add(posButton10);

		posButton11.setAction(calAction);
		posButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0_32.png")));
		posButton11.setActionCommand("0");
		posButton11.setFocusable(false);
		transparentPanel9.add(posButton11);

		posButton12.setAction(calAction);
		posButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear_32.png")));
		posButton12.setText(com.floreantpos.POSConstants.CLEAR);
		posButton12.setFocusable(false);
		transparentPanel9.add(posButton12);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
		transparentPanel8.add(transparentPanel9, gridBagConstraints);

		transparentPanel10.setLayout(new java.awt.GridLayout(0, 1, 5, 5));

		buttonGroup1.add(btnMasterCard);
		btnMasterCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/master_card.PNG")));
		btnMasterCard.setSelected(true);
		btnMasterCard.setActionCommand("MASTER_CARD");
		btnMasterCard.setPreferredSize(new java.awt.Dimension(90, 0));
		transparentPanel10.add(btnMasterCard);

		buttonGroup1.add(btnVisa);
		btnVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/visa_card.PNG")));
		btnVisa.setActionCommand("VISA_CARD");
		btnVisa.setPreferredSize(new java.awt.Dimension(90, 0));
		transparentPanel10.add(btnVisa);

		buttonGroup1.add(btnEmEx);
		btnEmEx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/am_ex_card.PNG")));
		btnEmEx.setActionCommand("EMEX_CARD");
		btnEmEx.setPreferredSize(new java.awt.Dimension(90, 0));
		transparentPanel10.add(btnEmEx);

		buttonGroup1.add(btnDiscover);
		btnDiscover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/discover_card.PNG")));
		btnDiscover.setActionCommand("DISCOVER_CARD");
		btnDiscover.setPreferredSize(new java.awt.Dimension(90, 0));
		transparentPanel10.add(btnDiscover);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
		transparentPanel8.add(transparentPanel10, gridBagConstraints);

		transparentPanel7.setLayout(new java.awt.GridLayout(0, 1, 5, 5));

		transparentPanel1.setLayout(new java.awt.BorderLayout(5, 5));

		transparentPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		jLabel1.setText("Gratuity Amount");
		transparentPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

		tfGratuityAmount.setFont(new java.awt.Font("Tahoma", 1, 12));
		tfGratuityAmount.setText("0");
		transparentPanel1.add(tfGratuityAmount, java.awt.BorderLayout.CENTER);

		lblCSymbol1.setText(Application.getCurrencySymbol());
		transparentPanel1.add(lblCSymbol1, java.awt.BorderLayout.WEST);

		transparentPanel7.add(transparentPanel1);

		transparentPanel4.setLayout(new java.awt.BorderLayout(5, 5));

		transparentPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		jLabel3.setText("Authorization Code");
		transparentPanel4.add(jLabel3, java.awt.BorderLayout.NORTH);

		tfAuthorizationCode.setFont(new java.awt.Font("Tahoma", 1, 12));
		tfAuthorizationCode.setText("0");
		transparentPanel4.add(tfAuthorizationCode, java.awt.BorderLayout.CENTER);

		jLabel4.setText("  ");
		transparentPanel4.add(jLabel4, java.awt.BorderLayout.WEST);

		transparentPanel7.add(transparentPanel4);

		transparentPanel2.setLayout(new java.awt.BorderLayout(5, 5));

		transparentPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		jLabel2.setText("Amount Charged to Card");
		transparentPanel2.add(jLabel2, java.awt.BorderLayout.NORTH);

		tfCardAmount.setFont(new java.awt.Font("Tahoma", 1, 12));
		tfCardAmount.setText("0");
		transparentPanel2.add(tfCardAmount, java.awt.BorderLayout.CENTER);

		lblCSymbol2.setText(Application.getCurrencySymbol());
		transparentPanel2.add(lblCSymbol2, java.awt.BorderLayout.WEST);

		transparentPanel7.add(transparentPanel2);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
		transparentPanel8.add(transparentPanel7, gridBagConstraints);

		add(transparentPanel8, java.awt.BorderLayout.CENTER);

	}// </editor-fold>//GEN-END:initComponents

	private void btnSettleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettleActionPerformed
		try {
			try {
				String gratuity = tfGratuityAmount.getText();
				if (gratuity == null || gratuity.trim().equals("")) {
					gratuityAmount = 0;
				}
				else {
					gratuityAmount = Double.parseDouble(gratuity);
				}
			} catch (NumberFormatException x) {
				POSMessageDialog.showError("Gratuity amount is not valid");
				return;
			}
			double tenderedAmount = 0;
			try {
				tenderedAmount = Double.parseDouble(tfCardAmount.getText());
			} catch (NumberFormatException x) {
				POSMessageDialog.showError("Amount is not valid");
				return;
			}
			tenderedAmount = tenderedAmount - gratuityAmount;
			if (tenderedAmount < 0) {
				POSMessageDialog.showError("Insufficient amount");
				return;
			}

			String authorizationCode = tfAuthorizationCode.getText();
			if (getCardType() == CARD_TYPE_CREDIT) {
				
				settleTickets(tenderedAmount, gratuityAmount, new CreditCardTransaction(), getWhichCard(), authorizationCode);
			}
			if (getCardType() == CARD_TYPE_DEBIT) {
				settleTickets(tenderedAmount, gratuityAmount, new DebitCardTransaction(), getWhichCard(), authorizationCode);
			}
		} catch (Exception e) {
			POSMessageDialog.showError("An unexpected error has occured, you may need to restart the application", e);
		}
	}//GEN-LAST:event_btnSettleActionPerformed

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
		RootView.getInstance().showView(SwitchboardView.VIEW_NAME);
	}//GEN-LAST:event_btnCancelActionPerformed

	private void btnChangePMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePMethodActionPerformed
		changePaymentMethod();
	}//GEN-LAST:event_btnChangePMethodActionPerformed

	private JTextField getFocusedTextField() {
		if (tfGratuityAmount.hasFocus()) {
			return tfGratuityAmount;
		}
		if (tfAuthorizationCode.hasFocus()) {
			return tfAuthorizationCode;
		}
		if (tfCardAmount.hasFocus()) {
			return tfCardAmount;
		}
		tfGratuityAmount.requestFocus();
		return tfGratuityAmount;
	}

	private Action calAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			JTextField tf = getFocusedTextField();

			String s = e.getActionCommand();
			if (s.equals(com.floreantpos.POSConstants.CLEAR)) {
				tf.setText("0");
			}
			else if (s.equals(".")) {
				if (tf == tfAuthorizationCode) {
					return;
				}
				if (tf.getText().indexOf('.') < 0) {
					tf.setText(tf.getText() + ".");
				}
			}
			else {
				String string = tf.getText();
				int index = string.indexOf('.');
				if (index < 0) {
					double value = 0;
					try {
						value = Double.parseDouble(string);
					} catch (NumberFormatException x) {
						Toolkit.getDefaultToolkit().beep();
					}
					if (value == 0) {
						tf.setText(s);
					}
					else {
						tf.setText(string + s);
					}
				}
				else {
					tf.setText(string + s);
				}
			}
			if (tf == tfGratuityAmount) {
				double gAmount = 0;
				double amount = getDueAmount();
				try {
					gAmount = Double.parseDouble(tfGratuityAmount.getText());
				} catch (NumberFormatException x) {
					Toolkit.getDefaultToolkit().beep();
					return;
				}
				tfCardAmount.setText(Application.formatNumber(amount + gAmount));
			}
		}
	};

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.floreantpos.swing.PosButton btnCancel;
	private com.floreantpos.swing.PosButton btnChangePMethod;
	private com.floreantpos.swing.POSToggleButton btnDiscover;
	private com.floreantpos.swing.POSToggleButton btnEmEx;
	private com.floreantpos.swing.POSToggleButton btnMasterCard;
	private com.floreantpos.swing.PosButton btnSettle;
	private com.floreantpos.swing.POSToggleButton btnVisa;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel lblCSymbol1;
	private javax.swing.JLabel lblCSymbol2;
	private com.floreantpos.swing.PosButton posButton1;
	private com.floreantpos.swing.PosButton posButton10;
	private com.floreantpos.swing.PosButton posButton11;
	private com.floreantpos.swing.PosButton posButton12;
	private com.floreantpos.swing.PosButton posButton2;
	private com.floreantpos.swing.PosButton posButton3;
	private com.floreantpos.swing.PosButton posButton4;
	private com.floreantpos.swing.PosButton posButton5;
	private com.floreantpos.swing.PosButton posButton6;
	private com.floreantpos.swing.PosButton posButton7;
	private com.floreantpos.swing.PosButton posButton8;
	private com.floreantpos.swing.PosButton posButton9;
	private javax.swing.JTextField tfAuthorizationCode;
	private javax.swing.JTextField tfCardAmount;
	private javax.swing.JTextField tfGratuityAmount;
	private com.floreantpos.swing.TransparentPanel transparentPanel1;
	private com.floreantpos.swing.TransparentPanel transparentPanel10;
	private com.floreantpos.swing.TransparentPanel transparentPanel2;
	private com.floreantpos.swing.TransparentPanel transparentPanel3;
	private com.floreantpos.swing.TransparentPanel transparentPanel4;
	private com.floreantpos.swing.TransparentPanel transparentPanel5;
	private com.floreantpos.swing.TransparentPanel transparentPanel7;
	private com.floreantpos.swing.TransparentPanel transparentPanel8;
	private com.floreantpos.swing.TransparentPanel transparentPanel9;

	// End of variables declaration//GEN-END:variables

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;

		if (cardType == CARD_TYPE_DEBIT) {
			btnEmEx.setVisible(false);
			btnDiscover.setVisible(false);
			TitledBorder titledBorder = new TitledBorder("Debit Card Transaction");
			titledBorder.setTitleJustification(TitledBorder.CENTER);
			setBorder(titledBorder);
		}
		else {
			btnEmEx.setVisible(true);
			btnDiscover.setVisible(true);
			TitledBorder titledBorder = new TitledBorder("Credit Card Transaction");
			titledBorder.setTitleJustification(TitledBorder.CENTER);
			setBorder(titledBorder);
		}
	}

	public String getWhichCard() {
		return whichCard;
	}

	public void setWhichCard(String whichCard) {
		this.whichCard = whichCard;
	}

	@Override
	public void updateView() {
		tfCardAmount.setText(Application.formatNumber(getDueAmount()));
		tfGratuityAmount.setText(Application.formatNumber(getTotalGratuity()));
	}

	//	@Override
	//	public void setTicket(Ticket ticket) {
	//		super.setTicket(ticket);
	//
	//		if (ticket != null) {
	//			tfCardAmount.setText(Application.formatNumber(ticket.getTotalAmount()));
	//			Gratuity gratuity = ticket.getGratuity();
	//
	//			if(gratuity != null) {
	//				tfGratuityAmount.setText(Application.formatNumber(gratuity.getAmount()));
	//			}
	//		}
	//		else {
	//			tfCardAmount.setText("0");
	//			tfGratuityAmount.setText("0");
	//		}
	//	}
}
