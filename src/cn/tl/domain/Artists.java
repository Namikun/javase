package cn.tl.domain;

import java.util.List;
import java.util.Optional;

public class Artists {

	private List<Artist> artists;

	public Artists(List<Artist> artists) {
		super();
		this.artists = artists;
	}

	public Optional<Artist> getArtist(int index) {
		if (index < 0 || index >= artists.size()) {
			return Optional.empty();
		}
		return Optional.of(artists.get(index));
	}

	public String getArtistName(int index) {
		return getArtist(index).map(Artist::getName).orElse("unknown");
	}
}
