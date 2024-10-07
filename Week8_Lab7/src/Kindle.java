public class Kindle {

    private int numberOfPages;
    private int currentPage;

    public Kindle(){
        numberOfPages = 0;
        currentPage = 1;

    } //end of Kindle() constructor

    public Kindle(int theNumberOfPages) {
        numberOfPages = theNumberOfPages;
        currentPage = 1;

    } //end of Kindle(numberOfPages) constructor

    public String toString() {
        return ("Page " + currentPage + " of " + numberOfPages + ".");

    } //end of toString

    public void turnPages() {
        if (currentPage < numberOfPages) {
            currentPage = currentPage + 1;
        } else {
            System.out.println("Turning 1 page would take you past the last page.");
            currentPage = numberOfPages;
            System.out.println("You are now on : " + currentPage + " of " + numberOfPages + ".");
        }

    } //end of turnPages()

    public void turnPages(int pageNumber) {
        currentPage = currentPage + pageNumber;
        if (currentPage > numberOfPages) {
            System.out.println("Turning " + pageNumber + " pages would take you past the last page.");
            currentPage = numberOfPages;
            System.out.println("You are now on             : " + currentPage + " of " + numberOfPages + ".");
        } else {
        }

    } //end of turnPages(int pageNumber)






} //end of the Kindle class
