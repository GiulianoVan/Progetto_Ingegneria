/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Pirozzi
 */
public class ModelColumn extends TableColumn {
   
    JTable table;
    private TableColumnModel columnModel;
    private List<TableColumn> allColumns;

 public  ModelColumn(JTable tab)
 {
     super();
     table = tab;
     columnModel = tab.getColumnModel();
 }
     
 /**
     *  Hide a column from view in the table.
     *
     *  @param  modelColumn  the column index from the TableModel
     *                       of the column to be removed
     */
	public void hideColumn(int modelColumn)
	{
                
		int viewColumn = table.convertColumnIndexToView(modelColumn);
                System.out.println(viewColumn);
		if (viewColumn != -1)
		{
                    TableColumn column=columnModel.getColumn(viewColumn);
                    for(int i = 0;i<columnModel.getColumnCount();++i)
                    {
                        System.out.println(i);
                    }
                    table.removeColumn(column);
                    
                    System.out.println(table.getModel().getValueAt(0,viewColumn));
                    
                    for(int i = 0;i<columnModel.getColumnCount();++i)
                    {
                        System.out.println(i);
                    }
		}
	}
	

    /**
     *  Hide a column from view in the table.
     *
     *  @param  columnName   the column name of the column to be removed
     */
        
	public void hideColumn(Object columnName)
	{
		if (columnName == null) return;

		for (int i = 0; i < columnModel.getColumnCount(); i++)
		{
			TableColumn column = columnModel.getColumn( i );

			if (columnName.equals(column.getHeaderValue()))
			{
				hideColumn(column);
				break;
			}
		}
	}

    /**
     *  Hide a column from view in the table.
     *
     *  @param  column  the TableColumn to be removed from the
     *                  TableColumnModel of the table
     */
	public void hideColumn(TableColumn column)
	{
		if (columnModel.getColumnCount() == 1) return;

		//  Ignore changes to the TableColumnModel made by the TableColumnManager
		columnModel.removeColumn(column);
	}

    /**
     *  Show a hidden column in the table.
     *
     *  @param  modelColumn  the column index from the TableModel
     *                       of the column to be added
     */
	public void showColumn(int modelColumn)
	{
		for (TableColumn column : allColumns)
		{
			if (column.getModelIndex() == modelColumn)
			{
				showColumn( column );
				break;
			}
		}
	}

    /**
     *  Show a hidden column in the table.
     *
     *  @param  columnName   the column name from the TableModel
     *                       of the column to be added
     */
	public void showColumn(Object columnName)
	{
		for (TableColumn column : allColumns)
		{
			if (column.getHeaderValue().equals(columnName))
			{
				showColumn( column );
				break;
			}
		}
	}

    /**
     *  Show a hidden column in the table. The column will be positioned
     *  at its proper place in the view of the table.
     *
     *  @param  column   the TableColumn to be shown.
     */
	private void showColumn(TableColumn column)
	{
		//  Ignore changes to the TableColumnModel made by the TableColumnManager

		

		//  Add the column to the end of the table

		columnModel.addColumn( column );

		//  Move the column to its position before it was hidden.
		//  (Multiple columns may be hidden so we need to find the first
		//  visible column before this column so the column can be moved
		//  to the appropriate position)

		int position = allColumns.indexOf( column );
		int from = columnModel.getColumnCount() - 1;
		int to = 0;

		for (int i = position - 1; i > -1; i--)
		{
			try
			{
				TableColumn visibleColumn = allColumns.get( i );
				to = columnModel.getColumnIndex( visibleColumn.getHeaderValue() ) + 1;
				break;
			}
			catch(IllegalArgumentException e) {}
		}

		columnModel.moveColumn(from, to);
	}
}
