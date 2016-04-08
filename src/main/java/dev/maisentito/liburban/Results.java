/*
 * Results.java Copyright (c) 2015 forsenonlhaimaisentito This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package dev.maisentito.liburban;

import java.util.List;

/**
 * Holds the results for a term definition request.
 *
 * @see dev.maisentito.liburban.Definition
 */
public class Results {
	public static enum Type {
		EXACT, NO_RESULTS
	}

	private List<String>		mTags;
	private Type				mType;
	private List<Definition>	mDefinitions;
	private List<String>		mSounds;

	/**
	 * Returns a {@link java.util.List} of all the {@link dev.maisentito.liburban.Definition}s for the requested term
	 *
	 * @return a {@link java.util.List} of all the {@link dev.maisentito.liburban.Definition}s for the requested term
	 * @see dev.maisentito.liburban.Definition
	 */
	public List<Definition> getList() {
		return this.mDefinitions;
	}

	public List<String> getSounds() {
		return this.mSounds;
	}

	public List<String> getTags() {
		return this.mTags;
	}

	/**
	 * Returns the type of results, either {@link dev.maisentito.liburban.Results.Type#EXACT} or
	 * {@link dev.maisentito.liburban.Results.Type#NO_RESULTS}
	 *
	 * @return the type of results, either {@link dev.maisentito.liburban.Results.Type#EXACT} or
	 *         {@link dev.maisentito.liburban.Results.Type#NO_RESULTS}
	 */
	public Type getType() {
		return this.mType;
	}

	public void setList(final List<Definition> list) {
		this.mDefinitions = list;
	}

	public void setSounds(final List<String> sounds) {
		this.mSounds = sounds;
	}

	public void setTags(final List<String> tags) {
		this.mTags = tags;
	}

	public void setType(final Type type) {
		this.mType = type;
	}
}