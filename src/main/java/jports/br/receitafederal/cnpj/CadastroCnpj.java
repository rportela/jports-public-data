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

import jports.text.FixedLengthAspect;

public class CadastroCnpj {

	public final int parse(
			ZipInputStream input,
			Charset charset,
			Consumer<CadastroCnpjHeader> headerConsumer,
			Consumer<CadastroCnpjEmpresa> empresaConsumer,
			Consumer<CadastroCnpjSocio> socioConsumer) throws IOException {

		if (input == null)
			return -1;

		FixedLengthAspect<CadastroCnpjHeader> headerSchema = new FixedLengthAspect<>(CadastroCnpjHeader.class);
		FixedLengthAspect<CadastroCnpjEmpresa> empresaSchema = new FixedLengthAspect<>(CadastroCnpjEmpresa.class);
		FixedLengthAspect<CadastroCnpjSocio> socioSchema = new FixedLengthAspect<>(CadastroCnpjSocio.class);
		int lineCounter = 0;
		while ((input.getNextEntry()) != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input, charset));
			String line;
			while ((line = reader.readLine()) != null) {
				lineCounter++;
				char tipo_registro = line.charAt(0);
				switch (tipo_registro) {
				case '0':
					CadastroCnpjHeader header = headerSchema.parseLine(line);
					headerConsumer.accept(header);
					break;
				case '1':
					CadastroCnpjEmpresa empresa = empresaSchema.parseLine(line);
					empresaConsumer.accept(empresa);
					break;
				case '2':
					CadastroCnpjSocio socio = socioSchema.parseLine(line);
					socioConsumer.accept(socio);
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

	public final void parse(
			File file,
			Charset charset,
			Consumer<CadastroCnpjHeader> headerConsumer,
			Consumer<CadastroCnpjEmpresa> empresaConsumer,
			Consumer<CadastroCnpjSocio> socioConsumer) throws FileNotFoundException, IOException {
		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
			parse(zis, charset, headerConsumer, empresaConsumer, socioConsumer);
		}
	}

	public final void parse(
			File file,
			Consumer<CadastroCnpjHeader> headerConsumer,
			Consumer<CadastroCnpjEmpresa> empresaConsumer,
			Consumer<CadastroCnpjSocio> socioConsumer) throws FileNotFoundException, IOException {
		parse(file, StandardCharsets.ISO_8859_1, headerConsumer, empresaConsumer, socioConsumer);
	}

	public final void parse(
			String name,
			Consumer<CadastroCnpjHeader> headerConsumer,
			Consumer<CadastroCnpjEmpresa> empresaConsumer,
			Consumer<CadastroCnpjSocio> socioConsumer) throws FileNotFoundException, IOException {
		parse(new File(name), StandardCharsets.ISO_8859_1, headerConsumer, empresaConsumer, socioConsumer);
	}

	public static final void main(String... args) {
		String file = "/home/rportela/Downloads/DADOS_ABERTOS_CNPJ_01.zip";
		try {
			new CadastroCnpj().parse(file, h -> {
			}, e -> {
			}, s -> {
			});

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
