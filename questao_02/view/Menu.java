package view;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static ArrayList<Curso> cursos = new ArrayList<Curso>();
	public static ArrayList<Horario> horariosCurso = new ArrayList<>();
	public static ArrayList<Aluno> alunos = new ArrayList<>();
	public static ArrayList<Horario> horariosDisciplina = new ArrayList<>();
	public static ArrayList<String> datas = new ArrayList<>();
	public static ArrayList<Disciplina> disciplinas = new ArrayList<>();
	public static ArrayList<Disciplina> disciplinasInscritas;
	public static ArrayList<Disciplina> disciplinasRealizadas;
	public static ArrayList<Aula> aulas = new ArrayList<>();
	public static HashSet<String> codigoDisciplina = new HashSet<>();
	private static HashSet<String> CPF = new HashSet<>();
	public static HashSet<String> codigoCurso = new HashSet<>();
	public static SimpleDateFormat formatHorarioCurso = new SimpleDateFormat("HH:mm-HH:mm");
	public static SimpleDateFormat formatDataDisciplina = new SimpleDateFormat("dd-MM-yyyy");
	public static SimpleDateFormat formatHorarioDisciplina = new SimpleDateFormat("HH:mm");


	public static void menu() {

		System.out.print("Sistema de Gestão Escolar - Menu Inicial\n\n");
		System.out.print("1. Criação de cursos e respectivo conjunto de disciplinas\n");
		System.out.print("2. Criação e alteração de horários de curso\n");
		System.out.print("3. Criação, alteração e remoção de disciplinas\n");
		System.out.print("4. Inscrição de aluno em curso e disciplinas\n");
		System.out.print("5. Geração do horário do aluno\n");
		System.out.print("6. Lançamento de notas de uma disciplina de um curso\n");
		System.out.print("7. Listagem dos Ex-alunos\n");
		System.out.print("8. Listagem dos alunos de um dado curso, indicando para cada um deles as disciplinas\n" + 
				"que já concluíram e as que lhe falta concluir.\n");
		System.out.print("9. Desligando\n");

	}
	public static void main(String [] args) {

		int opcao;

		Scanner menu = new Scanner (System.in);


		do {
			menu();
			opcao = menu.nextInt();

			switch (opcao) {
			case 1:
				criarCurso();
				break;

			case 2:
				alterarHorariosDeCursos();
				break;

			case 3:
				criacaoRemocaoDisciplinas();
				break;
			case 4:
				inscricaoDeAlunoEmCursoDisciplinas();
				break;
			case 5:
				geracaoDoHorarioDoAluno();
				break;
			case 6:
				lancamentoDeNotasAluno();
				break;
			case 7:
				listagemExAlunos();
				break;
			case 8:
				listagemDeAlunosAtualmenteMatriculados();
				break;

			default:
				System.out.print("\nOpção Inválida!");
				break;

			case 9:
				System.out.print("\nDesligando...");
				menu.close();		
			}

		}while(opcao != 7);




	}

	private static void listagemDeAlunosAtualmenteMatriculados() {

		for(int i = 0; i < cursos.size(); i++) {

			float totalHorasCurso = 0;

			for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

				for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAula().size(); k++) {

					totalHorasCurso += cursos.get(i).getDisciplina().get(j).getAula().get(k).getDuracao();

				}

				System.out.println("\nLista de alunos de : " + cursos.get(i).getNome());
				for(int k = 0; k < cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida(); k++) {

					if(cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida() < totalHorasCurso) {

						System.out.println("- " + cursos.get(i).getAluno().get(k).getNome());

						System.out.println("Matérias : ");
						System.out.println(" - concluídas : ");
						for(int l = 0; l < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().size(); l++) {
							System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
						}

						System.out.println(" - cursando : ");
						for(int l = 0; l < cursos.get(i).getAluno().get(k).getDisciplinasInscritas().size(); l++) {
							System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
						}

						System.out.println(" - a cursar : ");
						for(int l = 0; l < cursos.get(i).getDisciplina().size(); l++) {

							for(int m = 0; m < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().size(); m++) {

								String codigoRealizada = cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(k).getCodigo().toString();
								String codigoCursando = cursos.get(i).getAluno().get(k).getDisciplinasInscritas().get(k).getCodigo().toString();

								if(!cursos.get(i).getDisciplina().get(l).getCodigo().contains(codigoRealizada) &&
										!cursos.get(i).getDisciplina().get(l).getCodigo().contains(codigoCursando)) {
									System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
								}

							}


						}

					}
				}	

			}

		}

	}

	private static void listagemExAlunos() {

		for(int i = 0; i < cursos.size(); i++) {

			float totalHorasCurso = 0;

			for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

				for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAula().size(); k++) {

					totalHorasCurso += cursos.get(i).getDisciplina().get(j).getAula().get(k).getDuracao();

				}

				System.out.println("\nLista de ex-alunos de : " + cursos.get(i).getNome());
				for(int k = 0; k < cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida(); k++) {

					if(cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida() >= totalHorasCurso) {

						System.out.println("- " + cursos.get(i).getAluno().get(k).getNome());
					}
				}	

			}

		}

	}
	private static void lancamentoDeNotasAluno() {

		Scanner scan = new Scanner (System.in);

		System.out.println("Informe o CPF do aluno: ");
		String cpfStr = scan.next();	
		while(verificaCpf(cpfStr) != true) {
			System.out.println("Informe o CPF do aluno:");
			cpfStr = scan.next();
		}

		for(int i = 0; i < alunos.size(); i++) {

			if(alunos.get(i).getCpf().contains(cpfStr)) {

				System.out.println("Informe o código da disciplina: ");
				String codigoDisciplina = scan.next();

				for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

					if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

						disciplinasRealizadas.add(cursos.get(i).getDisciplina().get(j));

						System.out.println("Qual foi a nota obtida");
						float nota = scan.nextFloat();

						if(nota < 0)
							nota = 0;
						if(nota > 10)
							nota = 10;

						for(int k = 0; k < alunos.get(i).getDisciplinaRealizadas().size(); k++) {
							if(alunos.get(i).getDisciplinaRealizadas().get(j).getCodigo().contains(codigoDisciplina)) {
								alunos.get(i).getDisciplinaRealizadas().get(j).setNota(nota);
							}
						}


						for(int k = 0; k < alunos.get(i).getDisciplinaRealizadas().get(j).getAula().size(); k++) {
							if(alunos.get(i).getDisciplinaRealizadas().get(j).getCodigo().contains(codigoDisciplina) && nota >= 5) {

								float totalHorasAulno = alunos.get(i).getTotalCargaHorariaCumprida();
								totalHorasAulno += alunos.get(i).getDisciplinaRealizadas().get(j).getAula().get(k).getDuracao();
								alunos.get(i).setTotalCargaHorariaCumprida(totalHorasAulno);

							}
						}



					}else {
						System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
						int novaTentativa = scan.nextInt();

						if(novaTentativa == 1) {
							inscricaoDeAlunoEmCursoDisciplinas();
						}	

					}
				}

			}else {

				System.out.println("O CPF informado não consta no cadastro.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
				int novaTentativa = scan.nextInt();

				if(novaTentativa == 1) {
					inscricaoDeAlunoEmCursoDisciplinas();
				}	

			}
		}

		scan.close();

	}

	private static void geracaoDoHorarioDoAluno() {

		Scanner scan = new Scanner (System.in);

		System.out.println("Informe o CPF do aluno: ");
		String cpfStr = scan.next();	
		while(verificaCpf(cpfStr) != true) {
			System.out.println("Informe o CPF do aluno:");
			cpfStr = scan.next();
		}

		for(int i = 0; i < alunos.size(); i++) {

			if(alunos.get(i).getCpf().contains(cpfStr)) {
				System.out.println("Horários de:" + alunos.get(i).getNome());
				for(int j = 0; j < alunos.get(i).getDisciplinasInscritas().size(); j++) {
					System.out.println(alunos.get(i).getDisciplinasInscritas().get(j).getHorarios());
				}
			}else {

				System.out.println("O CPF informado não consta no cadastro.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
				int novaTentativa = scan.nextInt();

				if(novaTentativa == 1) {
					inscricaoDeAlunoEmCursoDisciplinas();
				}	

			}
		}
		scan.close();

	}
	private static void inscricaoDeAlunoEmCursoDisciplinas() {

		Scanner scan = new Scanner (System.in);

		System.out.println("O aluno já consta no cadastro do curso?\n1 - Sim\n2 - Não");
		int existe = scan.nextInt();

		if(existe == 1) {

			System.out.println("Informe o codigo da disciplina na qual deseja inscrever do aluno:");
			String codigoDisciplina = scan.next();

			for(int i = 0; i < cursos.size(); i++) {

				for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

					if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

						System.out.println("Informe o CPF do aluno: ");
						String cpfStr = scan.next();	
						while(verificaCpf(cpfStr) != true) {
							System.out.println("Informe o CPF do aluno:");
							cpfStr = scan.next();
						}

						for (int k = 0; k < cursos.get(i).getAluno().size() ; k++) {

							if(cursos.get(i).getAluno().get(k).getCpf().contains(cpfStr)) {

								disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));

							}else {

								System.out.println("O CPF informado não consta no cadastro.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
								int novaTentativa = scan.nextInt();

								if(novaTentativa == 1) {
									inscricaoDeAlunoEmCursoDisciplinas();
								}	

							}
						}


					}else {

						System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
						int novaTentativa = scan.nextInt();

						if(novaTentativa == 1) {
							inscricaoDeAlunoEmCursoDisciplinas();
						}	

					}		



				}

			}

		}else {


			Aluno aluno = new Aluno();
			String cpfStr = null;

			System.out.println("Qual o nome do aluno?");
			String nomeAluno = scan.next();
			aluno.setNome(nomeAluno);

			System.out.println("Informe o cpf do aluno: ");
			cpfStr = scan.next();	
			while(verificaCpf(cpfStr) != true) {
				System.out.println("Informe o cpf do aluno:");
				cpfStr = scan.next();
			}
			CPF.add(cpfStr);			
			aluno.setCpf(CPF);

			System.out.println("Informe o codigo do curso no qual deseja matricular o aluno:");
			String codigoCurso = scan.next();

			for(int i = 0; i < cursos.size(); i++) {

				if(cursos.get(i).getCodigo().contains(codigoCurso)) {

					cursos.get(i).getAluno().add(aluno);

					System.out.println("Informe o código da disciplina: ");
					String codigoDisciplina = scan.next();

					for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

						if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

							System.out.println("Essa disciplina já foi cursada em outro lugar?\n1 - Sim\n2 - Não");
							int resposta = scan.nextInt();

							if(resposta == 1) {
								disciplinasRealizadas.add(cursos.get(i).getDisciplina().get(j));
								for(int k = 0; k < disciplinasRealizadas.size(); k++) {

									if(aluno.getDisciplinaRealizadas().get(k).getCodigo().contains(codigoDisciplina)){

										System.out.println("Qual foi a nota obtida");
										float nota = scan.nextFloat();

										if(nota < 0)
											nota = 0;
										if(nota > 10)
											nota = 10;

										aluno.getDisciplinaRealizadas().get(k).setNota(nota);

										for(int l = 0; l < aluno.getDisciplinaRealizadas().get(k).getAula().size(); l++) {
											//aluno.getDisciplinaRealizadas().get(k).getAula().get(l).setDuracao(duracao);
											if(alunos.get(i).getDisciplinaRealizadas().get(k).getCodigo().contains(codigoDisciplina) && nota >= 5) {
												float totalHorasAulno = alunos.get(i).getTotalCargaHorariaCumprida();
												totalHorasAulno += alunos.get(i).getDisciplinaRealizadas().get(j).getAula().get(k).getDuracao();
												alunos.get(i).setTotalCargaHorariaCumprida(totalHorasAulno);
											}


										}

									}


								}


							}else {
								disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));
								aluno.setDisciplinasInscritas(disciplinasInscritas);
							}

						}else {
							System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
							int novaTentativa = scan.nextInt();

							if(novaTentativa == 1) {
								inscricaoDeAlunoEmCursoDisciplinas();
							}	

						}
					}
				}else {
					System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
					int novaTentativa = scan.nextInt();

					if(novaTentativa == 1) {
						inscricaoDeAlunoEmCursoDisciplinas();
					}	
				}

			}

		}

		scan.close();
	}
	private static void criacaoRemocaoDisciplinas() {
		Scanner scan = new Scanner (System.in);


		System.out.println("A disciplina já existe?\n1 - Sim\n2 - Não");
		int existe = scan.nextInt();

		if(existe == 1) {

			System.out.println("Informe o codigo do curso no qual deseja realizar a alteração da disciplina:");
			String codigoCurso = scan.next();

			for(int i = 0; i < cursos.size(); i++) {

				if(cursos.get(i).getCodigo().contains(codigoCurso)) {

					System.out.println("Informe o código da disciplina: ");
					String codigoDisciplina = scan.next();
					for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

						if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

							System.out.println("Deseja deletar ou alterar?\n1 - Alterar\n2 - Deletar");
							int escolha = scan.nextInt();

							if(escolha == 1) {

								System.out.println("Qual aspecto da disciplina deseja alterar?");
								System.out.println("1 - Nome: " + cursos.get(i).getDisciplina().get(j).getNome());
								System.out.println("2 - Sigla: " + cursos.get(i).getDisciplina().get(j).getSigla());
								System.out.println("3 - Aulas: ");
								for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAula().size(); k++) {
									int display = k + 1;
									System.out.println(display + " - Duraçãodas disciplina: " + cursos.get(i).getDisciplina().get(j).getAula().get(k).getDuracao());
								}	
								System.out.println("4 - Datas: ");
								for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getDatas().size(); k++) {
									int display = k + 1;
									System.out.println(display + " : " + cursos.get(i).getDisciplina().get(j).getDatas().get(k));
								}	
								System.out.println("5 - Docente: " + cursos.get(i).getDisciplina().get(j).getNome());
								System.out.println("6 - Horarios: ");
								for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getHorarios().size(); k++) {
									int display = k + 1;
									System.out.println(display + " : " + cursos.get(i).getDisciplina().get(j).getHorarios().get(k).getHorario());
								}

								int especto = scan.nextInt();

								if(especto < 1 || especto == 1) {
									String nomeNovo = scan.next();
									cursos.get(i).getDisciplina().get(j).setNome(nomeNovo);
								}

								if(especto == 2) {
									String siglaNova = scan.next();
									cursos.get(i).getDisciplina().get(j).setSigla(siglaNova);;
								}

								if(especto == 3) {
									System.out.println("Qual duração deseja alterar");
									int duracaoEscolhida = scan.nextInt();							

									if(duracaoEscolhida < 1) {

										duracaoEscolhida = 0;
										System.out.println("Qual a nova duração?");
										int novaDuracao = scan.nextInt();

										if(novaDuracao > 90)
											novaDuracao = 90;
										if(novaDuracao < 30)
											novaDuracao = 30;

										cursos.get(i).getDisciplina().get(j).getAula().get(duracaoEscolhida).setDuracao(novaDuracao);

									}else if(duracaoEscolhida >= cursos.get(i).getDisciplina().get(j).getAula().size()) {

										System.out.println("Qual a nova duração?");
										int novaDuracao = scan.nextInt();

										if(novaDuracao > 90)
											novaDuracao = 90;
										if(novaDuracao < 30)
											novaDuracao = 30;

										duracaoEscolhida = cursos.get(i).getDisciplina().get(j).getAula().size() - 1;
										cursos.get(i).getDisciplina().get(j).getAula().get(duracaoEscolhida).setDuracao(novaDuracao);

									}else {

										System.out.println("Qual a nova duração?");
										int novaDuracao = scan.nextInt();

										if(novaDuracao > 90)
											novaDuracao = 90;
										if(novaDuracao < 30)
											novaDuracao = 30;

										cursos.get(i).getDisciplina().get(j).getAula().get(duracaoEscolhida).setDuracao(novaDuracao);

									}

								}

								if(especto == 4) {
									System.out.println("Qual data deseja alterar");
									int dataEscolhida = scan.nextInt();

									if(dataEscolhida < 1) {

										dataEscolhida = 0;
										System.out.println("Qual a nova data?");
										String novaData = scan.next();

										while(validaDatasDisciplinas(novaData) != true) {
											System.out.println("Informe uma data válida (dd-MM-yyyy): ");
											novaData = scan.next();				
										}

										try {
											formatDataDisciplina.parse(novaData);
											datas.add(novaData);							
										} catch (ParseException e) {
											e.printStackTrace();
										}
										cursos.get(i).getDisciplina().get(j).getDatas().set(dataEscolhida, novaData);

									}else if(dataEscolhida >= cursos.get(i).getDisciplina().get(j).getDatas().size()) {

										dataEscolhida = cursos.get(i).getDisciplina().get(j).getDatas().size() - 1;
										System.out.println("Qual a nova data?");
										String novaData = scan.next();

										while(validaDatasDisciplinas(novaData) != true) {
											System.out.println("Informe uma data válida (dd-MM-yyyy): ");
											novaData = scan.next();				
										}

										try {
											formatDataDisciplina.parse(novaData);
											datas.add(novaData);							
										} catch (ParseException e) {
											e.printStackTrace();
										}
										cursos.get(i).getDisciplina().get(j).getDatas().set(dataEscolhida, novaData);

									}else {

										System.out.println("Qual a nova data?");
										String novaData = scan.next();

										while(validaDatasDisciplinas(novaData) != true) {
											System.out.println("Informe uma data válida (dd-MM-yyyy): ");
											novaData = scan.next();				
										}

										try {
											formatDataDisciplina.parse(novaData);
											datas.add(novaData);							
										} catch (ParseException e) {
											e.printStackTrace();
										}
										cursos.get(i).getDisciplina().get(j).getDatas().set(dataEscolhida, novaData);

									}

								}

								if(especto == 5) {									

									String cpfDocente = null;

									System.out.println("Informe o cpf do novo docente");
									cpfDocente = scan.next();

									while(verificaCpf(cpfDocente) != true) {
										System.out.println("Informe o cpf do docente");
										cpfDocente = scan.next();
									}
									cursos.get(i).getDisciplina().get(j).getDocente().getCpf().remove(CPF);
									CPF.add(cpfDocente);																
									cursos.get(i).getDisciplina().get(j).getDocente().setCpf(CPF);

									System.out.println("Informe o nome do novo docente");
									String nomeDocente = scan.next();
									cursos.get(i).getDisciplina().get(j).getDocente().setNome(nomeDocente);


								}

								if(especto == 6) {									
									System.out.println("Qual horário deseja alterar");
									int horarioEscolhido = scan.nextInt();

									if(horarioEscolhido < 1) {

										horarioEscolhido = 0;
										System.out.println("Qual o novo horário?");
										String novoHorario = scan.next();

										while(validaHorariosDisciplinas(novoHorario) != true) {
											System.out.println("Informe um novo horário válido (HH:mm): ");
											novoHorario = scan.next();				
										}

										try {
											formatHorarioDisciplina.parse(novoHorario);						
											cursos.get(i).getDisciplina().get(j).getHorarios().get(horarioEscolhido).setHorario(novoHorario);;					
										} catch (ParseException e) {
											e.printStackTrace();
										}


									}else if(horarioEscolhido >= cursos.get(i).getDisciplina().get(j).getHorarios().size()) {

										horarioEscolhido = cursos.get(i).getDisciplina().get(j).getAula().size() - 1;

										System.out.println("Qual o novo horário?");
										String novoHorario = scan.next();

										while(validaHorariosDisciplinas(novoHorario) != true) {
											System.out.println("Informe um novo horário válido (HH:mm): ");
											novoHorario = scan.next();				
										}

										try {
											formatHorarioDisciplina.parse(novoHorario);						
											cursos.get(i).getDisciplina().get(j).getHorarios().get(horarioEscolhido).setHorario(novoHorario);;					
										} catch (ParseException e) {
											e.printStackTrace();
										}

									}else {

										System.out.println("Qual o novo horário?");
										String novoHorario = scan.next();

										while(validaHorariosDisciplinas(novoHorario) != true) {
											System.out.println("Informe um novo horário válido (HH:mm): ");
											novoHorario = scan.next();				
										}

										try {
											formatHorarioDisciplina.parse(novoHorario);						
											cursos.get(i).getDisciplina().get(j).getHorarios().get(horarioEscolhido).setHorario(novoHorario);;					
										} catch (ParseException e) {
											e.printStackTrace();
										}

									}
								}

							}else {

								System.out.println("Tem certeza que deseja deletar a disciplina?\n1 - Sim\n2 - Não");
								int certeza = scan.nextInt();
								if(certeza == 1) {

									cursos.get(i).getDisciplina().get(j).getCodigo().remove(codigoDisciplina);
									cursos.get(i).getDisciplina().get(j).getAula().removeAll(aulas);
									cursos.get(i).getDisciplina().get(j).getDatas().removeAll(datas);
									cursos.get(i).getDisciplina().get(j).getDocente().getNome();
									cursos.get(i).getDisciplina().get(j).getHorarios().remove(horariosDisciplina);
									cursos.get(i).getDisciplina().get(j).setNome(null);
									cursos.get(i).getDisciplina().get(j).setSigla(null);


								}else {
									menu();									
								}

							}

						}else {
							System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
							int novaTentativa = scan.nextInt();

							if(novaTentativa == 1) {
								criacaoRemocaoDisciplinas();
							}							
						}


					}

					int horarioInt = scan.nextInt();

					if(horarioInt >= cursos.get(i).getHorarios().size())
						horarioInt = cursos.get(i).getHorarios().size() - 1;
					if(horarioInt < 1)
						horarioInt = 0;

					System.out.println("Informe o novo horário: ");
					String horarioNovo = scan.next();

					while(verificaFormatoHorariosCurso(horarioNovo) == false) {
						System.out.println("Informe o novo horário: ");
						horarioNovo = scan.next();
					}

					try {			
						formatHorarioCurso.parse(horarioNovo);
						cursos.get(i).getHorarios().get(horarioInt - 1).setHorario(horarioNovo);
					} catch (ParseException e1) {

						e1.printStackTrace();
					}

				}else {

					System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
					int novaTentativa = scan.nextInt();

					if(novaTentativa == 1) {
						criacaoRemocaoDisciplinas();
					}

				}
			}

		}else {


			System.out.println("Informe o codigo do curso no qual deseja realizar a inserção da disciplina:");
			String codigoCurso = scan.next();

			for(int i = 0; i < cursos.size(); i++) {

				if(cursos.get(i).getCodigo().contains(codigoCurso)) {

					Disciplina disciplina = new Disciplina();

					System.out.println("Qual o código da disciplina?");
					String codigoDisciplinaStr = scan.next();
					codigoDisciplina.add(codigoDisciplinaStr);
					disciplina.setCodigo(codigoDisciplina);

					System.out.println("Informe a sigla da disciplina: ");
					String sigla = scan.next();
					disciplina.setSigla(sigla);

					System.out.println("Informe o nome da disciplina: ");
					String nomeDisciplina = scan.next();
					disciplina.setNome(nomeDisciplina);

					System.out.println("Informe o nome do docente");
					String nomeDocente = scan.next();
					disciplina.setDocente(new Docente());
					disciplina.getDocente().setNome(nomeDocente);

					String cpfDocente = null;
					System.out.println("Informe o cpf do docente");
					cpfDocente = scan.next();
					while(verificaCpf(cpfDocente) != true) {
						System.out.println("Informe o cpf do docente");
						cpfDocente = scan.next();
					}
					CPF.add(cpfDocente);
					disciplina.getDocente().setNome(nomeDocente);

					System.out.println("Quantas aulas semanais?");
					int numAulas = scan.nextInt();

					if(numAulas < 1)
						numAulas = 1;
					if(numAulas > 6)
						numAulas = 6;

					for(int j = 0; j < numAulas; j++) {

						Aula aula = new Aula();
						System.out.println("Informe a duração da disciplina em horas: ");
						float horas = scan.nextFloat();

						if(horas > 90)
							horas = 90;
						if(horas < 30)
							horas = 30;

						aula.setDuracao(horas);
						aulas.add(aula);

					}
					disciplina.setAula(aulas);

					System.out.println("Informe as datas (dd-MM-yyyy): ");
					String data = null;

					for(int j = 0; j < numAulas; j++) {

						data = scan.next();

						while(validaDatasDisciplinas(data) != true) {
							System.out.println("Informe as datas (dd-MM-yyyy): ");
							data = scan.next();				
						}

						try {
							formatDataDisciplina.parse(data);
							datas.add(data);							
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					disciplina.setDatas(datas);

					System.out.println("Quais os horarios das aulas da disciplina? HH:mm");
					String horario = null;

					for(int j = 0; j < numAulas; j++) {
						Horario horarioDisciplina = new Horario();
						horario = scan.next();

						while(validaHorariosDisciplinas(horario) != true) {
							System.out.println("Quais os horarios das aulas da disciplina? HH:mm");
							horario = scan.next();				
						}

						try {
							formatHorarioDisciplina.parse(horario);
							horarioDisciplina.setHorario(horario);	
							horariosDisciplina.add(horarioDisciplina);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}

					disciplinas.add(disciplina);

					cursos.get(i).setDisciplina(disciplinas);

				}else {

					System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
					int novaTentativa = scan.nextInt();

					if(novaTentativa == 1) {
						criacaoRemocaoDisciplinas();
					}

				}

			}


		}

		scan.close();

	}


	private static void alterarHorariosDeCursos() {

		Scanner scan = new Scanner (System.in);


		System.out.println("O horário já existe?\n1 - Sim\n2 - Não");
		int existe = scan.nextInt();

		if(existe == 1) {

			System.out.println("Informe o codigo do curso no qual deseja realizar a alteração :");
			String codigoCurso = scan.next();


			for(int i = 0; i < cursos.size(); i++) {

				if(cursos.get(i).getCodigo().contains(codigoCurso)) {

					System.out.println("Qual Horario deseja alterar?");
					for(int j = 0; j < cursos.get(i).getHorarios().size(); j++) {
						int display = j + 1;
						System.out.println("Horário: " + display + cursos.get(i).getHorarios().get(j).getHorario());
					}
					int horarioInt = scan.nextInt();

					if(horarioInt >= cursos.get(i).getHorarios().size())
						horarioInt = cursos.get(i).getHorarios().size() - 1;
					if(horarioInt < 1)
						horarioInt = 0;

					System.out.println("Informe o novo horário: ");
					String horarioNovo = scan.next();

					while(verificaFormatoHorariosCurso(horarioNovo) == false) {
						System.out.println("Informe o novo horário: ");
						horarioNovo = scan.next();
					}

					try {			
						formatHorarioCurso.parse(horarioNovo);
						cursos.get(i).getHorarios().get(horarioInt - 1).setHorario(horarioNovo);
					} catch (ParseException e1) {

						e1.printStackTrace();
					}

				}else {

					System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
					int novaTentativa = scan.nextInt();

					if(novaTentativa == 1) {
						alterarHorariosDeCursos();
					}

				}

			}
		}else {

			Horario horarioCurso = new Horario();
			String horarioCursoStr = null;

			System.out.println("Quais os novos horarios do curso? HH:mm-HH:mm");
			horarioCursoStr = scan.next();

			while(verificaFormatoHorariosCurso(horarioCursoStr) != true) {
				System.out.println("Quais os novos horarios do curso? HH:mm-HH:mm");
				horarioCursoStr = scan.next();				
			}

			try {			
				formatHorarioCurso.parse(horarioCursoStr);
				horarioCurso.setHorario(horarioCursoStr);
				horariosCurso.add(horarioCurso);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

		}

		scan.close();

	}

	public static void criarCurso() {


		Scanner scan = new Scanner (System.in);
		Curso curso = new Curso();

		System.out.println("Nome do curso: ");
		String nomeCurso = scan.next();

		curso.setNome(nomeCurso);
		System.out.println("Código: : ");
		String codigoCursoStr = scan.next();
		codigoCurso.add(codigoCursoStr);
		curso.setCodigo(codigoCurso);

		System.out.println("Quantos turnos diferentes o curso tem?");
		int turnos = scan.nextInt();

		if(turnos > 3)
			turnos = 3;
		if(turnos < 1)
			turnos = 1;


		Horario horarioCurso = new Horario();
		String horarioCursoStr = null;

		for(int j = 0; j < turnos; j++) {
			System.out.println("Quais os horarios do curso? HH:mm-HH:mm");
			horarioCursoStr = scan.next();

			while(verificaFormatoHorariosCurso(horarioCursoStr) != true) {
				System.out.println("Quais os horarios do curso? HH:mm-HH:mm");
				horarioCursoStr = scan.next();				
			}

			try {			
				formatHorarioCurso.parse(horarioCursoStr);
				horarioCurso.setHorario(horarioCursoStr);
				horariosCurso.add(horarioCurso);
			} catch (ParseException e1) {

				e1.printStackTrace();
			}


		}

		curso.setHorarios(horariosCurso);

		System.out.println("Quantas disciplinas: ");
		int numDisciplinas = scan.nextInt();

		if(numDisciplinas < 1)
			numDisciplinas = 1;


		for(int i = 0; i < numDisciplinas; i++) {

			Disciplina disciplina = new Disciplina();

			System.out.println("Qual o código da disciplina?");
			String codigoDisciplinaStr = scan.next();
			codigoDisciplina.add(codigoDisciplinaStr);
			disciplina.setCodigo(codigoDisciplina);

			System.out.println("Informe a sigla da disciplina: ");
			String sigla = scan.next();
			disciplina.setSigla(sigla);

			System.out.println("Informe o nome da disciplina: ");
			String nomeDisciplina = scan.next();
			disciplina.setNome(nomeDisciplina);

			System.out.println("Informe o nome do docente");
			String nomeDocente = scan.next();
			disciplina.setDocente(new Docente());
			disciplina.getDocente().setNome(nomeDocente);

			String cpfDocente = null;
			System.out.println("Informe o cpf do docente");
			cpfDocente = scan.next();
			while(verificaCpf(cpfDocente) != true) {
				System.out.println("Informe o cpf do docente");
				cpfDocente = scan.next();
			}
			CPF.add(cpfDocente);
			disciplina.getDocente().setNome(nomeDocente);

			System.out.println("Quantas aulas semanais?");
			int numAulas = scan.nextInt();

			if(numAulas < 1)
				numAulas = 1;
			if(numAulas > 6)
				numAulas = 6;

			for(int j = 0; j < numAulas; j++) {

				Aula aula = new Aula();
				System.out.println("Informe a duração da disciplina em horas: ");
				float horas = scan.nextFloat();

				if(horas > 90)
					horas = 90;
				if(horas < 30)
					horas = 30;

				aula.setDuracao(horas);
				aulas.add(aula);

			}
			disciplina.setAula(aulas);

			System.out.println("Informe as datas (dd-MM-yyyy): ");
			String data = null;

			for(int j = 0; j < numAulas; j++) {

				data = scan.next();

				while(validaDatasDisciplinas(data) != true) {
					System.out.println("Informe as datas (dd-MM-yyyy): ");
					data = scan.next();				
				}

				try {
					formatDataDisciplina.parse(data);
					datas.add(data);							
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			disciplina.setDatas(datas);

			System.out.println("Quais os horarios das aulas da disciplina? HH:mm");
			String horario = null;

			for(int j = 0; j < numAulas; j++) {
				Horario horarioDisciplina = new Horario();
				horario = scan.next();

				while(validaHorariosDisciplinas(horario) != true) {
					System.out.println("Quais os horarios das aulas da disciplina? HH:mm");
					horario = scan.next();				
				}

				try {
					formatHorarioDisciplina.parse(horario);
					horarioDisciplina.setHorario(horario);	
					horariosDisciplina.add(horarioDisciplina);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			disciplinas.add(disciplina);

		}

		curso.setDisciplina(disciplinas);

		cursos.add(curso);

		scan.close();

	}

	private static boolean validaHorariosDisciplinas(String horario) {

		char[] horarioChar = horario.toCharArray();

		if(horario.length() != 5)
			return false;

		for(int i = 0; i < horarioChar.length; i++) {

			if(horarioChar[i] != '1' && horarioChar[i] != '2' && horarioChar[i] != '3' ||
					horarioChar[i] != '4' || horarioChar[i] != '5' || horarioChar[i] != '6' ||
					horarioChar[i] != '7' || horarioChar[i] != '8' || horarioChar[i] != '9' ||
					horarioChar[i] != '0' || horarioChar[i] != ':'){

				return false;
			}

		}

		return true;
	}

	private static boolean validaDatasDisciplinas(String data) {

		char[] dataChar = data.toCharArray();

		for(int i = 0; i < dataChar.length; i++) {

			if(dataChar[i] != '1' && dataChar[i] != '2' && dataChar[i] != '3' &&
					dataChar[i] != '4' && dataChar[i] != '5' && dataChar[i] != '6' &&
					dataChar[i] != '7'&& dataChar[i] != '8' && dataChar[i] != '9' ||
					dataChar[i] != '0' && dataChar[i] != '-'){

				return false;
			}

		}

		return true;


	}

	private static boolean verificaCpf(String CPF) {

		while (CPF.equals("00000000000") ||
				CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999")) 
			return false;	

		char[] CPFChar = CPF.toCharArray();

		if(CPF.length() != 11)
			return false;

		for(int i = 0; i < CPFChar.length; i++) {

			if(CPFChar[i] != '1' && CPFChar[i] != '2' && CPFChar[i] != '3' &&
					CPFChar[i] != '4' && CPFChar[i] != '5' && CPFChar[i] != '6' &&
					CPFChar[i] != '7' && CPFChar[i] != '8' && CPFChar[i] != '9' &&
					CPFChar[i] != '0')

				return false;


		}


		return true;


	}

	private static boolean verificaFormatoHorariosCurso(String horarioCursoStr) {

		char[] horariosChar = horarioCursoStr.toCharArray();

		if(horarioCursoStr.length() != 11)
			return false;

		for(int i = 0; i < horariosChar.length; i++) {

			if(horariosChar[i] != '1' && horariosChar[i] != '2' && horariosChar[i] != '3' &&
					horariosChar[i] != '4' && horariosChar[i] != '5' && horariosChar[i] != '6' &&
					horariosChar[i] != '7' && horariosChar[i] != '8' && horariosChar[i] != '9' &&
					horariosChar[i] != '0' && horariosChar[i] != ':' && horariosChar[i] != '-')

				return false;


		}

		return true;

	}



}
