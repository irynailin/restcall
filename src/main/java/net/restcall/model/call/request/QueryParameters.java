package net.restcall.model.call.request;

import java.util.ArrayList;
import java.util.List;

import net.restcall.model.util.SelectableNamedValue;

public class QueryParameters {
	private List<SelectableNamedValue> params = new ArrayList<>();

	public void addParameter(String name, String value) {
		SelectableNamedValue namedValue = new SelectableNamedValue(name, value);
		params.add(namedValue);
	}

	public List<SelectableNamedValue> getParams() {
		return params;
	}

	@Override
	public String toString() {
		var result = new StringBuilder();
		for (SelectableNamedValue param : params) {
			if (result.isEmpty()) {
				result.append("?");
			} else {
				result.append("&");
			}
			result.append(param.getName());
			if (!param.getValue().isBlank()) {
				result.append("=");
				result.append(param.getValue());
			}
		}
		return result.toString();
	}

	public void fromString(String parameters) {
		params.clear();
		String[] pairs = parameters.split("&");
		for (String pair : pairs) {
			String[] nameValue = pair.split("=");
			if (nameValue.length == 1) {
				params.add(new SelectableNamedValue(nameValue[0], ""));
			} else {
				params.add(new SelectableNamedValue(nameValue[0], nameValue[1]));
			}
		}
	}
}
