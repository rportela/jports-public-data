package jports.br.receitafederal.cnpj.schema;

import java.util.ArrayList;

import jports.ShowStopper;
import jports.adapters.Adapter;
import jports.adapters.ArrayAdapter;

public class CnaeSecundariaAdapter implements Adapter<int[]> {

	@Override
	public int[] parse(String source) {
		if (source == null || source.isEmpty())
			return null;
		ArrayList<Integer> list = new ArrayList<>(99);
		for (int i = 0; i < source.length(); i += 7) {
			String s = source.substring(i, i + 7);
			int value = Integer.parseInt(s);
			if (value > 0)
				list.add(value);
		}
		return list.isEmpty() ? null : ArrayAdapter.toIntArray(list);
	}

	@Override
	public String format(int[] source) {
		StringBuilder builder = new StringBuilder(800);
		for (int i = 0; i < source.length; i++)
			builder.append(String.format("%07d", source[i]));
		return builder.toString();
	}

	@Override
	public int[] convert(Object source) {
		if (source == null)
			return null;
		else if (source instanceof int[])
			return (int[]) source;
		else if (source instanceof String)
			return parse((String) source);
		else
			throw new ShowStopper("Can't convert " + source + " to int[]");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<int[]> getDataType() {
		return (Class<int[]>) new int[0].getClass();
	}

}
