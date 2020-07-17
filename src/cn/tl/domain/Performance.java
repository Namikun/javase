package cn.tl.domain;

import cn.tl.domain.Artist;

import java.util.stream.Stream;

public interface Performance {

	public String getName();

	public Stream<Artist> getMusicians();

	public default Stream<Artist> getAllMusicians(){
		return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist),artist.getMembers()));
	}
	
}
