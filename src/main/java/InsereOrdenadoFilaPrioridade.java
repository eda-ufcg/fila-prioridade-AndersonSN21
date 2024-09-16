public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		Pair newPair = new Pair(elemento, prioridade);
		if (this.head == -1) {
			this.head++;
			this.last++;
			fila[last] = newPair;
		
		} else if (this.head == this.last){
			if (this.fila[this.last].getPrioridade() < prioridade) {
				Pair aux = this.fila[this.last];
				this.fila[this.last] = newPair;
				this.last = (this.last + 1) % this.fila.length;
				this.fila[this.last] = aux; 
			
			} else {
				this.last = (this.last + 1) % this.fila.length;
				this.fila[this.last] = newPair;
			}
		
		} else {
			this.last = (this.last + 1) % this.fila.length;
        	this.fila[this.last] = newPair;

			int i = this.last;
            while (i != this.head) {
                int prev = (i - 1 + this.fila.length) % this.fila.length;
                
				if (this.fila[i].getPrioridade() > this.fila[prev].getPrioridade()) {
                    Pair aux = this.fila[i];
                    this.fila[i] = this.fila[prev];
                    this.fila[prev] = aux;
                    i = prev;
				} else {
					break;
				}
			}
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		Pair aux = fila[this.head];
        if (this.head == this.last) {
            this.head = -1;
            this.last = -1;
        } else {
            this.head = (this.head + 1) % this.fila.length;
        }
        return aux.getElemento();
	}
}
