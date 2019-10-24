package jports.br.receitafederal.cnpj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
import java.util.zip.ZipInputStream;

import jports.br.receitafederal.cnpj.schema.CnaeSecundaria;
import jports.br.receitafederal.cnpj.schema.Empresa;
import jports.br.receitafederal.cnpj.schema.Header;
import jports.br.receitafederal.cnpj.schema.Socio;
import jports.br.receitafederal.cnpj.schema.Trailer;
import jports.text.FixedLengthAspect;

public class CadastroCnpj {

	public Charset charset = StandardCharsets.ISO_8859_1;
	public Consumer<Header> onHeader;
	public Consumer<Empresa> onEmpresa;
	public Consumer<Socio> onSocio;
	public Consumer<CnaeSecundaria> onCnaeSecundaria;
	public Consumer<Trailer> onTrailer;

	public final int parse(ZipInputStream input) throws IOException {

		if (input == null)
			return -1;

		FixedLengthAspect<Header> headerSchema = new FixedLengthAspect<>(Header.class);
		FixedLengthAspect<Empresa> empresaSchema = new FixedLengthAspect<>(Empresa.class);
		FixedLengthAspect<Socio> socioSchema = new FixedLengthAspect<>(Socio.class);
		FixedLengthAspect<CnaeSecundaria> cnaeSecundariaSchema = new FixedLengthAspect<>(CnaeSecundaria.class);
		FixedLengthAspect<Trailer> trailerSchema = new FixedLengthAspect<>(Trailer.class);

		int lineCounter = 0;
		while ((input.getNextEntry()) != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input, charset));
			String line;
			while ((line = reader.readLine()) != null) {
				lineCounter++;
				char tipo_registro = line.charAt(0);
				switch (tipo_registro) {
				case '0':
					if (this.onHeader != null) {
						Header header = headerSchema.parseLine(line);
						this.onHeader.accept(header);
					}
					break;
				case '1':
					if (this.onEmpresa != null) {
						Empresa empresa = empresaSchema.parseLine(line);
						this.onEmpresa.accept(empresa);
					}
					break;
				case '2':
					if (this.onSocio != null) {
						Socio socio = socioSchema.parseLine(line);
						this.onSocio.accept(socio);
					}
					break;
				case '6':
					if (this.onCnaeSecundaria != null) {
						CnaeSecundaria cs = cnaeSecundariaSchema.parseLine(line);
						this.onCnaeSecundaria.accept(cs);
					}
					break;
				case '9':
					if (this.onTrailer != null) {
						Trailer trailer = trailerSchema.parseLine(line);
						this.onTrailer.accept(trailer);
					}
					break;

				}
				/*
				 * System.out.println(lineCounter + " -> " + tipo_registro + " -> " + line); if
				 * (lineCounter > 100) break;
				 */
			}
		}
		return lineCounter;
	}

	public final int parse(File file) throws FileNotFoundException, IOException {
		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
			return parse(zis);
		}
	}

	public final int parse(
			String name) throws FileNotFoundException, IOException {
		return parse(new File(name));
	}

}
