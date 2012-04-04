package schedule;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics2D;
import javax.swing.border.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class tablepanel extends JPanel
{
	private table[][][] ttable;
	DefaultTableModel model=new DefaultTableModel();
	JTable Table;
	int i;
	public tablepanel(table[][][] t,int stgrp,inputdata input)
	{
		double[] time={8.0,9.0,10.0,11.0,1.0,2.0,3.0}; 
    		String[] day={"Mon","Tue","Wed","Thurs","Fri"};
		ttable=t;
		int stno;
		Table = new JTable(model){
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;   //Disallow the editing of any cell
			}
		};
		Table.setRowHeight(30);
		Table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//JLabel label=new JLabel(input.stgrp[stno].code);
		//add(label,BorderLayout.NORTH);
		model.addColumn("    ");
		for(i=1;i<=5;i++)
		{
			model.addColumn(day[i-1]);
		}
		//JScrollBar s=new JScrollBar(HORIZONTAL);
		for(i=0;i<6;i++)
		{
			TableColumn column=Table.getColumnModel().getColumn(i);
			column.setMinWidth(100);
   			column.setPreferredWidth(100);
   		}
		for(stno=0;stno<stgrp;stno++)
		{
			model.addRow(new Object[]{input.stgrp[stno].code,"","","","",""});
			model.addRow(new Object[]{"","","","","",""});
			for(i=1;i<=7;i++)
			{
				double x=time[i-1]+1;
				model.addRow(new Object[]{time[i-1]+"-"+x,ttable[stno][i-1][0].course+" "+ttable[stno][i-1][0].ins+" "+ttable[stno][i-1][0].room,ttable[stno][i-1][1].course+" "+ttable[stno][i-1][1].ins+" "+ttable[stno][i-1][1].room,ttable[stno][i-1][2].course+" "+ttable[stno][i-1][2].ins+" "+ttable[stno][i-1][2].room,ttable[stno][i-1][3].course+" "+ttable[stno][i-1][3].ins+" "+ttable[stno][i-1][3].room,ttable[stno][i-1][4].course+" "+ttable[stno][i-1][4].ins+" "+ttable[stno][i-1][4].room});
				//model.addRow(new Object[]{"","","","","",""});
			}
			model.addRow(new Object[]{"","","","","",""});
			model.addRow(new Object[]{"","","","","",""});
		}
		
		JScrollPane scroll = new JScrollPane(Table);
scroll.setHorizontalScrollBarPolicy( 
   JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
scroll.setVerticalScrollBarPolicy( 
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scroll.getViewport().setExtentSize(new Dimension(100,100));
		//scroll.setHorizontalScrollBar(s);
		add(scroll,BorderLayout.CENTER);
	}
}
