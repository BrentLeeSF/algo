

class Cd {
	
	String artist;
	String album;
	int row;
	int col;
	int[] songs;
	Cd[][] arr;
	

	public Cd(int size) {
		arr = new Cd[size][size];
	}
	
	public Cd(String artist, String album, int row, int col, int[] songs) {
		this.artist = artist;
		this.album = album;
		this.row = row;
		this.col = col;
		this.songs = songs;
	}

	
	public void createJukeBox(String artist, String album, int row, int col, int[] songs) {
		
		String artistString = "";
		String albumString = "";
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				artistString = artist +i;
				albumString = album + j;
				arr[i][j] = new Cd(artistString.toString(), albumString.toString(), i, j, songs);
			}
		}
	}
	
	public String getArtist(int thisCol, int thisRow) {
		return arr[thisRow][thisCol].artist;
	}
	
	public String getAlbum(int thisCol, int thisRow) {
		return arr[thisRow][thisCol].album;
	}
	
	public int[] getSongList(int thisCol, int thisRow) {
		return arr[thisRow][thisCol].songs;
	}
	
	public int getSong(int thisCol, int thisRow, int thisSong) {
		return arr[thisRow][thisCol].songs[thisSong];
	}
	
}


public class JukeBox {

	public static void main(String[] args) {
		
		Cd cd = new Cd(10);
		int[] songs = {1,2,3,4,5,6,7,8,9,10};
		
		cd.createJukeBox("Artist", "Album", 10, 10, songs);

		int[] songList = cd.getSongList(5, 6);
		for(int i = 0; i < songList.length; i++) {
			System.out.println("song "+songList[i]+ ", from album "+cd.getAlbum(5,6).toString()+", from artist "+cd.getArtist(5,6).toString());
		}

		System.out.println("\nSong of Album 5 Artist 6 and Song Number 7 is: "+cd.getSong(5, 6, 7));
	}
	
}


