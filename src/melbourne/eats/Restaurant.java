/*
 * Restaurant.java - Extends Provider
 *
 * author Arian Najafi Yamchelo - s3910902@student.rmit.edu.au version 1.0 date March 13, 2022
 */

package melbourne.eats;

// Restaurant class
public class Restaurant extends Provider {

    private int starRating;

    public Restaurant(String[] line) {
        super(line);
    }

    // Set star rating for each Restaurant object
    public void setStarRating(int starRating){
        this.starRating = starRating;
    }
}