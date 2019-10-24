package jports.br.receitafederal.cnpj.schema;

import java.util.Date;

import jports.adapters.BooleanAsSpecificString;
import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

@FixedLengthTable
public class Empresa {

	/**
	 * CONTEM O NÚMERO DE INSCRIÇÃO NO CNPJ (CADASTRO NACIONAL DA PESSOA JURÍDICA).
	 */
	@FixedLengthColumn(start = 3, end = 17)
	public long cnpj;

	/**
	 * IDENTIFICADOR MATRIZ/FILIAL
	 */
	@FixedLengthColumn(start = 17, end = 18, pattern = "1", adapter = BooleanAsSpecificString.class)
	public boolean is_matriz;

	/**
	 * CORRESPONDE AO NOME EMPRESARIAL DA PESSOA JURÍDICA
	 */
	@FixedLengthColumn(start = 18, end = 168)
	public String razao_social;

	/**
	 * CORRESPONDE AO NOME FANTASIA
	 */
	@FixedLengthColumn(start = 168, end = 223)
	public String nome_fantasia;

	/**
	 * <p>
	 * CÓDIGO DA SITUAÇÃO CADASTRAL
	 * </p>
	 * <ul>
	 * <li>01 - NULA</li>
	 * <li>02 - ATIVA</li>
	 * <li>03 - SUSPENSA</li>
	 * <li>04 - INAPTA</li>
	 * <li>08 - BAIXADA</li>
	 * </ul>
	 */
	@FixedLengthColumn(start = 223, end = 225)
	public int situacao_cadastral;

	/**
	 * DATA DO EVENTO DA SITUACAO CADASTRAL
	 */
	@FixedLengthColumn(start = 225, end = 233, pattern = "yyyyMMdd")
	public Date situacao_cadastral_data;

	/**
	 * CÓDIGO DO MOTIVO DA SITUAÇÃO CADASTRAL
	 */
	@FixedLengthColumn(start = 233, end = 235)
	public int situacao_cadastral_motivo;

	/**
	 * NOME DA CIDADE NO EXTERIOR
	 */
	@FixedLengthColumn(start = 235, end = 290)
	public String cidade_no_exterior;

	/**
	 * CODIGO DO PAIS
	 */
	@FixedLengthColumn(start = 290, end = 293)
	public String pais_codigo;

	/**
	 * NOME DO PAIS
	 */
	@FixedLengthColumn(start = 293, end = 363)
	public String pais;

	/**
	 * CÓDIGO DA NATUREZA JURÍDICA
	 */
	@FixedLengthColumn(start = 363, end = 367)
	public int natureza_juridica;

	/**
	 * DATA DE INICIO DA ATIVIDADE
	 */
	@FixedLengthColumn(start = 367, end = 375, pattern = "yyyyMMdd")
	public Date inicio_atividade;

	/**
	 * INDICA O CÓDIGO DA ATIVIDADE ECONÔMICA
	 */
	@FixedLengthColumn(start = 375, end = 382)
	public int cnae_fiscal;

	/**
	 * CORRESPONDE A DESCRIÇÃO DO LOGRADOURO
	 */
	@FixedLengthColumn(start = 382, end = 402)
	public String endereco_tipo;

	/**
	 * CORRESPONDE AO NOME DO LOGRADOURO ONDE SE LOCALIZA O ESTABELECIMENTO.
	 */
	@FixedLengthColumn(start = 402, end = 462)
	public String endereco_logradouro;

	/**
	 * CORRESPONDE AO NÚMERO ONDE SE LOCALIZA O ESTABELECIMENTO, QUANDO NÃO HOUVER
	 * PREENCHIMENTO DO NÚMERO HAVERÁ ‘S/N’.
	 */
	@FixedLengthColumn(start = 462, end = 468)
	public String endereco_numero;

	/**
	 * CORRESPONDE AO COMPLEMENTO PARA O ENDEREÇO DE LOCALIZAÇÃO DO ESTABELECIMENTO
	 */
	@FixedLengthColumn(start = 468, end = 624)
	public String endereco_complemento;

	/**
	 * CORRESPONDE AO BAIRRO ONDE SE LOCALIZA O ESTABELECIMENTO.
	 */
	@FixedLengthColumn(start = 624, end = 674)
	public String endereco_bairro;

