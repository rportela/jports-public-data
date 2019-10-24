package jports.br.receitafederal.cnpj.schema;

import java.util.Date;

import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

@FixedLengthTable
public class Socio {

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

	/**
	 * É PREENCHIDO COM CPF OU CNPJ DO SOCIO, NO CASO DE SÓCIO ESTRANGEIRO É
	 * PREENCHIDO COM ‘NOVES’ O ALINHAMENTO PARA CPF É FORMATADO COM ZEROS À
	 * ESQUERDA.
	 */
	@FixedLengthColumn(start = 169, end = 182)
	public String cpf_cnpj;

	/**
	 * CODIGO QUALIFICACAO SOCIO
	 */
	@FixedLengthColumn(start = 182, end = 184)
	public String qualificacao_socio;

	/**
	 * PERCENTUAL CAPITAL SOCIAL - ZEROS (VALORES NÃO CONSIDERADOS POR TER CARATER
	 * SIGILOSO)
	 */
	@FixedLengthColumn(start = 184, end = 189)
	public double pct_capital_social;

	/*
	 * DATA DE ENTRADA NA SOCIEDADE
	 */
	@FixedLengthColumn(start = 189, end = 197, pattern = "yyyyMMdd")
	public Date data_entrada_sociedade;

	/**
	 * CODIGO PAIS DO SOCIO ESTRANGEIRO(VALORES NÃO CONSIDERADOS)
	 */
	@FixedLengthColumn(start = 197, end = 200)
	public String pais_codigo;

	/**
	 * CORRESPONDE AO NOME DO PAIS DO SÓCIO(VALORES NÃO CONSIDERADOS)
	 */
	@FixedLengthColumn(start = 200, end = 270)
	public String pais_nome;

	/**
	 * CORRESPONDE AO NÚMERO DO CPF DO REPRESENTANTE LEGAL
	 */
	@FixedLengthColumn(start = 270, end = 281)
	public String representante_cpf;

	/**
	 * CORRESPONDE AO NOME DO REPRESENTANTE LEGAL
	 */
	@FixedLengthColumn(start = 281, end = 341)
	public String representante_nome;

	/**
	 * CORRESPONDE AO CÓDIGO DA QUALIFICACAO DO REPRESENTANTE LEGAL
	 */
	@FixedLengthColumn(start = 341, end = 343)
	public String representante_qualificacao;

}
