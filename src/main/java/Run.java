import javax.ws.rs.NotAllowedException;

import org.model.DaoProduto;
import org.model.ProdutoDto;

import com.sun.javadoc.ThrowsTag;

public class Run {
	public static void main(String[] args) {
	
		ProdutoDto produto = new ProdutoDto("Computador",1599.89);
		DaoProduto dao = new DaoProduto();
		dao.add(produto);
		
		
			
		
//		String meuTexto = "good";
//		char[]meuArr = {'g','o','o','d'};
//		
//		String novoTexto = null;
//		for(char ch: meuArr) {
//			novoTexto = novoTexto + ch;
//		}
//		System.out.println((novoTexto == meuTexto) + "" +(novoTexto.equals(meuTexto)));
//		
//
//	}
}
	}


