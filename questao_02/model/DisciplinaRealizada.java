package model;

public class DisciplinaRealizada extends Disciplina{
	
	public Disciplina disciplina;
	
	public float nota;
		
	public DisciplinaRealizada() {}
	
	

	public DisciplinaRealizada(Disciplina disciplina, float nota) {
		super();
		this.disciplina = disciplina;
		this.nota = nota;
	}



	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	
}
