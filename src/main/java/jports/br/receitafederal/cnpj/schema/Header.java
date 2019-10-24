package jports.br.receitafederal.cnpj.schema;

import java.util.Date;

import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

/**
 * http://200.152.38.155/CNPJ/LAYOUT_DADOS_ABERTOS_CNPJ.pdf
 * 
 * @author rportela
 *
 */
@FixedLengthTable
public class Header {

	@FixedLengthColumn(start = 17, end = 28)
	public String nome_arquivo;

	@FixedLengthColumn(start = 28, end = 36, pattern = "yyyyMMdd")
	public Date data_gravacao;

	@FixedLengthColumn(start = 36, end = 44)
	public int numero_remessa;
}
