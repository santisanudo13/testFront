package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.kiuwan.client.model.Application;

import controller.Controlador;
import model.Aplicacion;
import model.Peticion;
import model.Usuario;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Font;

public class UI {

	static Controlador controlador;
	static JFrame frame;
	private final Action eligeDirectorio = new ExaminarAction();
	static JTextPane textPaneDirectorio;
	private final Action comenzarAnalisis = new ComenzarAction();
	static JTextField textFieldAplicacionTipo;
	static JTextField textFieldAplicacionNombre;
	static JTextField textFieldAplicacionDescripcion;
	static JTextField textFieldAplicacionProyecto;
	static JTextField textFieldAplicacionProveedor;
	static JTextField textFieldAplicacionTecnologia;
	static JTextField textFieldAplicacionBusinessArea;
	static JTextField textFieldAplicacionLaboratorio;
	static JTextField textFieldAplicacionFactoria;
	static JTextField textFieldAplicacionCliente;
	static JTextField textFieldUsuarioUsername;
	static JTextField textFieldUsuarioNombre;
	static JTextField textFieldUsuarioApellidos;
	static JTextField textFieldUsuarioCorreo;
	static JTextField textFieldUsuarioTipo;
	static JTable tableUsuarioPermisos;
	static JTextField textFieldAplicacionOrdenDeServicio;
	static JLabel labelCounterAplicacion;
	static JLabel label_counterUsuario;
	static JLabel lblPeticion;
	private final Action anteriorAplicacionAction = new AnteriorAplicacionAction();
	private final Action siguienteAplicacionAction = new SiguienteAplicacionAction();
	private final Action anteriorUsuarioAction = new AnteriorUsuarioAction();
	private final Action siguienteUsuarioAction = new SiguienteUsuarioAction();
	private final Action anteriorPeticionAction = new AnteriorPeticionAction();
	private final Action siguientePeticionAction = new SiguientePeticionAction();
	private final Action subirPeticionAction = new SubirPeticionAction();
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("KIG Ciberseguridad ISBAN Cantabria");
		frame.setBounds(100, 100, 1094, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelDirectorio = new JPanel();
		panelDirectorio.setBounds(20, 11, 518, 41);
		frame.getContentPane().add(panelDirectorio);
		panelDirectorio.setLayout(null);

		JButton btnEligeDirectorio = new JButton("Elige Directorio");
		btnEligeDirectorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEligeDirectorio.setBounds(0, 11, 154, 23);
		panelDirectorio.add(btnEligeDirectorio);
		btnEligeDirectorio.setAction(eligeDirectorio);

		textPaneDirectorio = new JTextPane();
		textPaneDirectorio.setBounds(174, 11, 344, 23);
		panelDirectorio.add(textPaneDirectorio);

		JPanel panelDatos = new JPanel();
		panelDatos.setBounds(20, 170, 1034, 385);
		frame.getContentPane().add(panelDatos);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[]{0, 0, 0};
		gbl_panelDatos.rowHeights = new int[]{0, 0};
		gbl_panelDatos.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelDatos.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelDatos.setLayout(gbl_panelDatos);

		JPanel panelAplicaciones = new JPanel();
		GridBagConstraints gbc_panelAplicaciones = new GridBagConstraints();
		gbc_panelAplicaciones.insets = new Insets(0, 0, 0, 5);
		gbc_panelAplicaciones.fill = GridBagConstraints.BOTH;
		gbc_panelAplicaciones.gridx = 0;
		gbc_panelAplicaciones.gridy = 0;
		panelDatos.add(panelAplicaciones, gbc_panelAplicaciones);
		panelAplicaciones.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("218px"),
				ColumnSpec.decode("261px:grow"),},
				new RowSpec[] {
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),}));

		JLabel lblContadorAplicacion = new JLabel("Contador Aplicaci\u00F3n");
		panelAplicaciones.add(lblContadorAplicacion, "1, 2, fill, center");

		labelCounterAplicacion = new JLabel("");
		panelAplicaciones.add(labelCounterAplicacion, "2, 2, fill, fill");

		JLabel lblTipo = new JLabel("Tipo");
		panelAplicaciones.add(lblTipo, "1, 4, fill, top");

		textFieldAplicacionTipo = new JTextField();
		panelAplicaciones.add(textFieldAplicacionTipo, "2, 4, fill, top");
		textFieldAplicacionTipo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		panelAplicaciones.add(lblNombre, "1, 6, fill, center");

		textFieldAplicacionNombre = new JTextField();
		panelAplicaciones.add(textFieldAplicacionNombre, "2, 6, fill, top");
		textFieldAplicacionNombre.setColumns(10);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		panelAplicaciones.add(lblDescripcin, "1, 8, fill, center");

		textFieldAplicacionDescripcion = new JTextField();
		panelAplicaciones.add(textFieldAplicacionDescripcion, "2, 8, fill, top");
		textFieldAplicacionDescripcion.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente");
		panelAplicaciones.add(lblCliente, "1, 10, fill, fill");

		textFieldAplicacionCliente = new JTextField();
		panelAplicaciones.add(textFieldAplicacionCliente, "2, 10, fill, top");
		textFieldAplicacionCliente.setColumns(10);

		JLabel lblProyecto = new JLabel("Proyecto");
		panelAplicaciones.add(lblProyecto, "1, 12, fill, center");

		textFieldAplicacionProyecto = new JTextField();
		panelAplicaciones.add(textFieldAplicacionProyecto, "2, 12, fill, top");
		textFieldAplicacionProyecto.setColumns(10);

		JLabel lblProveedor = new JLabel("Proveedor");
		panelAplicaciones.add(lblProveedor, "1, 14, fill, center");

		textFieldAplicacionProveedor = new JTextField();
		panelAplicaciones.add(textFieldAplicacionProveedor, "2, 14, fill, top");
		textFieldAplicacionProveedor.setColumns(10);

		JLabel lblBusinessarea = new JLabel("BusinessArea");
		panelAplicaciones.add(lblBusinessarea, "1, 16, fill, center");

		textFieldAplicacionBusinessArea = new JTextField();
		panelAplicaciones.add(textFieldAplicacionBusinessArea, "2, 16, fill, top");
		textFieldAplicacionBusinessArea.setColumns(10);

		JLabel lblTecnologia = new JLabel("Cliente");
		panelAplicaciones.add(lblTecnologia, "1, 18, fill, top");

		textFieldAplicacionTecnologia = new JTextField();
		textFieldAplicacionTecnologia.setColumns(10);
		panelAplicaciones.add(textFieldAplicacionTecnologia, "2, 18, fill, default");

		JLabel lblLaboratorio = new JLabel("Laboratorio");
		panelAplicaciones.add(lblLaboratorio, "1, 20, fill, center");

		textFieldAplicacionLaboratorio = new JTextField();
		panelAplicaciones.add(textFieldAplicacionLaboratorio, "2, 20, fill, top");
		textFieldAplicacionLaboratorio.setColumns(10);

		JLabel Factoria = new JLabel("Factor\u00EDa");
		panelAplicaciones.add(Factoria, "1, 22, fill, fill");

		textFieldAplicacionFactoria = new JTextField();
		panelAplicaciones.add(textFieldAplicacionFactoria, "2, 22, fill, top");
		textFieldAplicacionFactoria.setColumns(10);

		JLabel lblOrdenDeServicio = new JLabel("Orden de Servicio");
		panelAplicaciones.add(lblOrdenDeServicio, "1, 24, fill, top");

		textFieldAplicacionOrdenDeServicio = new JTextField();
		panelAplicaciones.add(textFieldAplicacionOrdenDeServicio, "2, 24, fill, default");
		textFieldAplicacionOrdenDeServicio.setColumns(10);

		JPanel panelUsuarios = new JPanel();
		GridBagConstraints gbc_panelUsuarios = new GridBagConstraints();
		gbc_panelUsuarios.fill = GridBagConstraints.BOTH;
		gbc_panelUsuarios.gridx = 1;
		gbc_panelUsuarios.gridy = 0;
		panelDatos.add(panelUsuarios, gbc_panelUsuarios);
		panelUsuarios.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("278px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("260px"),},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						RowSpec.decode("23px"),
						RowSpec.decode("14px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),}));

		JLabel lblContadorUsuario = new JLabel("Contador Usuario");
		panelUsuarios.add(lblContadorUsuario, "2, 2, fill, top");

		label_counterUsuario = new JLabel("");
		panelUsuarios.add(label_counterUsuario, "4, 2, fill, fill");

		JLabel lblTipo_1 = new JLabel("Tipo");
		panelUsuarios.add(lblTipo_1, "2, 4, fill, top");

		textFieldUsuarioTipo = new JTextField();
		panelUsuarios.add(textFieldUsuarioTipo, "4, 4, fill, top");
		textFieldUsuarioTipo.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		panelUsuarios.add(lblUsername, "2, 6, fill, center");

		textFieldUsuarioUsername = new JTextField();
		panelUsuarios.add(textFieldUsuarioUsername, "4, 6, fill, top");
		textFieldUsuarioUsername.setColumns(10);

		JLabel lblNombre_1 = new JLabel("Nombre");
		panelUsuarios.add(lblNombre_1, "2, 8, fill, center");

		textFieldUsuarioNombre = new JTextField();
		panelUsuarios.add(textFieldUsuarioNombre, "4, 8, fill, top");
		textFieldUsuarioNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		panelUsuarios.add(lblApellidos, "2, 10, fill, center");

		textFieldUsuarioApellidos = new JTextField();
		panelUsuarios.add(textFieldUsuarioApellidos, "4, 10, fill, top");
		textFieldUsuarioApellidos.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo");
		panelUsuarios.add(lblCorreo, "2, 12, fill, center");

		textFieldUsuarioCorreo = new JTextField();
		panelUsuarios.add(textFieldUsuarioCorreo, "4, 12, fill, top");
		textFieldUsuarioCorreo.setColumns(10);

		JLabel lblPortfoliosRoles = new JLabel("Permisos");
		panelUsuarios.add(lblPortfoliosRoles, "2, 14, fill, top");

		JScrollPane scrollPane = new JScrollPane();
		panelUsuarios.add(scrollPane, "2, 16, 3, 1, fill, top");


		String[][] data = new String[0][2];

		tableUsuarioPermisos = new JTable(new DefaultTableModel(new Object[]{"Tipo", "Rol"}, 0));
		scrollPane.setViewportView(tableUsuarioPermisos);

		JPanel panelControlAplicacion = new JPanel();
		panelControlAplicacion.setBounds(20, 118, 481, 41);
		frame.getContentPane().add(panelControlAplicacion);

		JSplitPane splitPane = new JSplitPane();
		panelControlAplicacion.add(splitPane);

		JButton btnAnteriorAplicacion = new JButton("Anterior");
		btnAnteriorAplicacion.setAction(anteriorAplicacionAction);
		splitPane.setLeftComponent(btnAnteriorAplicacion);

		JButton btnSiguienteAplicacion = new JButton("Siguiente");
		btnSiguienteAplicacion.setAction(siguienteAplicacionAction);
		splitPane.setRightComponent(btnSiguienteAplicacion);

		JPanel panelControlUsuario = new JPanel();
		panelControlUsuario.setBounds(511, 118, 557, 41);
		frame.getContentPane().add(panelControlUsuario);

		JSplitPane splitPane_1 = new JSplitPane();
		panelControlUsuario.add(splitPane_1);

		JButton btnAnteriorUsuario = new JButton("Anterior");
		btnAnteriorUsuario.setAction(anteriorUsuarioAction);
		splitPane_1.setLeftComponent(btnAnteriorUsuario);

		JButton btnSiguienteUsuario = new JButton("Siguiente");
		btnSiguienteUsuario.setAction(siguienteUsuarioAction);
		splitPane_1.setRightComponent(btnSiguienteUsuario);

		JPanel panel = new JPanel();
		panel.setBounds(537, 63, 212, 41);
		frame.getContentPane().add(panel);

		JSplitPane splitPane_2 = new JSplitPane();
		panel.add(splitPane_2);

		JButton btnAnteriorPeticion = new JButton("Anterior");
		btnAnteriorPeticion.setAction(anteriorPeticionAction);
		splitPane_2.setLeftComponent(btnAnteriorPeticion);

		JButton btnSiguientePeticion = new JButton("Siguiente");
		btnSiguientePeticion.setAction(siguientePeticionAction);
		splitPane_2.setRightComponent(btnSiguientePeticion);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 63, 314, 41);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.setBounds(0, 0, 135, 41);
		panel_1.add(btnComenzar);
		btnComenzar.setAction(comenzarAnalisis);
		
		JButton btnSubir = new JButton("Subir Peticion");
		btnSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubir.setAction(subirPeticionAction);
		btnSubir.setBounds(175, 0, 125, 41);
		panel_1.add(btnSubir);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(564, 11, 160, 41);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblPeticion = new JLabel("Petici\u00F3n");
		lblPeticion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPeticion.setBounds(0, 11, 150, 21);
		panel_2.add(lblPeticion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 566, 481, 184);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setColumnHeaderView(lblLog);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(511, 566, 542, 184);
		frame.getContentPane().add(scrollPane_2);
		
		JLabel lblTokens = new JLabel("Tokens");
		lblTokens.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_2.setColumnHeaderView(lblTokens);
		
		JPanel panel_3 = new JPanel();
		scrollPane_2.setViewportView(panel_3);
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblTokenFactoria = new JLabel("Token Factoria");
		panel_3.add(lblTokenFactoria, "2, 4, left, fill");
		
		textField = new JTextField();
		panel_3.add(textField, "4, 4, fill, top");
		textField.setColumns(10);
		
		JLabel lblTokenLaboratorio = new JLabel("Token Laboratorio");
		panel_3.add(lblTokenLaboratorio, "2, 10, left, fill");
		
		textField_1 = new JTextField();
		panel_3.add(textField_1, "4, 10, fill, top");
		textField_1.setColumns(10);

	}

	private class ExaminarAction extends AbstractAction {
		public ExaminarAction() {
			putValue(NAME, "Elige Directorio");
			putValue(SHORT_DESCRIPTION, "Genera un modal para seleccionar el directorio donde estan las peticiones");

		}
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Elige el directorio donde buscar Peticiones");
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				if (jfc.getSelectedFile().isDirectory()) {
					textPaneDirectorio.setText(jfc.getSelectedFile().getAbsolutePath());
					controlador = new Controlador(textPaneDirectorio.getText());
				}
			}
		}
	}
	public class ComenzarAction extends AbstractAction {
		public ComenzarAction() {
			putValue(NAME, "Comenzar");
			putValue(SHORT_DESCRIPTION, "Comienza en analisis de las peticiones");
		}
		public void actionPerformed(ActionEvent e) {
			controlador.readAllPeticiones();
			lblPeticion.setText("Petición   " + (controlador.counterPeticion+1) + "/" + controlador.listPeticiones.size());
			setDatosAplicacion(controlador.counterAplicacion);
			setDatosUsuario(controlador.counterUsuario);
		}
	}
	
	private class AnteriorPeticionAction extends AbstractAction {
		public AnteriorPeticionAction() {
			putValue(NAME, "Anterior");
			putValue(SHORT_DESCRIPTION, "Anterior Peticion");
		}
		public void actionPerformed(ActionEvent e) {
			if(controlador.counterPeticion > 0) {
				controlador.counterPeticion = controlador.counterPeticion - 1;
				controlador.counterAplicacion = 0;
				controlador.counterUsuario = 0;
				setDatosAplicacion(controlador.counterAplicacion);
				setDatosUsuario(controlador.counterUsuario);
				lblPeticion.setText("Petición   " + (controlador.counterPeticion+1) + "/" + controlador.listPeticiones.size());
			}
		}
	}
	private class SiguientePeticionAction extends AbstractAction {
		public SiguientePeticionAction() {
			putValue(NAME, "Siguiente");
			putValue(SHORT_DESCRIPTION, "Siguiente peticion");
		}
		public void actionPerformed(ActionEvent e) {
			if(controlador.counterPeticion < controlador.listPeticiones.size() - 1) {
				controlador.counterPeticion = controlador.counterPeticion + 1;
				controlador.counterAplicacion = 0;
				controlador.counterUsuario = 0;
				setDatosAplicacion(controlador.counterAplicacion);
				setDatosUsuario(controlador.counterUsuario);
				lblPeticion.setText("Petición   " + (controlador.counterPeticion+1) + "/" + controlador.listPeticiones.size());
			}
		}
	}
	private class AnteriorAplicacionAction extends AbstractAction {
		public AnteriorAplicacionAction() {
			putValue(NAME, "Anterior");
			putValue(SHORT_DESCRIPTION, "Anterior aplicacion");
		}
		public void actionPerformed(ActionEvent e) {
			if(controlador.counterAplicacion > 0) {
				controlador.counterAplicacion = controlador.counterAplicacion -1;
				setDatosAplicacion(controlador.counterAplicacion);
				setDatosUsuario(controlador.counterUsuario);
				UI.labelCounterAplicacion.setText(controlador.counterAplicacion+1 + "/" + controlador.listPeticiones.get(controlador.counterPeticion).getListAplicaciones().size());

			}
		}
	}
	private class SiguienteAplicacionAction extends AbstractAction {
		public SiguienteAplicacionAction() {
			putValue(NAME, "Siguiente");
			putValue(SHORT_DESCRIPTION, "Siguiente aplicacion");
		}
		public void actionPerformed(ActionEvent e) {
			if(controlador.counterAplicacion < controlador.listPeticiones.get(controlador.counterPeticion).getListAplicaciones().size() - 1) {
				controlador.counterAplicacion = controlador.counterAplicacion + 1;
				setDatosAplicacion(controlador.counterAplicacion);
				setDatosUsuario(controlador.counterUsuario);
				UI.labelCounterAplicacion.setText(controlador.counterAplicacion+1 + "/" + controlador.listPeticiones.get(controlador.counterPeticion).getListAplicaciones().size());
			}
		}
	}

	private class AnteriorUsuarioAction extends AbstractAction {
		public AnteriorUsuarioAction() {
			putValue(NAME, "Anterior");
			putValue(SHORT_DESCRIPTION, "Anterior usuario");
		}
		public void actionPerformed(ActionEvent e) {
			if(controlador.counterUsuario > 0) {
				controlador.counterUsuario = controlador.counterUsuario -1;
				setDatosAplicacion(controlador.counterAplicacion);
				setDatosUsuario(controlador.counterUsuario);
				UI.label_counterUsuario.setText(controlador.counterUsuario+1 + "/" + controlador.listPeticiones.get(controlador.counterUsuario).getListUsuarios().size());
			}
		}
	}
	
	private class SiguienteUsuarioAction extends AbstractAction {
		public SiguienteUsuarioAction() {
			putValue(NAME, "Siguiente");
			putValue(SHORT_DESCRIPTION, "Ssiguiente usuario");
		}
		public void actionPerformed(ActionEvent e) {
			if(controlador.counterUsuario < controlador.listPeticiones.get(controlador.counterPeticion).getListUsuarios().size() - 1) {
				controlador.counterUsuario = controlador.counterUsuario + 1;
				setDatosAplicacion(controlador.counterAplicacion);
				setDatosUsuario(controlador.counterUsuario);
				UI.label_counterUsuario.setText(controlador.counterUsuario+1 + "/" + controlador.listPeticiones.get(controlador.counterUsuario).getListUsuarios().size());

			}
		}
	}
	
	private class SubirPeticionAction extends AbstractAction {
		public SubirPeticionAction() {
			putValue(NAME, "Subir Peticion");
			putValue(SHORT_DESCRIPTION, "Subir Peticion a Kiuwan");
		}
		public void actionPerformed(ActionEvent e) {
			controlador.subirPeticionActual();
		}
	}
	
	public void setDatosAplicacion(int counterAplicacion) {
		Aplicacion aplicacion = controlador.listPeticiones.get(controlador.counterPeticion).getListAplicaciones().get(counterAplicacion);

		UI.labelCounterAplicacion.setText(counterAplicacion+1 + "/" + controlador.listPeticiones.get(controlador.counterPeticion).getListAplicaciones().size());
		UI.textFieldAplicacionTipo.setText(aplicacion.tipo);
		UI.textFieldAplicacionNombre.setText(aplicacion.nombre);
		UI.textFieldAplicacionDescripcion.setText(aplicacion.descripcion);
		UI.textFieldAplicacionCliente.setText(aplicacion.cliente);
		UI.textFieldAplicacionProyecto.setText(aplicacion.proyecto);
		UI.textFieldAplicacionProveedor.setText(aplicacion.proveedor);
		UI.textFieldAplicacionTecnologia.setText(aplicacion.tecnologia);
		UI.textFieldAplicacionBusinessArea.setText(aplicacion.businessArea);
		UI.textFieldAplicacionLaboratorio.setText(aplicacion.laboratorio);
		UI.textFieldAplicacionFactoria.setText(aplicacion.factoria);

	}

	public void setDatosUsuario(int counterUsuario) {
		Usuario usuario = controlador.listPeticiones.get(controlador.counterPeticion).getListUsuarios().get(counterUsuario);
		UI.label_counterUsuario.setText(counterUsuario+1 + "/" + controlador.listPeticiones.get(controlador.counterUsuario).getListUsuarios().size());
		UI.textFieldUsuarioTipo.setText(usuario.tipo);
		UI.textFieldUsuarioUsername.setText(usuario.username);
		UI.textFieldUsuarioNombre.setText(usuario.nombre);
		UI.textFieldUsuarioApellidos.setText(usuario.apellidos);
		UI.textFieldUsuarioCorreo.setText(usuario.correo);
		DefaultTableModel dataModel = new DefaultTableModel();

		JTable table = UI.tableUsuarioPermisos;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		if(!usuario.permisos.isEmpty())
			for(List<String> fila : usuario.permisos)
				model.addRow(new Object[]{fila.get(0), fila.get(1)});
	}
}
