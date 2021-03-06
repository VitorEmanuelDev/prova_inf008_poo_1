package questao_01;

public class ConversaoDeUnidadesDeArea {

	private float area;

	public ConversaoDeUnidadesDeArea() {}

	public ConversaoDeUnidadesDeArea(float area) {
		this.area = area;
	}

	public float converteMetrosParaPes(float area){
		return (float) (area * 10.76);
	}

	public float convertePesParaCm(float area){
		return (float) (area * 929);
	}

	public float converteMilhasParaAcres(float area){
		return (float) (area * 640);
	}

	public float converteAcresParaPes(float area){
		return (float) (area * 43560);
	}
	
	public float converteMetrosParaAcres(float area){
		return (float) (area * 0.000247105);
	}
	
	public float converteMetrosParaCm(float area){
		return (float) (area * 100);
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	
}
