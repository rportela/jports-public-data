package jports.br.receitafederal.cnpj.schema;

import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

@FixedLengthTable
public class Trailer {

	/**
	 * TOTAL DE REGISTROS TIPO 1 DO ARQUIVO
	 */
	@FixedLengthColumn(start = 17, end = 26)
	public int total_registros_t1;

	/**
	 * TOTAL DE REGISTROS TIPO 2 DO ARQUIVO
	 */
	@FixedLengthColumn(start = 26, end = 35)
	public int total_registros_t2;

	/**
	 * TOTAL DE REGISTROS TIPO 3 DO ARQUIVO
	 */
	@FixedLengthColumn(start = 35, end = 44)
	public int total_registros_t3;

	/**
	 * TOTAL DE REGISTROS DO ARQUIVO, INCLUINDO REGISTROS HEADER/TRAILER
	 */
	@FixedLengthColumn(start = 44, end = 55)
	public int total_registros;
}
