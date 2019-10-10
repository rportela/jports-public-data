package jports.br.receitafederal.cnpj;

import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

@FixedLengthTable
public class CadastroCnpjSocio {

	/**
	 * CONTEM O NÚMERO DE INSCRIÇÃO NO CNPJ (CADASTRO NACIONAL DA PESSOA JURÍDICA).
	 */
	@FixedLengthColumn(start = 3, end = 17)
	public long cnpj;

	/**
	 * <p>
	 * IDENTIFICADOR DE SOCIO
	 * </p>
	 * <ul>
	 * <li>1 – PESSOA JURÍDICA</li>
	 * <li>2 – PESSOA FISICA</li>
	 * <li>3 – ESTRANGEIRO</li>
	 * </ul>
	 */
	@FixedLengthColumn(start = 17, end = 18)
	public int tipo_socio;

	/**
	 * CORRESPONDE AO NOME SOCIO PESSOA FISICA, RAZÃO SOCIAL E/OU NOME EMPRESARIAL
	 * DA PESSOA JURÍDICA E NOME DO SÓCIO/RAZAO SOCIAL DO SOCIO ESTRANGEIRO
	 */
	@FixedLengthColumn(start = 18, end = 168)
	public String nome_socio;
	
}
