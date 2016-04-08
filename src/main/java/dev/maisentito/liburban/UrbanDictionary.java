/*
 * UrbanDictionary.java Copyright (c) 2015 forsenonlhaimaisentito This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package dev.maisentito.liburban;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class UrbanDictionary {
	public static final String	API_BASE_URL		= "http://api.urbandictionary.com/v0";
	public static final String	ACTION_DEFINE		= "/define?term=";
	public static final String	ACTION_AUTOCOMPLETE	= "/autocomplete?term=";

	static InputStream apiRequest(final String action, final String term) throws IOException {
		try {
			final URL apiUrl = new URL(UrbanDictionary.API_BASE_URL + action + URLEncoder.encode(term, "UTF-8"));
			final URLConnection conn = apiUrl.openConnection();
			return conn.getInputStream();
		} catch (final UnsupportedEncodingException e) {
			// Unreachable
			e.printStackTrace();
		} catch (final MalformedURLException e) {
			// Also unreachable
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Returns a {@link java.util.List} of possible completions for <code>term</code>
	 *
	 * @param term
	 *            the partial text to auto-complete from
	 * @return a {@link java.util.List} of possible completions for <code>term</code>
	 * @throws IOException
	 */
	public static List<String> autocomplete(final String term) throws IOException {
		InputStream apiStream = null;
		try {
			apiStream = UrbanDictionary.apiRequest(UrbanDictionary.ACTION_AUTOCOMPLETE, term);
			final Reader resultsReader = new InputStreamReader(apiStream);
			final String[] results = new Gson().fromJson(resultsReader, String[].class);
			return Arrays.asList(results);
		} finally {
			Utils.closeQuietly(apiStream);
		}
	}

	/**
	 * Returns a {@link dev.maisentito.liburban.Results} object containing search results for the definition of the term
	 * <code>term</code>
	 *
	 * @param term
	 *            the term to search for
	 * @return a {@link dev.maisentito.liburban.Results} object holding search results
	 * @throws IOException
	 */
	public static Results define(final String term) throws IOException {
		InputStream apiStream = null;
		try {
			apiStream = UrbanDictionary.apiRequest(UrbanDictionary.ACTION_DEFINE, term);
			final Reader resultsReader = new InputStreamReader(apiStream);
			return UrbanDictionary.getDeserializer().fromJson(resultsReader, Results.class);
		} finally {
			Utils.closeQuietly(apiStream);
		}
	}

	private static Gson getDeserializer() {
		final GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Definition.class, new DefinitionDeserializer());
		builder.registerTypeAdapter(Results.class, new ResultsDeserializer());
		return builder.create();
	}
}