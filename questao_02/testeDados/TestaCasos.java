package testeDados;
import model.*;
import view.*;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class TestaCasos {

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

	Curso cursoTeste = new Curso(new HashSet(), "CURSO_1", new ArrayList(), new ArrayList(), new ArrayList());
	Aluno alunoTeste = new Aluno("Ino Cente", new HashSet());


	@Test
	void criarCurso() {

		codigoCurso.add("123");
		cursoTeste.setCodigo(codigoCurso);

		assertNotNull(cursoTeste.getNome());
		assertNotNull(cursoTeste.getCodigo());
	}


	@Test
	void criacaoDeHorarioDeCurso(){

		horariosCurso.add(new Horario());
		horariosCurso.get(0).setHorario("18:00-22:00");
		cursoTeste.setHorarios(horariosCurso);

		assertNotNull(cursoTeste.getHorarios().get(0).getHorario());

	}

	@Test
	void alteracaoDeHorarioDeCurso(){


		horariosCurso.add(new Horario());
		horariosCurso.get(0).setHorario("21:00-22:00");
		horariosCurso.get(0).setHorario("19:00-21:00");
		//cursoTeste.getHorarios().get(0).setHorario("09:00-11:00");
		cursoTeste.setHorarios(horariosCurso);

		assertNotNull(cursoTeste.getHorarios().get(0).getHorario());

	}

	@Test
	void criacaoDeDisciplina(){

		disciplinas.add(new Disciplina());

		disciplinas.get(0).setSigla("disc01");
		disciplinas.get(0).setNome("Disciplina 01");
		disciplinas.get(0).setHorarios(new ArrayList());
		disciplinas.get(0).getHorarios().add(new Horario());
		disciplinas.get(0).getHorarios().get(0).setHorario("09:00");
		disciplinas.get(0).setDocente(new Docente());
		disciplinas.get(0).getDocente().setNome("Sabi Chao");
		disciplinas.get(0).getDocente().setCpf(new HashSet());
		CPF.add("86449420189");
		datas.add("12-12-2021");
		datas.add("20-12-2021");
		disciplinas.get(0).setDatas(datas);
		codigoDisciplina.add("123q");

		disciplinas.get(0).setCodigo(codigoDisciplina);
		aulas.add(new Aula());
		aulas.get(0).setDuracao(60);
		disciplinas.get(0).setAula(aulas);

		cursoTeste.setDisciplina(disciplinas);

		assertNotNull(cursoTeste.getDisciplina().get(0).getAula().get(0).getDuracao());

	}

	@Test
	void alteracaoDeDisciplina(){

		disciplinas.add(new Disciplina());

		disciplinas.get(0).setSigla("disc01.1");//alteracao
		disciplinas.get(0).setNome("Disciplina 01.1");//alteracao
		disciplinas.get(0).getHorarios().get(0).setHorario("10:00");
		disciplinas.get(0).setDocente(new Docente());
		disciplinas.get(0).setDatas(datas);

		aulas.get(0).setDuracao(90);//alteracao
		disciplinas.get(0).setAula(aulas);

		cursoTeste.setDisciplina(disciplinas);

		assertNotNull(cursoTeste.getDisciplina().get(0).getAula().get(0).getDuracao());
		assertNotNull(cursoTeste.getDisciplina().get(0).getSigla());
		assertNotNull(cursoTeste.getNome());

	}

	@Test
	void remocaoDisciplina() {		


		disciplinas.get(0).setSigla("disc01");
		disciplinas.get(0).setNome("Disciplina 01");
		disciplinas.get(0).setHorarios(new ArrayList());
		disciplinas.get(0).getHorarios().add(new Horario());
		disciplinas.get(0).getHorarios().get(0).setHorario("09:00");
		disciplinas.get(0).setDocente(new Docente());
		disciplinas.get(0).getDocente().setNome("Sabi Chao");
		disciplinas.get(0).getDocente().setCpf(new HashSet());
		CPF.add("86449420189");
		datas.add("12-12-2021");
		datas.add("20-12-2021");
		disciplinas.get(0).setDatas(datas);
		codigoDisciplina.add("123q");

		disciplinas.get(0).setCodigo(codigoDisciplina);
		aulas.add(new Aula());
		aulas.get(0).setDuracao(60);
		disciplinas.get(0).setAula(aulas);

		cursoTeste.setDisciplina(disciplinas);

		//disciplinas.remove(0);
		cursoTeste.getDisciplina().set(0, null);

		assertNull(disciplinas.get(0));

	}

	@Test
	void inscricaoDeAlunoQueNaoExisteEmCurso(){

		//System.out.println("O aluno já consta no cadastro do curso?\n1 - Sim\n2 - Não");
		int existe = 2;

		if(existe == 1) {

			//System.out.println("Informe o codigo da disciplina na qual deseja inscrever do aluno:");
			String codigoDisciplina = "123";

			for(int i = 0; i < cursos.size(); i++) {

				for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

					if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

						//System.out.println("Informe o CPF do aluno: ");
						String cpfStr = "45678912341";	
						//while(verificaCpf(cpfStr) != true) {
							////System.out.println("Informe o CPF do aluno:");
							//cpfStr = scan.next();
						//}

						for (int k = 0; k < cursos.get(i).getAluno().size() ; k++) {

							if(cursos.get(i).getAluno().get(k).getCpf().contains(cpfStr)) {

								disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));
								assertNull(disciplinasInscritas.get(i));

							}else {

								//System.out.println("O CPF informado não consta no cadastro.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
								int novaTentativa = 2;

								//if(novaTentativa == 1) {
								//	inscricaoDeAlunoEmCursoDisciplinas();
								//}	

							}
						}


					}else {

						//System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
						int novaTentativa = 2;

						//if(novaTentativa == 1) {
						//	inscricaoDeAlunoEmCursoDisciplinas();
						//}	

					}		



				}

			}

		}else {


			Aluno aluno = new Aluno();
			String cpfStr = null;

			//System.out.println("Qual o nome do aluno?");
			String nomeAluno = "Ino Cente";
			aluno.setNome(nomeAluno);

			//System.out.println("Informe o cpf do aluno: ");
			cpfStr = "12345678914";	
			//while(verificaCpf(cpfStr) != true) {
			//	//System.out.println("Informe o cpf do aluno:");
				//cpfStr = scan.next();
			//}
			CPF.add(cpfStr);			
			aluno.setCpf(CPF);

			//System.out.println("Informe o codigo do curso no qual deseja matricular o aluno:");
			String codigoCurso = "123";

			for(int i = 0; i < cursos.size(); i++) {

				if(cursos.get(i).getCodigo().contains(codigoCurso)) {

					cursos.get(i).getAluno().add(aluno);

					//System.out.println("Informe o código da disciplina: ");
					String codigoDisciplina = "123";

					for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

						if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

							//System.out.println("Essa disciplina já foi cursada em outro lugar?\n1 - Sim\n2 - Não");
							int resposta = 1;

							if(resposta == 1) {
								disciplinasRealizadas.add(cursos.get(i).getDisciplina().get(j));
								for(int k = 0; k < disciplinasRealizadas.size(); k++) {

									if(aluno.getDisciplinaRealizadas().get(k).getCodigo().contains(codigoDisciplina)){

										//System.out.println("Qual foi a nota obtida");
										float nota = 8;

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
												assertNotNull(alunos.get(i).getTotalCargaHorariaCumprida());
											}


										}

									}


								}


							}else {
								disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));
								aluno.setDisciplinasInscritas(disciplinasInscritas);
								assertNotNull(aluno.getDisciplinasInscritas());
							}

						}else {
							//System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
							int novaTentativa = 2;

							//if(novaTentativa == 1) {
						//		inscricaoDeAlunoEmCursoDisciplinas();
							//}	

						}
					}
				}else {
					//System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
					int novaTentativa = 2;

					//if(novaTentativa == 1) {
				//		inscricaoDeAlunoEmCursoDisciplinas();
				//	}	
				}

			}

		}


		//assertNotNull(alunos.get(0).getDisciplinasInscritas());

	}
	
	
	@Test
	void inscricaoDeAlunoQueExisteEmCurso(){

		//System.out.println("O aluno já consta no cadastro do curso?\n1 - Sim\n2 - Não");
		int existe = 1;

		if(existe == 1) {

			//System.out.println("Informe o codigo da disciplina na qual deseja inscrever do aluno:");
			String codigoDisciplina = "123";

			for(int i = 0; i < cursos.size(); i++) {

				for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

					if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

						//System.out.println("Informe o CPF do aluno: ");
						String cpfStr = "45678912341";	
						//while(verificaCpf(cpfStr) != true) {
							////System.out.println("Informe o CPF do aluno:");
							//cpfStr = scan.next();
						//}

						for (int k = 0; k < cursos.get(i).getAluno().size() ; k++) {

							if(cursos.get(i).getAluno().get(k).getCpf().contains(cpfStr)) {

								disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));
								assertNotNull(disciplinasInscritas.get(i));

							}else {

								//System.out.println("O CPF informado não consta no cadastro.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
								int novaTentativa = 2;

								//if(novaTentativa == 1) {
								//	inscricaoDeAlunoEmCursoDisciplinas();
								//}	

							}
						}


					}else {

						//System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
						int novaTentativa = 2;

						//if(novaTentativa == 1) {
						//	inscricaoDeAlunoEmCursoDisciplinas();
						//}	

					}		



				}

			}

		}else {


			Aluno aluno = new Aluno();
			String cpfStr = null;

			//System.out.println("Qual o nome do aluno?");
			String nomeAluno = "Ino Cente";
			aluno.setNome(nomeAluno);

			//System.out.println("Informe o cpf do aluno: ");
			cpfStr = "12345678914";	
			//while(verificaCpf(cpfStr) != true) {
			//	//System.out.println("Informe o cpf do aluno:");
				//cpfStr = scan.next();
			//}
			CPF.add(cpfStr);			
			aluno.setCpf(CPF);

			//System.out.println("Informe o codigo do curso no qual deseja matricular o aluno:");
			String codigoCurso = "123";

			for(int i = 0; i < cursos.size(); i++) {

				if(cursos.get(i).getCodigo().contains(codigoCurso)) {

					cursos.get(i).getAluno().add(aluno);

					//System.out.println("Informe o código da disciplina: ");
					String codigoDisciplina = "123";

					for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

						if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {

							//System.out.println("Essa disciplina já foi cursada em outro lugar?\n1 - Sim\n2 - Não");
							int resposta = 1;

							if(resposta == 1) {
								disciplinasRealizadas.add(cursos.get(i).getDisciplina().get(j));
								for(int k = 0; k < disciplinasRealizadas.size(); k++) {

									if(aluno.getDisciplinaRealizadas().get(k).getCodigo().contains(codigoDisciplina)){

										//System.out.println("Qual foi a nota obtida");
										float nota = 8;

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
												assertNull(alunos.get(i).getTotalCargaHorariaCumprida());
											}


										}

									}


								}


							}else {
								disciplinasInscritas.add(cursos.get(i).getDisciplina().get(j));
								aluno.setDisciplinasInscritas(disciplinasInscritas);
								assertNull(aluno.getDisciplinasInscritas());
							}

						}else {
							//System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
							int novaTentativa = 2;

							//if(novaTentativa == 1) {
						//		inscricaoDeAlunoEmCursoDisciplinas();
							//}	

						}
					}
				}else {
					//System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
					int novaTentativa = 2;

					//if(novaTentativa == 1) {
				//		inscricaoDeAlunoEmCursoDisciplinas();
				//	}	
				}

			}

		}


	}

	@Test
	void geracaoDeHorario(){


		//System.out.println("Informe o CPF do aluno: ");
		String cpfStr = "86449420189";	
		//while(verificaCpf(cpfStr) != true) {
		//	//System.out.println("Informe o CPF do aluno:");
		//	cpfStr = scan.next();
		//}

		for(int i = 0; i < alunos.size(); i++) {

			if(alunos.get(i).getCpf().contains(cpfStr)) {
				//System.out.println("Horários de:" + alunos.get(i).getNome());
				for(int j = 0; j < alunos.get(i).getDisciplinasInscritas().size(); j++) {
					assertNotNull(alunos.get(i).getDisciplinasInscritas().get(j).getHorarios());
					//System.out.println(alunos.get(i).getDisciplinasInscritas().get(j).getHorarios());
				}
			}else {

				//System.out.println("O CPF informado não consta no cadastro.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
				int novaTentativa = 2;

				//if(novaTentativa == 1) {
				//	inscricaoDeAlunoEmCursoDisciplinas();
				//}	

			}
		}

	}

	@Test
	void lançamentoDeNotas(){



		//System.out.println("Informe o CPF do aluno: ");
		String cpfStr = "86048751583";	
		
		for(int i = 0; i < alunos.size(); i++) {

			if(alunos.get(i).getCpf().contains(cpfStr)) {

				//System.out.println("Informe o código da disciplina: ");
				String codigoDisciplina = "123";

				for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

					assertNotNull(cursos.get(i).getDisciplina().get(j).getCodigo());
					if(cursos.get(i).getDisciplina().get(j).getCodigo().contains(codigoDisciplina)) {
						
						disciplinasRealizadas.add(cursos.get(i).getDisciplina().get(j));

						assertNotNull(disciplinasRealizadas.get(i));
						//System.out.println("Qual foi a nota obtida");
						float nota = 9;

						if(nota < 0)
							nota = 0;
						if(nota > 10)
							nota = 10;

						for(int k = 0; k < alunos.get(i).getDisciplinaRealizadas().size(); k++) {
							if(alunos.get(i).getDisciplinaRealizadas().get(j).getCodigo().contains(codigoDisciplina)) {
								alunos.get(i).getDisciplinaRealizadas().get(j).setNota(nota);
							assertNotNull(alunos.get(i).getDisciplinaRealizadas().get(j).getNota());
							
							}
						}


						for(int k = 0; k < alunos.get(i).getDisciplinaRealizadas().get(j).getAula().size(); k++) {
							if(alunos.get(i).getDisciplinaRealizadas().get(j).getCodigo().contains(codigoDisciplina) && nota >= 5) {

								float totalHorasAulno = alunos.get(i).getTotalCargaHorariaCumprida();
								totalHorasAulno += alunos.get(i).getDisciplinaRealizadas().get(j).getAula().get(k).getDuracao();
								alunos.get(i).setTotalCargaHorariaCumprida(totalHorasAulno);
								assertNotNull(alunos.get(i).getTotalCargaHorariaCumprida());

							}
						}



					}else {
						//System.out.println("O código informado não existe.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
						int novaTentativa = 2;

						//if(novaTentativa == 1) {
							//inscricaoDeAlunoEmCursoDisciplinas();
						//}	

					}
				}

			}else {

				//System.out.println("O CPF informado não consta no cadastro.\n Quer tentar novamente?\n1 - Sim\n2 - Não");
				int novaTentativa = 2;

				//if(novaTentativa == 1) {
				//	inscricaoDeAlunoEmCursoDisciplinas();
			  //}
			}
		}

	}


	@Test
	void listagemDeAlunosAtualmenteMatriculados(){

		for(int i = 0; i < cursos.size(); i++) {

			float totalHorasCurso = 0;

			for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

				for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAula().size(); k++) {

					totalHorasCurso += cursos.get(i).getDisciplina().get(j).getAula().get(k).getDuracao();
					assertNotNull(cursos.get(i).getDisciplina().get(j).getAula().get(k).getDuracao());
				}

				//System.out.println("\nLista de alunos de : " + cursos.get(i).getNome());
				for(int k = 0; k < cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida(); k++) {

					if(cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida() < totalHorasCurso) {

						//System.out.println("- " + cursos.get(i).getAluno().get(k).getNome());
						
						assertNotNull(cursos.get(i).getAluno().get(k).getNome());
						
						//System.out.println("Matérias : ");
						//System.out.println(" - concluídas : ");
						for(int l = 0; l < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().size(); l++) {
							//System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
							assertNotNull(cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
						}

						//System.out.println(" - cursando : ");
						for(int l = 0; l < cursos.get(i).getAluno().get(k).getDisciplinasInscritas().size(); l++) {
							//System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
							assertNotNull(cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
						}

						//System.out.println(" - a cursar : ");
						for(int l = 0; l < cursos.get(i).getDisciplina().size(); l++) {

							for(int m = 0; m < cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().size(); m++) {

								String codigoRealizada = cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(k).getCodigo().toString();
								String codigoCursando = cursos.get(i).getAluno().get(k).getDisciplinasInscritas().get(k).getCodigo().toString();

								if(!cursos.get(i).getDisciplina().get(l).getCodigo().contains(codigoRealizada) &&
										!cursos.get(i).getDisciplina().get(l).getCodigo().contains(codigoCursando)) {
									//System.out.println(" - " + cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
								assertNotNull(cursos.get(i).getAluno().get(k).getDisciplinaRealizadas().get(l).getNome());
								}

							}


						}

					}
				}	

			}

		}
	}
	
	@Test
	void listagemDeAlunos(){
		
		for(int i = 0; i < cursos.size(); i++) {

			float totalHorasCurso = 0;

			for(int j = 0; j < cursos.get(i).getDisciplina().size(); j++) {

				for(int k = 0; k < cursos.get(i).getDisciplina().get(j).getAula().size(); k++) {

					totalHorasCurso += cursos.get(i).getDisciplina().get(j).getAula().get(k).getDuracao();
					assertNotNull(cursos.get(i).getDisciplina().get(j).getAula().get(k).getDuracao());
				}

				//System.out.println("\nLista de ex-alunos de : " + cursos.get(i).getNome());
				for(int k = 0; k < cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida(); k++) {

					if(cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida() >= totalHorasCurso) {

						assertNotNull(cursos.get(i).getAluno().get(k).getTotalCargaHorariaCumprida());
						//System.out.println("- " + cursos.get(i).getAluno().get(k).getNome());
					}
				}	

			}

		}
		
	}

}
