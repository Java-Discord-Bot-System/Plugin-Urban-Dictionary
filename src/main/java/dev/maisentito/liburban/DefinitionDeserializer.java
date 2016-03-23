/*
 * DefinitionDeserializer.java Copyright (c) 2015 forsenonlhaimaisentito This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU
 * General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package dev.maisentito.liburban;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

class DefinitionDeserializer implements JsonDeserializer<Definition> {

	@Override
	public Definition deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
		final RawDefinition raw = context.deserialize(json, RawDefinition.class);
		final Definition def = new Definition();
		def.setId(raw.defid);
		def.setWord(raw.word);
		def.setAuthor(raw.author);
		def.setLink(raw.permalink);
		def.setDefinition(raw.definition.replace("\r", ""));
		def.setExample(raw.example.replace("\r", ""));
		def.setThumbsUp(raw.thumbs_up);
		def.setThumbsDown(raw.thumbs_down);
		def.setCurrentVote(raw.current_vote);
		return def;
	}

}
