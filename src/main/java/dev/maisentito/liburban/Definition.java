/*
 * Definition.java Copyright (c) 2015 forsenonlhaimaisentito This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package dev.maisentito.liburban;

import java.net.URL;

/**
 * Represents a single definition for a term.
 */
public class Definition {
	public int		mId;
	public String	mWord;
	public String	mAuthor;
	public URL		mLink;
	public String	mDefinition;
	public String	mExample;
	public int		mThumbsUp;
	public int		mThumbsDown;
	public String	mCurrentVote;

	public String getAuthor() {
		return this.mAuthor;
	}

	public String getCurrentVote() {
		return this.mCurrentVote;
	}

	public String getDefinition() {
		return this.mDefinition;
	}

	public String getExample() {
		return this.mExample;
	}

	public int getId() {
		return this.mId;
	}

	public URL getLink() {
		return this.mLink;
	}

	public int getThumbsDown() {
		return this.mThumbsDown;
	}

	public int getThumbsUp() {
		return this.mThumbsUp;
	}

	public String getWord() {
		return this.mWord;
	}

	public void setAuthor(final String author) {
		this.mAuthor = author;
	}

	public void setCurrentVote(final String current_vote) {
		this.mCurrentVote = current_vote;
	}

	public void setDefinition(final String definition) {
		this.mDefinition = definition;
	}

	public void setExample(final String example) {
		this.mExample = example;
	}

	public void setId(final int id) {
		this.mId = id;
	}

	public void setLink(final URL link) {
		this.mLink = link;
	}

	public void setThumbsDown(final int thumbs_down) {
		this.mThumbsDown = thumbs_down;
	}

	public void setThumbsUp(final int thumbs_up) {
		this.mThumbsUp = thumbs_up;
	}

	public void setWord(final String word) {
		this.mWord = word;
	}
}