package ru.job4j.chess.firuges;

import org.junit.Test;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void whenPosition () {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        assertThat(bishopBlack.position(), is(Cell.A1));
    }

    @Test
    public void whenCopy () {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Figure figureCopy = bishopBlack.copy(Cell.A2);
        assertThat(figureCopy.position(), is(Cell.A2));
    }

    @Test
    public void whenWay () {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishopBlackStep = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(bishopBlackStep, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }
}
