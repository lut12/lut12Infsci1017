public class MusicTester
{
	public static void main(String [] args)
	{
		
		Song s1 = new Song("'1'");
		System.out.println(s1.getTitle());
		System.out.println(s1.getLength());
		System.out.println(s1.getRecordDate());
		System.out.println(s1.getReleaseDate());
		
		Artist a1 = new Artist("'036a0465-27cc-47db-b32f-f11f1a992ce8'");
		System.out.println(a1.getFirstName());
		System.out.println(a1.getLastName());
		System.out.println(a1.getBandName());
		System.out.println(a1.getBio());
		
		Album b1 = new Album("'0f451af6-d39f-4387-8437-764025a18352'");
		System.out.println(b1.getTitle());
		System.out.println(b1.getReleaseDate());
		System.out.println(b1.getCoverImagePath());
		System.out.println(b1.getRecordingCompany());*/
		
		Song s2 = new Song("'0304f2e8-f12b-4938-9d87-3323c51ee105'");
		s2.setTitle("The Combine");
		s2.setLength(4);
		s2.setRecordDate("1969-05-08 00:00:00");
		s2.setReleaseDate("1969-05-08 00:00:00");
		s2.addArtist("0208d02c-191e-4e58-9103-f474b9253581");
		s2.deleteArtist("0208d02c-191e-4e58-9103-f474b9253581");
		s2.deleteSong("0304f2e8-f12b-4938-9d87-3323c51ee105");
		
		
		Artist a2 = new Artist("'0208d02c-191e-4e58-9103-f474b9253581'");
		a2.setBandName("John Maus");
		a2.setFirstName("John");
		a2.setLastName("Maus");
		a2.setBio("Musician");
		a2.deleteArtist("0208d02c-191e-4e58-9103-f474b9253581");
		s2.deleteArtist2(a2);
		
		
		Album b2 = new Album("'0f451af6-d39f-4387-8437-764025a18352'");
		b2.setTitle("Screen Memories");
		b2.setReleaseDate("1969-05-08 00:00:00");
		b2.setCoverImagePath("images/revolver.jpg");
		b2.setRecordingCompany("Epic");
		b2.addSong("0304f2e8-f12b-4938-9d87-3323c51ee105");
		b2.deleteSong("0304f2e8-f12b-4938-9d87-3323c51ee105");
		b2.deleteSong2(s2);
		b2.deleteAlbum("0f451af6-d39f-4387-8437-764025a18352");
		
		
		
		
		
	}
}
