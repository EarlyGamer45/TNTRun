/**
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package tntrun.arena.status;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import org.bukkit.entity.Player;

public class PlayersManager {

	private HashMap<String, Player> players = new HashMap<String, Player>();
	private HashMap<String, Player> spectators = new HashMap<String, Player>();
	private HashMap<String, Player> lostPlayers = new HashMap<String, Player>();

	public boolean isInArena(String name) {
		return players.containsKey(name) || spectators.containsKey(name);
	}

	public int getPlayersCount() {
		return players.size();
	}

	public HashSet<Player> getAllParticipantsCopy() {
		HashSet<Player> p = new HashSet<Player>();
		p.addAll(players.values());
		p.addAll(spectators.values());
		return p;
	}

	public Collection<Player> getPlayers() {
		return Collections.unmodifiableCollection(players.values());
	}

	public HashSet<Player> getPlayersCopy() {
		return new HashSet<Player>(players.values());
	}

	public void add(Player player) {
		players.put(player.getName(), player);
	}

	public void remove(Player player) {
		players.remove(player.getName());
	}

	public boolean isSpectator(String name) {
		return spectators.containsKey(name);
	}
	
	public boolean isLostPlayer(String name) {
		return lostPlayers.containsKey(name);
	}

	public void addSpectator(Player player) {
		spectators.put(player.getName(), player);
	}

	public void removeSpecator(String name) {
		spectators.remove(name);
	}
	
	public void addLostPlayer(Player player) {
		lostPlayers.put(player.getName(), player);
	}

	public void removeLostPlayer(Player p) {
		lostPlayers.remove(p);
	}

	public Collection<Player> getSpectators() {
		return Collections.unmodifiableCollection(spectators.values());
	}
	public Collection<Player> getLostPlayers() {
		return Collections.unmodifiableCollection(lostPlayers.values());
	}

	public HashSet<Player> getSpectatorsCopy() {
		return new HashSet<Player>(spectators.values());
	}
	public HashSet<Player> getLostPlayersCopy() {
		return new HashSet<Player>(lostPlayers.values());
	}

}
