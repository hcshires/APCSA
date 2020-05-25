package Sample2020;

import java.util.ArrayList;

public class ReviewCollector {

    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    public ReviewCollector() {
        reviewList = new ArrayList<ProductReview>();
        productList = new ArrayList<String>();
    }

    /* Part A */
    public void addReview(ProductReview prodReview) {
        reviewList.add(prodReview);

        boolean addName = true;

        for (String productName : productList) {
            if (productName.equals(prodReview.getName())) {
                addName = false;
                break;
            }
        }

        if (addName) {
            productList.add(prodReview.getName());
        }
    }

    /* Part B */
    public int getNumGoodReviews(String prodName) {
        int counter = 0;

        for (ProductReview productReview : reviewList) {
            if (productReview.getName().equals(prodName) && productReview.getReview().indexOf("best") != -1) {
                counter++;
            }
        }

        return counter;
    }

    /* Part C */

    /*
        public ArrayList<ProductReview> getBestReviewsByProduct(String prodName)

        I need a new local variable in the method, which will be an ArrayList containing ProductReview objects representing the ArrayList
        to store the best reviews for the specific product name parameter. I will revise the existing if statement in the enhanced
        for loop to instead add the specified productReview object to the new ArrayList variable. Finally, instead of returning an
        integer, I will return the ArrayList variable after it finishes adding all of the good reviews in the for loop.
     */
}
