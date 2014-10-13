package hr.fer.zemris.java.tecaj_9.krugovi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class KrugoviProzor extends JFrame {

	private CircleListModel model = new CircleListModel();

	public KrugoviProzor() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		initGui();
	}

	private void initGui() {
		JList<Circle> lista1 = new JList<>(model);
		JList<Circle> lista2 = new JList<>(model);
		
		JScrollPane s1 = new JScrollPane(lista1);
		JScrollPane s2 = new JScrollPane(lista2);
		s1.setPreferredSize(new Dimension(100, 50));
		s2.setPreferredSize(new Dimension(100, 50));
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(s1, BorderLayout.LINE_START);
		getContentPane().add(s2, BorderLayout.LINE_END);

		JPanel p = new JPanel(new FlowLayout());
		final JTextField tf = new JTextField();
		tf.setPreferredSize(new Dimension(100, 25));
		JButton dodaj = new JButton("Dodaj");
		p.add(tf);
		p.add(dodaj);

		getContentPane().add(p, BorderLayout.PAGE_END);

		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] elems = tf.getText().replaceAll("\\s*", "").split(",");
				if(tf.getText().equals("")) return;
				model.dodajKrug(new Circle(Integer.parseInt(elems[0]), Integer
						.parseInt(elems[1]), Integer.parseInt(elems[2])));
				tf.setText("");
			}
		});
		
		MouseListener akcija = new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JList<Circle> lista = (JList<Circle>)e.getSource();
				if(e.getClickCount() != 2) return;
				int index = lista.getSelectedIndex();
				if(index == -1) return;
				model.ukloniKrug(index);
			}
		};
		
		lista1.addMouseListener(akcija);
		lista2.addMouseListener(akcija);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new KrugoviProzor().setVisible(true);
			}
		});
	}

	private static class Circle {

		private int cx;
		private int cy;
		private int r;

		public Circle(int cx, int cy, int r) {
			super();
			this.cx = cx;
			this.cy = cy;
			this.r = r;
		}

		@Override
		public String toString() {
			return String.format("Circle (%d,%d), %d", cx, cy, r);
		}
	}

	private static class CircleListModel implements ListModel<Circle> {

		private List<Circle> elementi = new ArrayList<>();
		private List<ListDataListener> promatraci = new ArrayList<>();

		@Override
		public int getSize() {
			return elementi.size();
		}

		@Override
		public Circle getElementAt(int index) {
			return elementi.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {
			System.out.println("Netko se zakvacio na mene:" + l);
			if (!promatraci.contains(l)) {
				promatraci = new ArrayList<>(promatraci);
				promatraci.add(l);
			}
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			promatraci = new ArrayList<>(promatraci);
			promatraci.remove(l);
		}

		public void ukloniKrug(int index) {
			elementi.remove(index);
			fireIntervalRemoved(new ListDataEvent(this,
					ListDataEvent.INTERVAL_REMOVED, index, index));
		}

		public void dodajKrug(Circle c) {
			int index = elementi.size();
			elementi.add(c);
			fireIntervalAdded(new ListDataEvent(this,
					ListDataEvent.INTERVAL_ADDED, index, index));
		}

		private void fireIntervalAdded(ListDataEvent event) {
			for (ListDataListener l : promatraci) {
				l.intervalAdded(event);
			}
		}

		private void fireIntervalRemoved(ListDataEvent event) {
			for (ListDataListener l : promatraci) {
				l.intervalRemoved(event);
			}
		}
	}
}
