package controller;

import model.Address;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class TableViewController {
	/* --- --- --- private field --- --- --- */
	@FXML private TableView<Address> tableView;
	@FXML private TextField nameField;
	@FXML private TextField emailField;

	/* --- --- --- protected method --- --- --- */
	@FXML
	protected void addAddress(ActionEvent event) {
		ObservableList<Address> items = this.tableView.getItems();
		items.add(new Address(
			  nameField.getText()
			, emailField.getText()
		));
		nameField.setText("");
		emailField.setText("");
	}
}
