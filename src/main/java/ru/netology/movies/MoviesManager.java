package ru.netology.movies;

// название MoviesManager для объекта, думаю, не самое правильное,
// но всё ведь пишем в одном классе
// поэтому так оставил - хоть и не оч.логично
public class MoviesManager {
    private MovieInfo[] items = new MovieInfo[0];

    public int maxLength = 10; // default maximum length of the array

    public MoviesManager(int maxLength) {
        this.maxLength = maxLength;
    }

    public MoviesManager() {
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

//    private MoviesManager[] items = new MoviesManager[0]; // it was a mistake, was it not?

    public void add(MovieInfo item) {
//        int length = items.length + 1; // WHY do we need an additional valuable? Does it improve testability?
        MovieInfo[] temp = new MovieInfo[items.length + 1];

        /*       for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        // this loop == System.arraycopy
        */
        System.arraycopy(items, 0, temp, 0, items.length);
        int lastIndex = temp.length - 1;
        temp[lastIndex] = item;
        items = temp;
    }

    public MovieInfo[] getAll() {

        MovieInfo[] itemsReversed = new MovieInfo[items.length];
        for (int i = 0; i < itemsReversed.length; i++) {
            int index = items.length - i - 1;
            itemsReversed[i] = items[index];
        }
            if (itemsReversed.length > maxLength) {
                MovieInfo[] tempForReversed = new MovieInfo[maxLength];
                System.arraycopy(itemsReversed, 0, tempForReversed, 0, maxLength);
                itemsReversed = tempForReversed;
            }
        return itemsReversed;
    }
}
