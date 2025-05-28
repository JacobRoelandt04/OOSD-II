package domein;

import java.util.Comparator;

public class Movie implements Comparable<Movie> {

    private double rating;
    private String name;
    private int year;

    // Constructor 
    public Movie(String name, double rating, int year) {
        setName(name);
        setRating(rating);
        setYear(year);
    }
    
    // Getter & setter methods for accessing private data 
    public double getRating() { return rating; }
    public String getName() { return name; }
    public int getYear() { return year; }
    private void setRating(double rating) { this.rating = rating; }
    private void setName(String name) { this.name = name; }
    private void setYear(int year) { this.year = year; }

	@Override
	public String toString() {
		return String.format("%s %.2f %d", name, rating, year);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	// Used to sort movies by year 
    @Override
	public int compareTo(Movie m) {
        int result = this.name.compareTo(m.getName());
        
        if (result == 0)
        	return this.getYear() - m.getYear();
        
        return result;
    }
    
    // Extra: Comparator als static geneste klasse in de klasse Movie
    /*
    public static class RatingCompare2 implements Comparator<Movie> {
        @Override
        public int compare(Movie m1, Movie m2) {
        	return Double.compare(m1.getRating(), m2.getRating());
        }
    }
    */
}


