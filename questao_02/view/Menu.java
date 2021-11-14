package view;

import model. *;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;


public class Menu{

	private static ArrayList<Curso> cursos = new ArrayList<Curso>();
	static ArrayList<Horario> horariosCurso = new ArrayList<>();
	private static ArrayList<Aluno> alunos = new ArrayList<>();
	private static ArrayList<Horario> horariosDisciplina = new ArrayList<>();
	private static ArrayList<String> datas = new ArrayList<>();
	private static ArrayList<Disciplina> disciplinas = new ArrayList<>();
	public static ArrayList<Disciplina> disciplinasInscritas = new ArrayList<>();;
	public static ArrayList<Disciplina> disciplinasRealizadas = new ArrayList<>();;
	public static ArrayList<Aula> aulas = new ArrayList<>();
	private static HashSet<String> codigoDisciplina = new HashSet<>();
	private static HashSet<String> CPF = new HashSet<>();
	private static HashSet<String> codigoCurso = new HashSet<>();
	public static SimpleDateFormat formatHorarioCurso = new SimpleDateFormat("HH:mm-HH:mm");
	public static SimpleDateFormat formatDataDisciplina = new SimpleDateFormat("dd-MM-yyyy");
	public static SimpleDateFormat formatHorarioDisciplina = new SimpleDateFormat("HH:mm");
	public int contadorCursoNovo = 0;
	public int contadorDisciplinaNova = 0;
	public int contadorAlunoNovo = 0;

	public static JMenuBar criarMenu() {

		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		//JDialog dialog;  


		//Criar barra de menu
		menuBar = new JMenuBar();

		//Criar o arquivo menu
		menu = new JMenu("Criar");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("Criar");
		menuBar.add(menu);


		NovoCurso criarCurso = new NovoCurso();
		criarCurso.novoCurso(menu, cursos, codigoCurso);
		

		NovoHorarioCurso adicionarHorarioCurso = new NovoHorarioCurso();
		adicionarHorarioCurso.novoHorarioCurso(menu, cursos, codigoCurso);


		NovaDisciplina criarDisciplina = new NovaDisciplina();
		criarDisciplina.novaDisciplina(menu, cursos, CPF, codigoCurso, codigoDisciplina, disciplinas, horariosDisciplina);


		MatricularAluno matricularAluno = new MatricularAluno();
		matricularAluno.matricularAluno(menu, cursos, alunos, CPF, codigoCurso);


		LancarNota lancarNota = new LancarNota();
		lancarNota.lancarNota(menu);


		//Criar barra de editar no menu
		menu = new JMenu("Editar");
		menu.setMnemonic(KeyEvent.VK_E);
		menu.getAccessibleContext().setAccessibleDescription(
				"Editar");
		menuBar.add(menu);

		EditarCurso alterarCurso = new EditarCurso();
		alterarCurso.alterarCurso(menu);

		EditarDisciplina alterarDisciplina = new EditarDisciplina();
		alterarDisciplina.alterarDisciplina(menu);

		RemoverDisciplina removerDisciplina = new RemoverDisciplina();
		removerDisciplina.removerDisciplina(menu);


		//Build Edit menu in the menu bar.
		menu = new JMenu("Mostrar");
		menu.setMnemonic(KeyEvent.VK_E);
		menu.getAccessibleContext().setAccessibleDescription(
				"Edit Menu");
		menuBar.add(menu);

		MostrarHorarioPorAluno mostrarHorariosPorAluno = new MostrarHorarioPorAluno();
		mostrarHorariosPorAluno.mostrarHorarioPorAluno(menu);

		MostrarExAlunos mostrarExAlunos = new MostrarExAlunos();
		mostrarExAlunos.mostrarExAlunos(menu);

		MostrarDisciplinas mostrarDisciplinas = new MostrarDisciplinas();
		mostrarDisciplinas.mostrarDisciplinas(menu);

		return menuBar;

	}

	public static void main(String[] args) throws Exception {

		//JFrame.setDefaultLookAndFeelDecorated(true);

		final JFrame frame = new JFrame("Sistema Escola");

		frame.setJMenuBar(criarMenu());

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setVisible(true);
	}
}