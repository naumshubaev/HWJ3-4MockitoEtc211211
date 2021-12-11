package ru.netology.movies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoviesManagerTest {
    private MoviesManager manager = new MoviesManager();

    private MovieInfo first = new MovieInfo(1, "1984");
    private MovieInfo second = new MovieInfo(2, "451");
    private MovieInfo third = new MovieInfo(3, "third");
    private MovieInfo fourth = new MovieInfo(4, "1984SE");
    private MovieInfo fifth = new MovieInfo(5, "451new");
    private MovieInfo sixth = new MovieInfo(6, "sixth");
    private MovieInfo seventh = new MovieInfo(7, "1984");
    private MovieInfo eighth = new MovieInfo(8, "second451");
    private MovieInfo ninth = new MovieInfo(9, "third");
    private MovieInfo tenth = new MovieInfo(10, "BNW");
    private MovieInfo eleventh = new MovieInfo(11, "second451");
    private MovieInfo twelfth = new MovieInfo(12, "third");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

    }

    @Test
    public void getAll() {

        MovieInfo[] actualAll = manager.getAll();
        MovieInfo[] expected = new MovieInfo[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actualAll);
    }

    @Test
    public void getAllDisplayTwelveElements() {
        manager.setMaxLength(12);

        MovieInfo[] actualAll = manager.getAll();
        MovieInfo[] expected = new MovieInfo[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actualAll);
    }

    @Test
    public void getAllDisplayThreeElements() {
        manager.setMaxLength(1);

        MovieInfo[] actualAll = manager.getAll();
        MovieInfo[] expected = new MovieInfo[]{twelfth}

        assertArrayEquals(expected, actualAll);
    }

    @Test
    public void getAllIfOnlyTwoElementsExist() {
        MoviesManager manager = new MoviesManager();

        MovieInfo first = new MovieInfo(1, "1984");
        MovieInfo second = new MovieInfo(2, "451");

        manager.add(first);
        manager.add(second);

        MovieInfo[] actualAll = manager.getAll();
        MovieInfo[] expected = new MovieInfo[]{second, first};

        assertArrayEquals(expected, actualAll);

    }

    @Test
    public void getAllIfTheArrayIsEmpty() {
        MoviesManager manager = new MoviesManager();

        MovieInfo[] actualAll = manager.getAll();
        MovieInfo[] expected = new MovieInfo[]{};

        assertArrayEquals(expected, actualAll);


        //   second, first};
    }
}
