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
class printtable
{
	private table[][][] ttable;
	JFrame tableframe;
	int stgrp;
	int i;
	tablepanel panel;
	JPanel south;
	inputdata input;
	public printtable(table[][][] t,int nostgrp,inputdata input1)
	{
		ttable=t;
		tableframe=new JFrame();
		stgrp=nostgrp;
		south=new JPanel();
		input=input1;
	}
	void print()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				tableframe.setTitle("CLASS SCHEDULING");
				tableframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tableframe.setSize(900,600);
				tableframe.setLayout(new GridBagLayout());
				GridBagConstraints c=new GridBagConstraints();
				c.weightx=0;
				c.gridx=0;
				c.gridy=0;
				c.fill=GridBagConstraints.HORIZONTAL;
				int j;
				JButton next=new JButton("EXIT");
				panel=new tablepanel(ttable,stgrp,input);
				JPanel south=new JPanel();
				south.setLayout(new GridLayout(1,10));
				for(j=0;j<10;j++)
					south.add(new JLabel(" "));
				south.add(next);
				tableframe.add(panel);
				c.gridx=0;
				c.gridy=10;
				tableframe.add(south,c);
				tableframe.setVisible(true);
				next.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						System.exit(0);
					}
				});
			}
		});	
	}
}

