package control;

import java.text.Format;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;


public class FormattedTableCellFactory<S,T> implements Callback<TableColumn<S,T>, TableCell<S,T>> {
	/* --- --- --- private field --- --- --- */
	private TextAlignment alignment;
	private Format        format;

	/* --- --- --- public method --- --- --- */
	public TextAlignment getAlignment() {
		return this.alignment;
	}

	public void setAlignment(TextAlignment alignment) {
		this.alignment = alignment;
	}

	public Format getFormat() {
		return this.format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public TableCell<S,T> call(TableColumn<S,T> unuse) {
		TableCell<S,T> cell = new TableCell<S,T>() {
			@Override
			public void updateItem(Object item, boolean empty) {
				if (item == this.getItem()) {
					return;
				}
				super.updateItem((T)item, empty);
				if (item == null) {
					super.setText(null);
					super.setGraphic(null);
				} else if (format != null) {
					super.setText(null);
					super.setGraphic((Node)item);
				} else {
					super.setText(item.toString());
					super.setGraphic(null);
				}
			}
		};
		cell.setTextAlignment(this.alignment);
		switch (this.alignment) {
			case CENTER:
				cell.setAlignment(Pos.CENTER);
				break;
			case RIGHT:
				cell.setAlignment(Pos.CENTER_RIGHT);
				break;
			default:
				cell.setAlignment(Pos.CENTER_LEFT);
				break;
		}
		return cell;
	}
}
