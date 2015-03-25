import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

class Close extends JLabel
	{
 
		private static final long serialVersionUID = 184842104821L;
		private static Icon tiger=new ImageIcon("B.png");
 
 
		/**
		 * 
		 * @param tab
		 */
		public Close(final JTabbedPane tab)
		{
			super(tiger, JLabel.CENTER);
			//super( Images._16x16_CLOSE, JLabel.CENTER );
			
			
			this.setVerticalAlignment( JLabel.CENTER );
			setPreferredSize( new Dimension( 15, 8 ) );
			setBorder( BorderFactory.createEmptyBorder( 0, 0, 0, 0 ) );
			//setToolTipText( Messages.getMessage( "fermer" ) );
 
			addMouseListener( new MouseAdapter()
			{
				public void mouseEntered(MouseEvent e)
				{
					setBorder( BorderFactory.createEtchedBorder() );
					validate();
				}
 
				public void mouseExited(MouseEvent e)
				{
					setBorder( BorderFactory.createEmptyBorder( 0, 0, 0, 0 ) );
					validate();
				}
 
				public void mouseClicked(MouseEvent e)
				{
					//tab.getTabbedPanel().removeTab( tab );
					System.gc();
				}
 
			} );
		}
 
	}
