package jports.br.b3.up2data;

/**
 * UP2DATA – EquitiesEODPriceFile
 * 
 * Price information of equities at the end of the day.
 * 
 * @author Giovanna Marinelli
 *
 */

@Up2DataTable(
	channel = "Currency", 
	subChannel = "TradeInformation", 
	prefix = "Currency_EODPriceFile_")
public class CurrencyFutureEODPrice extends EODPrice {

}
