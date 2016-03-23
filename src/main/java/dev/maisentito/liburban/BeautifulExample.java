/*
 * BeautifulExample.java Copyright (c) 2015 forsenonlhaimaisentito This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU
 * General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package dev.maisentito.liburban;

class BeautifulExample {
	public static String bold(final String str) {
		return "\033[1m" + str + "\033[0m";
	}

	public static void main(final String[] args) {
		if (args.length < 1) {
			System.out.println("Usage:");
			System.out.println("\tliburban TERM [LIMIT=0 [FROM=0]]");
			return;
		}

		try {
			final Results results = UrbanDictionary.define(args[0]);

			if (results.getType() == Results.Type.NO_RESULTS) {
				System.out.format("Term `%s' not found.\n", BeautifulExample.bold(args[0]));
				return;
			}

			final int limit = args.length > 1 ? Integer.parseInt(args[1]) : results.getList().size();
			final int from = args.length > 2 ? Integer.parseInt(args[2]) : 0;

			int count = 0, i = 0;
			System.out.format("Search results for term `%s':\n\n", BeautifulExample.bold(args[0]));
			for (final Definition def : results.getList()) {
				if (i++ < from) {
					continue;
				}
				System.out.println("Word:");
				System.out.println("\t" + BeautifulExample.bold(def.getWord()));
				System.out.println("Definition:");
				System.out.println("\t" + def.getDefinition().replace("\n", "\n\t"));
				System.out.println();
				System.out.println("Examples:");
				System.out.println("\t" + def.getExample().replace("\n", "\n\t"));
				System.out.println();
				System.out.format("Up: %d\tDown: %d\n", def.getThumbsUp(), def.getThumbsDown());
				if (++count >= limit) {
					break;
				}
				System.out.println("--------\n");
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
