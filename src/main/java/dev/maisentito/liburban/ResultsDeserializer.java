/*
 * ResultsDeserializer.java Copyright (c) 2015 forsenonlhaimaisentito This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU
 * General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package dev.maisentito.liburban;

import java.lang.reflect.Type;
import java.util.Arrays;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

class ResultsDeserializer implements JsonDeserializer<Results> {

	@Override
	public Results deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
		final RawResults raw = context.deserialize(json, RawResults.class);

		final Results res = new Results();
		res.setTags(Arrays.asList(raw.tags));

		// TODO Type
		if (raw.result_type.equals("exact")) {
			res.setType(Results.Type.EXACT);
		} else if (raw.result_type.equals("no_results")) {
			res.setType(Results.Type.NO_RESULTS);
		}

		res.setList(Arrays.asList(raw.list));
		res.setSounds(Arrays.asList(raw.sounds));

		return res;
	}

}
