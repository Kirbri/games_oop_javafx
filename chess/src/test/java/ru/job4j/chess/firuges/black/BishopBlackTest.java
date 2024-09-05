package ru.job4j.chess.firuges.black;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void positionBishopBlackIsC8() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell actualBishopBlack = bishopBlack.position();
        Cell expected = Cell.C8;
        assertEquals(expected, actualBishopBlack);
    }

    @Test
    void copyBishopBlackIsF8ToA6() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Cell actualFigureBishopBlack = bishopBlack.copy(Cell.A6).position();
        Cell expected = Cell.A6;
        assertEquals(expected, actualFigureBishopBlack);
    }

    @Test
    void wayBishopBlackIsC1ToG5True() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] actualBishopBlack = bishopBlack.way(Cell.G5);
        Cell[] expectedCell = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(expectedCell, actualBishopBlack);
    }

    @Test
    void wayBishopBlackIsG5ToC1True() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] actualBishopBlack = bishopBlack.way(Cell.C1);
        Cell[] expectedCell = new Cell[]{Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertEquals(expectedCell, actualBishopBlack);
    }

    @Test
    void wayBishopBlackIsC7ToC2False() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C7);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    Cell[] actualBishopBlack = bishopBlack.way(Cell.C2);
                });
        Assertions.assertThat(exception.getMessage()).isEqualTo(String.format("Could not way by diagonal from %s to %s", Cell.C7, Cell.C2));
    }
}