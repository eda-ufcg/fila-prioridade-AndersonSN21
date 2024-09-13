import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);
		this.fila.add(newPair);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		int toRemoveIndex = 0;
		String toRemove = "";

		for (int i = 0; i < fila.size(); i++) {
			if (this.fila.get(toRemoveIndex).getPrioridade() > this.fila.get(toRemoveIndex).getPrioridade()) {
				toRemoveIndex = i;
			}
		}

		toRemove = this.fila.get(toRemoveIndex).getElemento();
		this.fila.remove(toRemoveIndex);
		return toRemove;
	}
}
