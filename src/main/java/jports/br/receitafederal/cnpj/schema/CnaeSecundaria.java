package jports.br.receitafederal.cnpj.schema;

import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

@FixedLengthTable
public class CnaeSecundaria {

	/**
	 * NO CASO DE ENVIO FULL, ESTE CAMPO ESTA EM BRANCO. NO CASO DE ENVIO PERÍODICO,
	 * TERÁ OS SEGUINTES DOMÍNIOS : A – ATUALIZAÇÃO DO ESTABELECIMENTO I – INCLUSÃO
	 * DE UM NOVO ESTABELECIMENTO E – EXCLUSÃO DO ESTABELECIMENTO
	 */
	@FixedLengthColumn(start = 2, end = 3)
	public String tipo_atualizacao;

	/**
	 * CONTEM O NÚMERO DE INSCRIÇÃO NO CNPJ (CADASTRO NACIONAL DA PESSOA JURÍDICA).
	 */
	@FixedLengthColumn(start = 3, end = 17)
	public long cnpj;

	/**
	 * TAMANHO DE CADA CNAE SECUNDÁRIA : 7 OCORRÊNCIA =99. COMO SE TRATA DE UM
	 * ATRIBUTO OPCIONAL, QUANDO UMA DAS OCORRENCIAS NÃO FOR INFORMADA, ESTE
	 * ATRIBUTO ESTARA PREENCHIDO COM ZEROS.
	 */
	@FixedLengthColumn(start = 17, end = 710, adapter = CnaeSecundariaAdapter.class)
	public Object cnae_secundaria;
}
