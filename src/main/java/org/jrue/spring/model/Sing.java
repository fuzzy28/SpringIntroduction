package org.jrue.spring.model;

public class Sing implements Performer{

	private String song;
	
	public Sing(String song) {
		this.song = song;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	@Override
	public void perform() {
		System.out.println("Singing song " + song);
	}

}
