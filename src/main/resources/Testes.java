
public class Testes {

	public static void main(String args[]) {
		String meuTexto = "good";
		char[]meuArr = {'g','o','o','d'};
		
		String novoTexto = null;
		for(char ch: meuArr) {
			novoTexto = novoTexto + ch;
		}
		System.out.println((novoTexto == meuTexto))+ "" +(novoTexto.equals(meuTexto));
		System.out.println("Hello World");

	}
		
}
