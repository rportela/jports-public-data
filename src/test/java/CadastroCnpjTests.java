import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import jports.br.receitafederal.cnpj.CadastroCnpj;

public class CadastroCnpjTests {

	@Test
	public void testReadFile() {
		String file = "/home/rportela/Downloads/DADOS_ABERTOS_CNPJ_01.zip";
		CadastroCnpj cad = new CadastroCnpj();
		try {
			cad.onHeader = h -> {
			};
			cad.onEmpresa = e -> {
			};
			cad.onSocio = s -> {
			};
			cad.onCnaeSecundaria = cs -> {
			};
			cad.onTrailer = t -> {
			};
			int lines = cad.parse(file);
			System.out.println(lines);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