	/**
	 * CÓDIGO DE ENDEREÇAMENTO POSTAL REFERENTE AO LOGRADOURO NO QUAL O
	 * ESTABELECIMENTO ESTA LOCALIZADO
	 */
	@FixedLengthColumn(start = 674, end = 682)
	public int endereco_cep;

	/**
	 * CORRESPONDE A SIGLA DA UNIDADE DA FEDERAÇÃO EM QUE SE ENCONTRA O
	 * ESTABELECIMENTO
	 */
	@FixedLengthColumn(start = 682, end = 684)
	public String endereco_uf;

	/**
	 * CORRESPONDE AO CODIGO DO MUNICIPIO DE JURISDIÇÃO ONDE SE ENCONTRA O
	 * ESTABELECIMENTO
	 */
	@FixedLengthColumn(start = 684, end = 688)
	public int endereco_municipio_codigo;

	/**
	 * CORRESPONDE AO MUNICIPIO DE JURISDIÇÃO ONDE SE ENCONTRA O ESTABELECIMENTO
	 */
	@FixedLengthColumn(start = 688, end = 738)
	public String endereco_municipio;

	/**
	 * DDD-TELEFONE-1
	 */
	@FixedLengthColumn(start = 738, end = 750)
	public String telefone_1;

	/**
	 * DDD-TELEFONE-2
	 */
	@FixedLengthColumn(start = 750, end = 762)
	public String telefone_2;

	/**
	 * DDD-FAX
	 */
	@FixedLengthColumn(start = 762, end = 774)
	public String fax;

	/**
	 * E-MAIL DO CONTRIBUINTE
	 */
	@FixedLengthColumn(start = 774, end = 889)
	public String email;

	/**
	 * QUALIFICAÇÃO DA PESSOA FÍSICA RESPONSÁVEL PELA EMPRESA
	 */
	@FixedLengthColumn(start = 889, end = 891)
	public int responsavel_qualificacao;

	/**
	 * CAPITAL SOCIAL DA EMPRESA
	 */
	@FixedLengthColumn(start = 891, end = 905)
	public double capital_social;

	/**
	 * <p>
	 * CÓDIGO DO PORTE DA EMPRESA
	 * </p>
	 * <ul>
	 * <li>00 - NAO INFORMADO</li>
	 * <li>01 - MICRO EMPRESA</li>
	 * <li>03 - EMPRESA DE PEQUENO PORTE</li>
	 * <li>05 - DEMAIS</li>
	 * </ul>
	 */
	@FixedLengthColumn(start = 905, end = 907)
	public int porte_empresa;

	/**
	 * <p>
	 * NDICADOR DA EXISTÊNCIA DA OPÇÃO PELO SIMPLES.
	 * </p>
	 * <ul>
	 * <li>0 OU BRANCO - NÃO OPTANTE</li>
	 * <li>5 E 7 – OPTANTESPELO SIMPLES</li>
	 * <li>6 E 8 – EXCLUÍDO DO SIMPLES</li>
	 * </ul>
	 */
	@FixedLengthColumn(start = 907, end = 908)
	public int simples;

	/**
	 * DATA DE OPÇÃO PELO SIMPLES
	 */
	@FixedLengthColumn(start = 908, end = 916, pattern = "yyyyMMdd")
	public Date simples_inclusao;

	/**
	 * DATA DE EXCLUSÃO DO SIMPLES
	 */
	@FixedLengthColumn(start = 916, end = 924, pattern = "yyyyMMdd")
	public Date simples_exclusao;

	/**
	 * INDICADOR DA EXISTÊNCIA DA OPÇÃO PELO MEI
	 */
	@FixedLengthColumn(start = 924, end = 925, pattern = "S", adapter = BooleanAsSpecificString.class)
	public boolean mei;

	/**
	 * SITUAÇÃO ESPECIAL DA EMPRESA
	 */
	@FixedLengthColumn(start = 925, end = 948)
	public String situacao_especial;

	/**
	 * DATA EM QUE A EMPRESA ENTROU EM SITUAÇÃO ESPECIAL (AAAAMMDD)
	 */
	@FixedLengthColumn(start = 948, end = 956, pattern = "yyyyMMdd")
	public Date situacao_especial_data;
}
